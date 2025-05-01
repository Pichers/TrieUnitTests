package sut;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.From;
import org.junit.runner.RunWith;
import sut.generators.TSTGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class TSTQuickCheckPropertyTests {

    @Property
    public void insertionOrderDoesNotAffectValue(List<String> keys) {
        List<String> unique = new ArrayList<>(new java.util.HashSet<>(keys));
        TST<Integer> a = new TST<>();
        TST<Integer> b = new TST<>();

        for (int i = 0; i < unique.size(); i++) {
            a.put(unique.get(i), i);
        }

        Collections.shuffle(unique);
        for (int i = 0; i < unique.size(); i++) {
            b.put(unique.get(i), i);
        }

        assertEquals(a.size(), b.size());
        assertEquals(a.keys(), b.keys());
    }

    @Property
    public void removingAllKeysEmptiesTree(@From(TSTGenerator.class) TST<Integer> tst) {
        for (String key : tst.keys()) {
            tst.delete(key);
        }
        assertEquals(0, tst.size());
    }

    @Property
    public void insertAndDeleteSameKeyRestoresTree(
            @From(TSTGenerator.class) TST<Integer> original,
            String key,
            @InRange(minInt = 0, maxInt = 100) int value
    ) {
        if(Objects.equals(key, ""))
            return;
        TST<Integer> modified = new TST<>();
        for (String k : original.keys()) {
            modified.put(k, original.get(k));
        }

        modified.put(key, value);
        modified.delete(key);

        assertEquals(original.size(), modified.size());
        for (String k : original.keys()) {
            assertEquals(original.get(k), modified.get(k));
        }
    }

    @Property
    public void stricterPrefixReturnsSubset(@From(TSTGenerator.class) TST<Integer> tst) {
        String prefix = "su";
        List<String> suKeys = new ArrayList<>();
        for (String key : tst.keysWithPrefix(prefix)) {
            suKeys.add(key);
        }

        List<String> subKeys = new ArrayList<>();
        for (String key : tst.keysWithPrefix(prefix + "b")) {
            subKeys.add(key);
        }

        assertTrue(suKeys.containsAll(subKeys));
    }
}

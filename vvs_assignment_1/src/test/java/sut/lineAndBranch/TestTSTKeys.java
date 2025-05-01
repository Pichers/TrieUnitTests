package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTSTKeys {

    @Test
    void keysAllNull() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 23);
        tst.put("b", 55);
        tst.put("c", 100);

        tst.put("a", null);
        tst.put("b", null);
        tst.put("c", null);

        assertFalse(tst.keys().iterator().hasNext());
    }

    @Test
    void variousKeys() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 23);
        tst.put("b", 55);
        tst.put("c", 100);

        List<String> returnedKeys = new ArrayList<>();
        for (String key : tst.keys()) {
            returnedKeys.add(key);
        }
        List<String> expectedKeys = Arrays.asList("a", "b", "c");

        assertEquals(new HashSet<>(expectedKeys), new HashSet<>(returnedKeys));
    }
}
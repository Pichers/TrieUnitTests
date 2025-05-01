package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TestTSTKeysWithPrefix {

    @Test
    void keysWithPrefixNull() {
        TST<Integer> tst = new TST<>();
        tst.put("hello", 1);

        assertThrows(IllegalArgumentException.class, () -> tst.keysWithPrefix(null));
    }

    @Test
    void keysWithPrefixNormal() {
        String s1 = "hello", s2 = "world", s3 = "helicopter";

        TST<Integer> tst = new TST<>();
        tst.put(s1, 1);
        tst.put(s2, 2);
        tst.put(s3, 3);

        Set<String> expectedResult = new HashSet<>();
        expectedResult.add(s1);
        expectedResult.add(s3);

        Iterable<String> actualResult = tst.keysWithPrefix("hel");
        Set<String> arSet = new HashSet<>();

        for (String s : actualResult) {
            arSet.add(s);
        }
        assertEquals(expectedResult, arSet);
    }

    @Test
    void keysWithPrefixNoMatches() {
        String s1 = "hello", s2 = "world", s3 = "helicopter";

        TST<Integer> tst = new TST<>();
        tst.put(s1, 1);
        tst.put(s2, 2);
        tst.put(s3, 3);

        Iterable<String> actualResult = tst.keysWithPrefix("p");
        assertFalse(actualResult.iterator().hasNext());
    }

    @Test
    void keysWithPrefixEntireWord() {
        String s1 = "hello", s2 = "world", s3 = "helicopter";

        TST<Integer> tst = new TST<>();
        tst.put(s1, 1);
        tst.put(s2, 2);
        tst.put(s3, 3);

        Set<String> expectedResult = new HashSet<>();
        expectedResult.add(s1);

        Iterable<String> actualResult = tst.keysWithPrefix(s1);
        Set<String> arSet = new HashSet<>();

        for (String s : actualResult) {
            arSet.add(s);
        }
        assertEquals(expectedResult, arSet);
    }

}
package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestTSTKeysThatMatch {

//    @Test
//    void keysThatMatchNull() {
//        TST<Integer> tst = new TST<>();
//
//        tst.put("hello", 1);
//        tst.put("world", 2);
//
//        assertFalse(tst.keysThatMatch(null).iterator().hasNext());
//    }

//    @Test
//    void keysThatMatchEmpty() {
//        TST<Integer> tst = new TST<>();
//        tst.put("hello", 1);
//        tst.put("world", 2);
//
//        assertFalse(tst.keysThatMatch("").iterator().hasNext());
//    }

    @Test
    void keysThatMatchSparseDotsPattern() {
        TST<Integer> tst = new TST<>();

        tst.put("protein", 1);
        tst.put("plinto", 3);
        tst.put("partemn", 4);

        Set<String> expectedResult = new HashSet<>();
        expectedResult.add("protein");
        expectedResult.add("partemn");

        Iterable<String> actualResult = tst.keysThatMatch("p..te.n");
        Set<String> arSet = new HashSet<>();

        for (String s : actualResult) {
            arSet.add(s);
        }
        assertEquals(expectedResult, arSet);
    }

//    @Test
//    void keysThatMatchDifferentKeys() {
//        TST<Integer> tst = new TST<>();
//
//        tst.put("hello", 1);
//        tst.put("helicopter", 3);
//        tst.put("hippie", 4);
//        tst.put("hipnooseee", 5);
//
//        Set<String> expectedResult = new HashSet<>();
//        expectedResult.add("helicopter");
//        expectedResult.add("hipnooseee");
//
//        Iterable<String> actualResult = tst.keysThatMatch("h....o....");
//        Set<String> arSet = new HashSet<>();
//
//        for (String s : actualResult) {
//            arSet.add(s);
//        }
//        assertEquals(expectedResult, arSet);
//    }

}
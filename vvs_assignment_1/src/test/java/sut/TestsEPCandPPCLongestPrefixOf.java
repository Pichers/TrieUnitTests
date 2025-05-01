package sut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsEPCandPPCLongestPrefixOf {

    @Test
    // [1,2,3]
    void longestPrefixOfNullQuery() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 2);

        assertThrows(IllegalArgumentException.class, () -> tst.longestPrefixOf(null));
    }

    @Test
    // [1,2,4,5]
    void longestPrefixOfEmptyQuery() {
        TST<Integer> tst = new TST<>();
        assertNull(tst.longestPrefixOf(""));
    }

    @Test
    // [1,2,4,6,7,8]
    void longestPrefixOfNoRoot() {
        TST<Integer> tst = new TST<>();

        assertEquals("", tst.longestPrefixOf("a"));
    }

    @Test
    // [1,2,4,6,7,9,11,7,9,10,7,8]
    void longestPrefixOfWordWithoutPrefix() {
        TST<Integer> tst = new TST<>();
        tst.put("hello", 2);
        tst.put("world", 3);

        assertNull(tst.longestPrefixOf("india"));
    }

//    @Test
//    // [1,2,4,6,7,9,12,14,7, ... ,9,12,13,15,14,7,8]
//    void longestPrefixOfExistingWord() {
//        TST<Integer> tst = new TST<>();
//        tst.put("hello", 2);
//        tst.put("w", 3);
//
//        assertEquals("hello", tst.longestPrefixOf("hellooo"));
//    }

    @Test
    // [1,2,4,6,7,9,12,13,14,7,9,12,13,15,14,7,9,12,13,15,14,7,8]
    void longestPrefixOfNotLongest() {
        TST<Integer> tst = new TST<>();
        tst.put("he", 2);
        tst.put("hel", 3);
        tst.put("world", 3);

        assertEquals("hel", tst.longestPrefixOf("hello"));
    }

    // [1,2,4,6,7,9,12,13,15,14,7,8]
    void longestPrefixOfInstantMatch() {
        TST<Integer> tst = new TST<>();
        tst.put("h", 2);
        tst.put("world", 3);

        assertEquals("h", tst.longestPrefixOf("hello"));
    }

    @Test
    // [1,2,4,6,7,9,10,7,9,12,13,14,7,9,11,7,9,12,13,14,7,9,12,13,15,14,7,9,10,9,12,13,15,14,7,8]
    void longestPrefixOfImmediateLeft() {
        TST<Integer> tst = new TST<>();
        tst.put("hello", 2);
        tst.put("world", 3);
        tst.put("damn", 0);
        tst.put("dis", 4);
        tst.put("distress", 5);
        tst.put("disa", 6);

        assertEquals("disa", tst.longestPrefixOf("disarm"));
    }

    // [1,2,4,6,7,9,12,13,14,7,9,11,7,9,12,13,15,14,7,8]
    void longestPrefixOfImmediateRight() {
        TST<Integer> tst = new TST<>();
        tst.put("da", 5);
        tst.put("dt", 6);

        assertEquals("dt", tst.longestPrefixOf("dtt"));
    }

    @Test
    // [1,2,4,6,7,9,10,7,9,10,7,9,11,7,9,11,7,8]
    void longestPrefixOfLeftLeftRightRightMiss() {
        TST<Integer> tst = new TST<>();
        tst.put("mate", 5);
        tst.put("fancy", 6);
        tst.put("arm", 9);
        tst.put("battle", 10);

        assertNull(tst.longestPrefixOf("car"));
    }

    @Test
    // [1,2,4,6,7,9,12,13,14,7,9,10,7,9,12,13,15,14,7,8]
    void longestPrefixOfHitLeftHitValue() {
        TST<Integer> tst = new TST<>();
        tst.put("must", 5);
        tst.put("me", 9);

        assertEquals(tst.longestPrefixOf("mentor"), "me");
    }

    @Test
    // [1,2,4,6,7,9,12,13,14,7,9,12,13,15,14,7,9,11,7,9,12,13,15,14,7,9,12,13,15,14,7,8]
    void longestPrefixOfBackToBackHits() {
        TST<Integer> tst = new TST<>();
        tst.put("hi", 2);
        tst.put("hit", 7);
        tst.put("hip", 4);
        tst.put("hipp", 5);

        assertEquals("hipp", tst.longestPrefixOf("hippopotamus"));
    }

    @Test
    // [1,2,4,6,7,9,12,13,14,7,9,12,13,14,7,8]
    void longestPrefixOfaPrefix() {
        TST<Integer> tst = new TST<>();
        tst.put("hello", 2);
        tst.put("world", 3);

        assertNull(tst.longestPrefixOf("he"));
    }

    @Test
    // [1,2,4,6,7,9,10,7,8]
    void longestPrefixOfEndingNoXLeft(){
        TST<Integer> tst = new TST<>();
        tst.put("ze", 2);

        assertNull(tst.longestPrefixOf("part"));
    }

    @Test
    // [1,2,4,6,7,9,12,13,14,7,9,11,7,8]
    void longestPrefixOfEndingNoXRight(){
        TST<Integer> tst = new TST<>();
        tst.put("pe", 2);

        assertNull(tst.longestPrefixOf("post"));
    }
}
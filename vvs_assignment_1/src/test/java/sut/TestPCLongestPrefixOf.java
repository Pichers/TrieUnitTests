package sut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPCLongestPrefixOf {

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

    @Test
    // [1,2,4,6,7,9,12,13,14,7,9,12,13,15,14,7,9,12,13,15,14,7,8]
    void longestPrefixOfNotLongest() {
        TST<Integer> tst = new TST<>();
        tst.put("he", 2);
        tst.put("hel", 3);
        tst.put("world", 3);

        assertEquals("hel", tst.longestPrefixOf("hello"));
    }
}

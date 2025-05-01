package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import static org.junit.jupiter.api.Assertions.*;

class TestTSTPut {

    @Test
    void putNullKey() {
        TST<Integer> tst = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> {
            tst.put(null, 3);
        });
    }
//    @Test
//    void putEmptyKey() {
//        TST<Integer> tst = new TST<>();
//        tst.put("bar", 1);
//
//        assertFalse(tst.contains("cop"));
//    }

    @Test
    void putNewKey() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 23);

        assertTrue(tst.contains("a"));
        assertEquals((Integer) 23, tst.get("a"));
    }

    @Test
    void putExistingKey() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 23);
        tst.put("b", 55);

        tst.put("a", 24);

        assertTrue(tst.contains("a"));
        assertEquals((Integer) 24, tst.get("a"));
        assertEquals(2, tst.size());
    }
}
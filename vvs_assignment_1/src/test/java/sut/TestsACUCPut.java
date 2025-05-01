package sut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsACUCPut {
    @Test
    // [1,2,3,4,8,9]
    void putNewKey() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 23);

        assertTrue(tst.contains("a"));
        assertEquals((Integer) 23, tst.get("a"));
    }

    @Test
    // [1,2,3,4,8,9] / [1,2,4,6] / [1,2,4,8,9]
    void putExistingKey() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 23);
        tst.put("b", 55);

        tst.put("a", 24);

        assertTrue(tst.contains("a"));
        assertEquals((Integer) 24, tst.get("a"));
        assertEquals(2, tst.size());
    }

    @Test
    // [1,2,3,4,8,9] / [1,2,4,5]
    void putKeyToLeft() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("a", 55);

        assertTrue(tst.contains("a"));
        assertEquals((Integer) 55, tst.get("a"));
        assertEquals(2, tst.size());
    }

    @Test
        // [1,2,3,4,8,9] / [1,2,4,7...1,2,3,4,8,9]
    void putKeyInCenter() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("ca", 55);

        assertTrue(tst.contains("ca"));
        assertEquals((Integer) 55, tst.get("ca"));
        assertEquals(2, tst.size());
    }

}
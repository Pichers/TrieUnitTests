package sut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestACUCPut {
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
    // [1,2,3,4,8,9] / [1,2,4,5...1,2,3,4,8,9]
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
    void putKeyInMid() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("ca", 55);

        assertTrue(tst.contains("ca"));
        assertEquals((Integer) 55, tst.get("ca"));
        assertEquals(2, tst.size());
    }

    @Test
    // [1,2,3,4,8,9] / [1,2,4,6...1,2,3,4,8,9]
    void putKeyToRight() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("f", 55);

        assertTrue(tst.contains("f"));
        assertEquals((Integer) 55, tst.get("f"));
        assertEquals(2, tst.size());
    }

    @Test
    // [1,2,3,4,8,9] / [1,2,4,7...1,2,3,4,8,9] / 1,2,4,7...1,2,4,5...1,2,3,4,8,9]
    void putKeyInMidThenLeft() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("ct", 55);
        tst.put("ca", 66);

        assertTrue(tst.contains("ca"));
        assertEquals((Integer) 66, tst.get("ca"));
        assertEquals(3, tst.size());
    }
    @Test
    // [1,2,3,4,8,9] / [1,2,4,5...1,2,3,4,8,9] / 1,2,4,5...1,2,4,7...1,2,3,4,8,9]
    void putKeyInLeftThenMid() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("a", 55);
        tst.put("ab", 66);

        assertTrue(tst.contains("ab"));
        assertEquals((Integer) 66, tst.get("ab"));
        assertEquals(3, tst.size());
    }

    @Test
        // [1,2,3,4,8,9] / [1,2,4,6...1,2,3,4,8,9] / 1,2,4,6...1,2,4,7...1,2,3,4,8,9]
    void putKeyInRightThenMid() {
        TST<Integer> tst = new TST<>();
        tst.put("c", 23);
        tst.put("d", 55);
        tst.put("db", 66);

        assertTrue(tst.contains("db"));
        assertEquals((Integer) 66, tst.get("db"));
        assertEquals(3, tst.size());
    }

}
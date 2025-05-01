package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import static org.junit.jupiter.api.Assertions.*;
class TestTSTGet {

    @Test
    void getNullKey() {
        TST<Integer> tst = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> {
            tst.get(null);
        });
    }

    @Test
    void getEmptyKey() {
        TST<Integer> tst = new TST<>();
        assertThrows(IllegalArgumentException.class, () -> {
            tst.get("");
        });
    }

    @Test
    void getKeyThatDoesNotExist() {
        TST<Integer> tst = new TST<>();
        tst.put("bar", 1);

        assertNull(tst.get("cop"));
    }

    @Test
    void getKeyThatExists() {
        TST<Integer> tst = new TST<>();
        tst.put("MP4-4", 1);
        tst.put("MP4-2b", 2);
        tst.put("RB8", 3);

        assertEquals((Integer) 2, tst.get("MP4-2b"));
    }
}
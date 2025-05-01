package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import static org.junit.jupiter.api.Assertions.*;

class TestTSTContains {

    @Test
    void containsNullKey() {
        TST<Integer> tst = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> {
            tst.contains(null);
        });
    }

    @Test
    void containsKeyThatDoesNotExist() {
        TST<Integer> tst = new TST<>();
        tst.put("bar", 1);

        assertFalse(tst.contains("cop"));
    }

    @Test
    void containsKeyThatExists() {
        TST<Integer> tst = new TST<>();
        tst.put("MP4-4", 1);
        tst.put("MP4-2b", 2);
        tst.put("RB8", 3);

        assertTrue(tst.contains("MP4-2b"));
    }
}
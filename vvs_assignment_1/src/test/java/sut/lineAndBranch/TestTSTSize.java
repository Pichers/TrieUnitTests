package sut.lineAndBranch;

import org.junit.jupiter.api.Test;
import sut.TST;

import static org.junit.jupiter.api.Assertions.*;

class TestTSTSize {

    @Test
    void size() {
        TST<Integer> tst = new TST<>();

        tst.put("hello", 1);
        tst.put("world", 2);
        tst.put("bye", 3);

        assertEquals(3, tst.size());
    }
}
package sut;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBCCPut {

    //Base choice:
    // Trie is Empty: True
    // Prefix in Trie: False
    // Key type: Typical
    // New Key in Trie: False
    @Test
    public void baseCase_typicalKey_insert() {
        TST<Integer> tst = new TST<>();
        tst.put("my", 1);
        assertEquals((Integer)1, tst.get("my"));
    }

    // Trie is Empty: True / False
    // Prefix in Trie: False
    // Key type: Typical
    // New Key in Trie: True
    @Test
    public void insertExistingKey_overwritesValue() {
        TST<Integer> tst = new TST<>();
        tst.put("my", 1);
        tst.put("my", 99);
        assertEquals((Integer) 99, tst.get("my"));
    }

    // Trie is Empty: True
    // Prefix in Trie: True
    // Key type: Typical
    // New Key in Trie: False
    @Test
    public void insertKeyWithExistingPrefix() {
        TST<Integer> tst = new TST<>();
        tst.put("he", 1);
        tst.put("hello", 2);
        assertEquals((Integer)1, tst.get("he"));
        assertEquals((Integer)2, tst.get("hello"));
    }

    // Trie is Empty: True
    // Prefix in Trie: False
    // Key type: Smallest
    // New Key in Trie: False
    @Test
    public void insertSmallestLexKey() {
        TST<Integer> tst = new TST<>();
        tst.put("a", 1);
        assertEquals((Integer)1, tst.get("a"));
    }

    // Trie is Empty: True
    // Prefix in Trie: False
    // Key type: Largest
    // New Key in Trie: False
    @Test
    public void insertLargestLexKey() {
        TST<Integer> tst = new TST<>();
        tst.put("zzz", 2);
        assertEquals((Integer)2, tst.get("zzz"));
    }

}

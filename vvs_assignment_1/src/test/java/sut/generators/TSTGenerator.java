package sut.generators;

import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import sut.TST;

import java.util.List;

public class TSTGenerator extends Generator<TST<Integer>> {

    public TSTGenerator() {
        super((Class<TST<Integer>>) (Object) TST.class);
    }

    @Override
    public TST<Integer> generate(SourceOfRandomness random, GenerationStatus status) {
        TST<Integer> tst = new TST<>();
        int size = random.nextInt(1, 10);
        for (int i = 0; i < size; i++) {
            String key = randomString(random, random.nextInt(1, 5));
            int val = random.nextInt(0, 100);
            tst.put(key, val);
        }
        return tst;
    }

    private String randomString(SourceOfRandomness random, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) random.nextChar('a', 'z'));
        }
        return sb.toString();
    }
}

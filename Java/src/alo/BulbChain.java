package src.alo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class BulbChain {

    public int solution(int[] A) {
        int n = Arrays.stream(A).max().getAsInt();

        List<BitSet> bitSets = new ArrayList<>();

        //init
        for(int i = 1; i <= n; i++) {
            BitSet bitSet = new BitSet();
            for (int j = 1; j <= i; j++) {
                bitSet.set(j);
            }
            bitSets.add(bitSet);
        }
        BitSet bulbs = new BitSet();

        int maxN = -1;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            bulbs.set(A[i]);
            maxN = Math.max(maxN, A[i]);
            BitSet compare = (BitSet) bitSets.get(maxN - 1).clone();
            compare.xor(bulbs);
            if(compare.cardinality() == 0) {
                count++;
            }
        }

        return count;
    }
}

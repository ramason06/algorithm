package src.alo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxEdgeWeight {
    class Pair {
        int vertex;
        int linkedVertex;

        Pair(int a, int b) {
            this.vertex = a;
            this.linkedVertex = b;
        }
    }

    public int solution(int N, int[] A, int[] B) {
        ArrayList<Integer>[] al = new ArrayList[N+1];

        // initializing
        for (int i = 0; i < N+1; i++) {
            al[i] = new ArrayList<Integer>();
        }

        //make edge
        for(int i = 0; i < A.length; i++) {
            al[A[i]].add(B[i]);
            al[B[i]].add(A[i]);
        }

        List<Pair> pairs = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            pairs.add(new Pair(i, al[i].size()));
        }

        Collections.sort(pairs, Comparator.comparingInt(a -> a.linkedVertex));

        int[] ansArr = new int[N + 1];

        for(int i = 1; i <= N; i ++) {
            Pair pair = pairs.get(i-1);
            ansArr[pair.vertex] = i;
        }

        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans += ansArr[A[i]];
            ans += ansArr[B[i]];
        }

        return ans;
    }
}

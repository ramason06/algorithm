package src.alo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Yanol4 {
    public int solution(int[] A) {
        int sizz = A.length;
        int[] arr = new int[sizz+10];
        List<Integer> overlapIndex = new ArrayList<>();
        for(int i = 0; i<sizz; i++) {
            arr[A[i]]++;
            if(arr[A[i]] == 2) {
                overlapIndex.add(A[i]);
            }
        }

        overlapIndex.sort(Comparator.naturalOrder());

        long ans = 0L;
        for(int i = 1; i<=sizz; i++) {
            if(arr[i] == 0) {
                ans += Math.abs(i - overlapIndex.get(0));
                arr[i]++;
                arr[overlapIndex.get(0)]--;
                if(arr[overlapIndex.get(0)] == 1) {
                    overlapIndex.remove(0);
                }
            }
        }

        return (ans > 1000000000L) ? -1 : Long.valueOf(ans).intValue();
    }
}

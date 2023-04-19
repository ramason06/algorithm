package src.alo;

import java.util.ArrayList;
import java.util.List;

public class ThreeOne {
    static boolean[] arr = new boolean[1000010];
    static List<Integer> brr = new ArrayList<>();
    public void threeOne(int cur, int cnt) {
        arr[cur] = true;
        if(cur == 1) {
            brr.add(cnt+1);
            return;
        }

        if((cur % 2) == 0) {
            int nextVal = cur / 2;
            if(!(nextVal < 1) && !arr[nextVal]) {
                threeOne(nextVal, cnt + 1);
            }
        } else {
            int nextVal = cur*3+1;
            if(!(nextVal < 1) && !arr[nextVal]) {
                threeOne(nextVal, cnt + 1);
            }
        }
    }
}

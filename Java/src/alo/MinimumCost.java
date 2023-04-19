package src.alo;

import java.util.ArrayList;
import java.util.List;

public class MinimumCost {
    private static List<Long> minimmCost(List<Integer> red, List<Integer> blue, int blueCost) {
        List<Long> ans = new ArrayList<>();
        int num = red.size();
        ans.add(0L);
        boolean isBlue = false;
        for(int i = 0; i < num; i++) {
            Long current = ans.get(i);
            if(!isBlue) {
                if (red.get(i) + current >= blue.get(i) + blueCost + current) {
                    ans.add(blueCost + blue.get(i) + ans.get(i));
                    isBlue = true;
                } else {
                    ans.add(red.get(i) + ans.get(i));
                }
            } else {
                if (red.get(i) + current >= blue.get(i) + current) {
                    ans.add(blue.get(i) + ans.get(i));
                } else {
                    ans.add(red.get(i) + ans.get(i));
                    isBlue = false;
                }
            }
        }
        return ans;
    }
}

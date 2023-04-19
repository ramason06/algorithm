package src.alo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        int lIdx = 0;
        int rIdx = 0;

        Map<Character, Integer> hashMap = new HashMap<>();

        int maxx = 2;

        while (rIdx < n) {
            if (hashMap.size() < 3)
                hashMap.put(s.charAt(rIdx), rIdx++);

            if (hashMap.size() == 3) {
                int minIdx = Collections.min(hashMap.values());
                hashMap.remove(s.charAt(minIdx));
                lIdx = minIdx + 1;
            }

            maxx = Math.max(maxx, rIdx - lIdx);
        }
        return maxx;
    }
}





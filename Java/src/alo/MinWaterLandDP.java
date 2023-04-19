package src.alo;

public class MinWaterLandDP {
    static int[] landVal;
    int minn = Integer.MAX_VALUE;
    int landCnt = 0;
    int[][][][] dp;
    public int sol(int pos, boolean check, int cnt, int val) {
        if(check) {
            val += landVal[pos];
        }
        if(cnt == landCnt - 1) {
            return val;
        }
        if(pos + 1 == landVal.length-1) {
            return Integer.MAX_VALUE;
        }

        if(check) {
            if(dp[pos][1][cnt][val] != 0) {
                return dp[pos][1][cnt][val];
            }
            minn = Math.min(minn, sol(pos + 1, false, cnt, val));
        } else {
            if(dp[pos][0][cnt][val] != 0){
                return dp[pos][0][cnt][val];
            }
            minn = Math.min(minn, Math.min(sol(pos + 1, false, cnt, val), sol(pos+1, true, cnt+1, val)));
        }

        return minn;
    }
}

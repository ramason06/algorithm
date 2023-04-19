package src.alo;

public class BinaryGap {
    public int solution(int N) {
        int max_gap = 0;
        int con_gap = 0;
        boolean one_flag = false;
        while(N != 0) {
            int mod = N % 2;
            if(one_flag && mod == 0) {
                con_gap++;
                max_gap = Math.max(max_gap, con_gap);
            } else if(mod == 1) {
                one_flag = true;
                con_gap = 0;
            }
            N = N / 2;
        }
        return max_gap;
    }
}

package src.alo;

public class JumpGame {
    public String solution(int A, int B, int C) {
        StringBuilder builder = new StringBuilder();
        int total = A + B + C;
        int a =0 ,b = 0,c = 0;


        for(int i = 0; i<total; i++) {
            if((A >= B && A >= C && a != 2) || (A > 0 && (b == 2 || c ==2))) {
                builder.append("a");
                a++;
                b = 0;
                c = 0;
                A--;
            } else if((B >= A && B >= C && b != 2) || (B > 0 && (a == 2 || c ==2))) {
                builder.append("b");
                b++;
                a = 0;
                c = 0;
                B--;
            } else if((C >= B && C >= A && c != 2) || (C> 0 && (b == 2 || a ==2))) {
                builder.append("c");
                c++;
                a = 0;
                b = 0;
                C--;
            }
        }
        return builder.toString();
    }
}

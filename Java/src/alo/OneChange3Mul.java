package src.alo;

public class OneChange3Mul {
    public int solution(String S) {
        int len = S.length();
        int count = 0;
        int origin = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == S.charAt(i) - '0') {
                    origin += j;
                    continue;
                }
                char[] s = S.toCharArray();
                s[i] = (char)(j + '0');
                if(sumAndTh(s)) {
                    count++;
                }
            }
        }

        if((origin % 3) == 0){
            count++;
        }

        return count;
    }

    public boolean sumAndTh(char[] s) {
        long sum = 0;
        for (char c : s) {
            sum += c - '0';
        }
        return ((sum % 3) == 0);
    }
}

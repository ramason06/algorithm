package src;

public class BackPressCompare {
    public boolean backspaceCompare(String S, String T) {
        int tIdx = T.length() - 1;
        int sIdx = S.length() - 1;
        while(sIdx > -1 && tIdx > -1) {
            if(S.charAt(sIdx) != '#') {
                if(T.charAt(tIdx) != '#') {
                    //둘다 제대로된 숫자
                    if(S.charAt(sIdx) != T.charAt(tIdx)) {
                        return false;
                    } else {
                        sIdx-=1;
                        tIdx-=1;
                    }
                }
                else {
                    tIdx-=2;
                }
            }
            else if(T.charAt(tIdx) != '#') {
                sIdx-=2;
            }
            else {
                sIdx-=2;
                tIdx-=2;
            }
        }

        if(sIdx <= 0 && tIdx <= 0) {
            return true;
        }
        return false;
    }
}

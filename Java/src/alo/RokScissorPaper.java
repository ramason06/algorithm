package src.alo;

public class RokScissorPaper {
    public int solution(String G) {
        int[] arr = new int[3];

        for(char c : G.toCharArray()) {
            if(c == 'R') {
                arr[0]++;
            }
            if(c == 'S') {
                arr[1]++;
            }
            if(c == 'P') {
                arr[2]++;
            }
        }

        int R = arr[0] + arr[1]*2;
        int S = arr[1] + arr[2]*2;
        int P = arr[2] + arr[0]*2;
        int max_val = R;
        max_val = Math.max(S,max_val);
        max_val = Math.max(P,max_val);

        return max_val;
    }
}

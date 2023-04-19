package src.alo;

public class RotateMatrix {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows+2][columns+2];
        int num = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                arr[i][j] = num;
                num++;
            }
        }

        int[] answer = new int[queries.length];

        int qNum = 0;
        for(int[] query : queries) {
            int y1 = query[0];
            int x1 = query[1];
            int y2 = query[2];
            int x2 = query[3];
            int firstNum = arr[y1][x2];
            int minNum = firstNum;

            //위 ->
            for(int i = x2; i > x1; i--) {
                minNum = Math.min(minNum, arr[y1][i]);
                arr[y1][i] = arr[y1][i-1];
            }

            //왼 위 -> 아래
            for(int i = y1; i<y2; i++) {
                minNum = Math.min(minNum, arr[i][x1]);
                arr[i][x1] = arr[i+1][x1];
            }

            //아래
            for(int i = x1; i < x2; i++) {
                minNum = Math.min(minNum, arr[y2][i]);
                arr[y2][i] = arr[y2][i+1];
            }

            //오
            for(int i = y2; i > y1; i--) {
                minNum = Math.min(minNum, arr[i][x2]);
                arr[i][x2] = arr[i - 1][x2];
            }
            arr[y1+1][x2] = firstNum;

            answer[qNum] = minNum;
            qNum++;
        }
        return answer;
    }
}

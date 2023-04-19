package src.alo;

public class RotateMatrixFailed {
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
            int preX = x2;
            for(int i = 0; i < x2 - x1; i++) {
                minNum = Math.min(minNum, arr[y1][preX]);
                arr[y1][preX] = arr[y1][preX-1];
                preX--;
            }

            //왼 위 -> 아래
            int preY = y1;
            for(int i = 0; i < y2 - y1; i++) {
                minNum = Math.min(minNum, arr[preY][x1]);
                arr[preY][x1] = arr[preY+1][x1];
                preY++;
            }

            //아래
            preX = x1;
            for(int i = 0; i < x2 - x1; i++) {
                minNum = Math.min(minNum, arr[y2][preX]);
                arr[y2][preX] = arr[y2][preX+1];
                preX++;
            }

            //오
            preY = y2;
            for(int i = 0; i < y2 - y1; i++) {
                minNum = Math.min(minNum, arr[preY][x2]);
                arr[preY][x2] = arr[preY - 1][x2];
                preY--;
            }
            arr[y1+1][x2] = firstNum;

            answer[qNum] = minNum;
            qNum++;
        }
        return answer;
    }
}
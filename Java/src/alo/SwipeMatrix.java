package src.alo;

public class SwipeMatrix {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows+1][columns+1];
        int num = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                arr[i][j] = num;
                num++;
            }
        }

        for(int[] query: queries) {
            if(query[0] == 1) {
                arr = d1(arr, query);
            }
            if(query[0] == 2) {
                arr = d2(arr, query);
            }
            if(query[0] == 3) {
                arr = d3(arr, query);
            }
            if(query[0] == 4) {
                arr = d3(arr, query);
            }
        }

        return queries[0];
    }

    private int[][] d1(int[][] arr, int[] query) {
        int y1 = query[1];
        int x1 = query[2];
        int y2 = query[3];
        int x2 = query[4];

        for(int i = x1; i <= x2; i++) {
            int firstNum = arr[y2][i];
            for(int j = y2; j > y1; j--) {
                arr[j][i] = arr[j-1][i];
            }
            arr[y1][i] = firstNum;
        }
        return arr;
    }

    private int[][] d2(int[][] arr, int[] query) {
        int y1 = query[1];
        int x1 = query[2];
        int y2 = query[3];
        int x2 = query[4];

        for(int i = x1; i <= x2; i++) {
            int firstNum = arr[y1][i];
            for(int j = y1; j < y2; j++) {
                arr[j][i] = arr[j+1][i];
            }
            arr[y2][i] = firstNum;
        }
        return arr;
    }

    private int[][] d3(int[][] arr, int[] query) {
        int y1 = query[0];
        int x1 = query[1];
        int y2 = query[2];
        int x2 = query[3];

        for(int i = y1; i <= y2; i++) {
            int firstNum = arr[i][x2];
            for(int j = x2; j > x1; j--) {
                arr[i][j] = arr[i][j-1];
            }
            arr[i][x1] = firstNum;
        }
        return arr;
    }

    private int[][] d4(int[][] arr, int[] query) {
        int y1 = query[0];
        int x1 = query[1];
        int y2 = query[2];
        int x2 = query[3];

        for(int i = y1; i <= y2; i++) {
            int firstNum = arr[i][x1];
            for(int j = x1; j < x2; j++) {
                arr[i][j] = arr[i][j+1];
            }
            arr[i][x2] = firstNum;
        }
        return arr;
    }
}

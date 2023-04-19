package src;

import java.util.ArrayList;

class Main {
    class Pair {
        int x;
        int y;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair>[] wall;
    //dfs 용
    static boolean[][] visited;
    // 0 땅 1 물
    static int[][] landmark;
    //landmark copy
    static int[][] island;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int yLen;
    static int xLen;

    private boolean isPossible(int y, int x) {
        if(y >= 0 && x >= 0 && y < yLen && x < xLen) return true;
        return false;
    }

    private void watermark(int y, int x, int h) {
        visited[y][x] = true;
        landmark[y][x] = 0;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(isPossible(ny, nx)) {
                if (visited[ny][nx] || landmark[ny][nx] > h) {
                    continue;
                }
                watermark(ny, nx, h);
            }
        }
    }

    private void islandCnt(int y, int x) {
        island[y][x] = 0;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(isPossible(ny, nx)) {
                //0 이면 물이니까 패스
                if (island[ny][nx] == 0) {
                    continue;
                }
                islandCnt(ny, nx);
            }
        }
    }

    private int[][] initIsland() {
        int[][] arr = new int[landmark.length][landmark[0].length];
        for(int i = 0; i < landmark.length; i++) {
            for(int j = 0; j < landmark[i].length; j++) {
                arr[i][j] = landmark[i][j];
            }
        }
        return arr;
    }

    public int solution(int[][] land) {
        int maxx = 0;

        landmark = land;

        yLen = land.length;
        xLen = land[0].length;
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                maxx = Math.max(maxx, land[i][j]);
            }
        }
        wall = new ArrayList[maxx + 1];
        for(int i = 0; i<= maxx; i++) {
            wall[i] = new ArrayList<>();
        }
        for(int i = 0; i < land[0].length; i++) {
            wall[land[0][i]].add(new Pair(0, i));
        }

        for(int i = 1; i < land.length; i++) {
            wall[land[i][land[0].length - 1]].add(new Pair(i,land[0].length - 1));
        }

        for(int i = 1; i < land.length; i++) {
            wall[land[i][0]].add(new Pair(i, 0));
        }

        for(int i = 1; i < land[0].length-1; i++) {
            wall[land[land.length-1][i]].add(new Pair(land.length-1, i));
        }

        for(int i = 1; i <= maxx; i++) {
            visited = new boolean[land.length][land[0].length];
            //물트기
            for(Pair a: wall[i]) {
                watermark(a.y, a.x, i);
            }
            //지면 개수 세기
            island = initIsland();
            int landcnt = 0;
            for(int y = 0; y < island.length; y++) {
                for(int x = 0; x < island[0].length; x++) {
                    if(island[y][x] != 0) {
                        islandCnt(y, x);
                        landcnt++;
                    }
                }
            }
            if(landcnt == 2) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        int[][] land = {{9,9,9},{9,2,3},{9,2,9}};
        System.out.println(m.solution(land));
    }
}
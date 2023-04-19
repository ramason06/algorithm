package src.alo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Potholes {

    int[] dirX = {0, 0, 1};
    int[] dirY = {-1, 1, 0};
    int[][] road = new int[2][200010];

    int sizz = 0;
    List<Integer> poCount = new ArrayList<>();


    public boolean isPossible(int x, int y) {
        return x <= sizz && y >= 0 && y <= 1;
    }

    public void sol(int x, int y, int poCnt, int dir) {
        if(x == sizz) {
            poCount.add(poCnt);
            return;
        }

        for(int i = 0; i < 3; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if(isPossible(nextX, nextY)) {
                if((dir == 2) || (i == 2)) {
                    if (road[y][x] == 1 && road[nextY][nextX] == 1) continue;
                    sol(nextX, nextY, poCnt + road[nextY][nextX], i);
                }
            }
        }
    }

    public int solution(String L1, String L2) {
        sizz = L1.length();
        int totalPotholes = 0;
        //0은 비워둠(시작)
        for(int i = 0; i < sizz; i++) {
            char l1 = L1.charAt(i);
            char l2 = L2.charAt(i);
            if(l1 == 'x') {
                road[0][i+1] = 1;
                totalPotholes++;
            }
            if(l2 == 'x') {
                road[1][i+1] = 1;
                totalPotholes++;
            }
        }

        sol(0,0, 0, 2);
        poCount.sort(Comparator.naturalOrder());
        if(poCount.isEmpty()) {
            return totalPotholes;
        }
        return totalPotholes - poCount.get(0);
    }
}

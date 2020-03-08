package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDFS {
    static int n,m,v;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();

    static void dfs(int pos) {
        visited[pos] = true;
        System.out.print(pos+ " ");
        for(int next : edge.get(pos)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int tp = q.poll();
            System.out.print(tp + " ");
            for (int next : edge.get(tp)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }

        }
    }
}

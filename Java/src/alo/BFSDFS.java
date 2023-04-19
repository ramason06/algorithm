package src.alo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    static void mmain() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken().trim());
        m = Integer.parseInt(st.nextToken().trim());
        v = Integer.parseInt(st.nextToken().trim());

        for(int i = 0; i <= n; i++) {
            edge.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken().trim());
            int b = Integer.parseInt(st.nextToken().trim());
            edge.get(a).add(b);
            edge.get(b).add(a);
        }

        for(ArrayList<Integer> v : edge) {
            Collections.sort(v);
        }

        visited = new boolean[n + 10];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 10];
        bfs();
    }
}

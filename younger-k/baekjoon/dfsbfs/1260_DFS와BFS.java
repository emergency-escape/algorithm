package baekjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

class Main1260 {

  public static int n;
  public static boolean[][] graph;
  public static boolean visit[];

  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    n = nextInt();
    int m = nextInt();
    int start = nextInt();

    graph = new boolean[n + 1][n + 1];
    visit = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      int n1 = nextInt();
      int n2 = nextInt();

      // 연결정보 저장
      graph[n1][n2] = true;
      graph[n2][n1] = true;
    }

    visit[start] = true;
    sb.append(start + " ");

    dfs(start);
    sb.append("\n");

    visit = new boolean[n + 1];
    visit[start] = true;
    sb.append(start + " ");
    bfs(start);

    System.out.println(sb.toString());
  }

  static void dfs(int start) {
    for (int i = 1; i <= n; i++) {
      if (graph[start][i] && !visit[i]) {
        visit[i] = true;
        sb.append(i + " ");
        dfs(i);
      }
    }
  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int i = 1; i <= n; i++) {
        if (graph[node][i] && !visit[i]) {
          visit[i] = true;
          sb.append(i + " ");
          queue.add(i);
        }
      }
    }
  }

  static int nextInt() throws Exception {
    int sign = 0;
    int n = 0;
    int c;
    while ((c = System.in.read()) <= 32);
    if(c == 45) {
      sign = 1;
      c = System.in.read();
    }
    do n = (n << 3) + (n << 1) + (c & 15);
    while ((c = System.in.read()) > 47 && c < 58);
    return sign == 0 ? n : ~n + 1;
  }
}
package baekjoon.dfsbfs;

class Main1012 {

  public static boolean[][] graph;

  public static boolean[][] visit;

  public static int m;

  public static int n;

  public static int[] dx = {-1, 1, 0, 0}; // 상하좌우
  public static int[] dy = {0, 0, 1, -1};

  /**
   * 배추밭에서 배추를 심을 공간을 하나의 노드로 생각하고 상하좌우로 연결된 그래프로 생각하자.
   * 그리고 모든 노드에 대해 dfs 탐색을 진행한다 !
   */
  public static void main(String[] args) throws Exception {

    int tc = nextInt();

    for (int k = 0; k < tc; k++) {
      m = nextInt();
      n = nextInt();
      int cnt = nextInt();

      graph = new boolean[m][n];
      visit = new boolean[m][n];

      for (int i = 0; i < cnt; i++) {
        int x = nextInt();
        int y = nextInt();

        graph[x][y] = true;
      }

      int result = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          boolean search = search(i, j);
          if (search) result++;
        }
      }

      System.out.println(result);
    }
  }

  static boolean search(int x, int y) {
    if (x >= m || x < 0 || y >= n || y < 0) {
      return false;
    }

    if (graph[x][y] && !visit[x][y]) {
      visit[x][y] = true;
      search(x + dx[0], y + dy[0]);
      search(x + dx[1], y + dy[1]);
      search(x + dx[2], y + dy[2]);
      search(x + dx[3], y + dy[3]);

      return true;
    }

    return false;
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
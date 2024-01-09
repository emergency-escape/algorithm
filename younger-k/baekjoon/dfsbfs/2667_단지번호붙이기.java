package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Main2667 {

  public static char[][] map;

  public static boolean[][] visit;

  public static int n;

  public static int[] dx = { -1, 1, 0, 0};

  public static int[] dy = { 0, 0, -1, 1};

  public static int house = 0;

  public static int town = 0;
  
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Integer> houses = new ArrayList<>();
    n = Integer.parseInt(reader.readLine());
    
    map = new char[n][n];
    visit = new boolean[n][n];
    
    for (int i = 0; i < n; i++) {
      String input = reader.readLine();
      for (int j = 0; j < input.length(); j++) {
        map[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        boolean dfs = dfs(i, j);
        if (dfs) {
          town++;
          houses.add(house);
          house = 0;
        }
      }
    }

    writer.append(town + "\n");
    houses.stream().sorted()
        .forEach(house -> {
          try {
            writer.append(house + "\n");
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });

    writer.flush();

    writer.close();
    reader.close();
  }

  static boolean dfs(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= n) {
      return false;
    }

    if (map[x][y] == '1' && !visit[x][y]) {
      visit[x][y] = true;
      house++;

      dfs(x + dx[0], y + dy[0]);
      dfs(x + dx[1], y + dy[1]);
      dfs(x + dx[2], y + dy[2]);
      dfs(x + dx[3], y + dy[3]);

      return true;
    }

    return false;
  }
}
package baekjoon.binarysearch;

import java.util.Arrays;

class Main2110 {

  public static void main(String[] args) throws Exception {
    int n = nextInt();
    int m = nextInt();

    int[] homes = new int[n];
    for (int i = 0; i < n; i++) {
      homes[i] = nextInt();
    }

    Arrays.sort(homes);

    int start = 1;
    int end = homes[n - 1] - homes[0] + 1;
    while (start < end) {
      int mid = (start + end) / 2;

      if (countInstall(mid, homes) < m) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(start - 1);

  }
  static int countInstall(int distance, int[] homes) {
    int count = 1;
    int installed = homes[0];

    for (int i = 1; i < homes.length; i++) {
      int nextHome = homes[i];

      if (nextHome - installed >= distance) {
        count++;
        installed = nextHome;
      }
    }

    return count;
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
package baekjoon.binarysearch;

import java.util.Arrays;

class Main2805 {

  public static void main(String[] args) throws Exception {
    int count = nextInt();
    int need = nextInt();

    int[] woods = new int[count];
    for (int i = 0; i < count; i++) {
      woods[i] = nextInt();
    }

    Arrays.sort(woods);

    int start = 1;
    int end = woods[count - 1];
    while (start < end) {
      int mid = (start + end) / 2;
      if (cut(woods, mid) < need) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(start - 1);
  }

  static long cut(int[] woods, int meter) {
    long result = 0;
    for (int wood : woods) {
      if (wood > meter) {
        result += wood - meter;
      }
    }
    return result;
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
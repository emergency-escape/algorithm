package baekjoon.greedy;

import java.util.Arrays;

/**
 * 종료시간을 오름차순으로 정렬하여 빨리 종료되는 순으로 회의를 채운다.
 */
class Main1931 {
  public static void main(String[] args) throws Exception {
    int count = nextInt();

    int[][] times = new int[count][2];
    for (int i = 0; i < count; i++) {
      times[i][0] = nextInt(); // start
      times[i][1] = nextInt(); // end
    }

    Arrays.sort(times, (cur, next) -> {
      if (cur[1] == next[1]) {  // 종료 시간이 같다면
        return cur[0] - next[0];  // 시작 시간이 빠른 녀석이 우선!
      }

      return cur[1] - next[1];  // 종료시간이 빠른 녀석이 우선!
    });

    int result = 0;
    int end = 0;
    for (int i = 0; i < times.length; i++) {
      if (end <= times[i][0]) { // 시작 시간이 종료시간 이후 이거나 같다면?
        end = times[i][1];  // 종료시간을 다시 세팅하고
        result++; // 회의 카운트
      }
    }

    System.out.println(result);
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
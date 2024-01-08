package baekjoon.dp;

class Main2839 {

  public static void main(String[] args) throws Exception {
    int kg = nextInt();
    int[] dp = new int[5001];

    dp[0] = Integer.MAX_VALUE;
    dp[1] = Integer.MAX_VALUE;
    dp[2] = Integer.MAX_VALUE;
    dp[3] = 1;
    dp[4] = Integer.MAX_VALUE;
    dp[5] = 1;

    for (int i = 6; i <= kg; i++) {
      int count3 = dp[i - 3]; // 3kg을 추가할 때
      int count5 = dp[i - 5]; // 5kg을 추가할 때

      if (isNotAvailable(count3) && isNotAvailable(count5)) {
        dp[i] = Integer.MAX_VALUE;
      } else {
        dp[i] = Math.min(count3, count5) + 1;
      }

    }

    int result = isNotAvailable(dp[kg]) ? -1 : dp[kg];
    System.out.println(result);
  }

  static boolean isNotAvailable(int count) {
    return count == Integer.MAX_VALUE;
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
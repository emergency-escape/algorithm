package baekjoon.dp;

class Main2579 {

  public static void main(String[] args) throws Exception {
    int count = nextInt();

    int[] dp = new int[301];  // count에 따라 배열 사이즈를 지정했더니 아래에 미리 값을 지정해주는 부분에서 인덱스 오류 발생
    int[] stairs = new int[301];

    for (int i = 1; i <= count; i++) {
      stairs[i] = nextInt();
    }

    // 초기값 지정
    dp[1] = stairs[1];
    dp[2] = stairs[1] + stairs[2];
    dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

    // n번째 계단에 도달하는 경우의 수는
    // 1. n-3번째와 n-1번째를 밟고 넘어오기
    // 2. n-2번째를 밟고 넘어오기
    // 이 경우로 아래의 식 도출 가능
    for (int i = 4; i <= count; i++) {
      dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
    }

    System.out.println(dp[count]);
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
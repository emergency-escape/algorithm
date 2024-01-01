package baekjoon.greedy;

class Main5585 {

  public static void main(String[] args) throws Exception {
    int input = nextInt();
    int charge = 1000 - input;

    int result = 0;
    int[] money = { 500, 100, 50, 10, 5, 1 };

    for (int unit : money) {
      int count = charge / unit;
      charge -= unit * count;
      result += count;
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
package baekjoon.bruteforce;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Main4673 {

  private static int dn(int n) {
    String nStr = n + "";
    int dn = n;

    for (int i = 0; i < nStr.length(); i++) {
      dn += Integer.parseInt(nStr.charAt(i) + "");
    }

    return dn;
  }

  public static void main(String[] args) throws Exception {
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    final boolean[] flags = new boolean[10001];

    for (int n = 1; n < 10001; n++) {
      if (!flags[n]) {
        flags[n] = true;
        writer.write(n + "");
        writer.newLine();

        int dn = dn(n);
        while (dn <= 10000 && !flags[dn]) {
          flags[dn] = true;
          dn = dn(dn);
        }
      }
    }

    writer.flush();
    writer.close();
  }
}
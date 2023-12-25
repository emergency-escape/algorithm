package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main2798 {

  public static void main(String[] args) throws Exception {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String counts = reader.readLine();
    String[] countArr = counts.split(" ");

    int n = Integer.parseInt(countArr[0]);
    int m = Integer.parseInt(countArr[1]);

    String inputs = reader.readLine();
    int[] inputArr = Arrays.stream(inputs.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    int solution = 0;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          int sum = inputArr[i] + inputArr[j] + inputArr[k];
          int solutionDiff = m - solution;
          int newDiff = m - sum;
          if (sum <= m && solutionDiff > newDiff) {
            solution = sum;
          }
        }
      }
    }

    writer.write(solution + "");
    writer.flush();
    writer.close();
    reader.close();
  }
}

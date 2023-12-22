package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main8958 {

  public static void main(String[] args) throws Exception {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    final int count = Integer.parseInt(reader.readLine());

    for (int i = 0; i < count; i++) {
      String input = reader.readLine();
      char[] inputArr = input.toCharArray();
      int value = 0;
      int continuous = 0;
      for (int j = 0; j < inputArr.length; j++) {
        if (inputArr[j] == 'O') {
          continuous++;
          value += continuous;
        }
        if (inputArr[j] == 'X') {
          continuous = 0;
        }
      }

      writer.write(value + "");
      writer.newLine();
    }

    writer.flush();

    writer.close();
    reader.close();
  }

}
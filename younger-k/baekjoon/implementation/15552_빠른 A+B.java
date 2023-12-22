package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main15552 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int count = Integer.parseInt(reader.readLine());

    for (int i = 0; i < count; i++) {
      String input = reader.readLine();
      String[] s = input.split(" ");
      int value = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
      writer.write(value + "");
      writer.newLine();
    }

    writer.flush();

    writer.close();
    reader.close();
  }
}
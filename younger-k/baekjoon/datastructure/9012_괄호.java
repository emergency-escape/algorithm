package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main9012 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int count  = Integer.parseInt(reader.readLine());
    for (int i = 0; i < count; i++) {
      String input = reader.readLine();

      if (isVPS(input)) {
        writer.append("YES\n");
      } else {
        writer.append("NO\n");
      }
    }

    writer.flush();

    writer.close();
    reader.close();
  }

  /**
   * 스택에 열린 괄호일 경우 집어넣고 닫힌 괄호일 경우 열린 괄호를 빼내면서 짝을 맞춰본다.
   */
  static boolean isVPS(String input) {
    Stack<String> stack = new Stack<>();

    for (int j = 0; j < input.length(); j++) {
      String str = input.charAt(j) + "";
      if (str.equals("(")) {
        stack.push(str);
      } else {
        if (stack.isEmpty()) { // 남은 열린괄호가 없는데 닫힌 괄호가 나온경우 유효하다 볼 수 없다.
          return false;
        } else {
          stack.pop();
        }
      }
    }

    return stack.isEmpty();
  }
}
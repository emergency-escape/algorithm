package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main1920 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    int[] arr = Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .sorted()
        .toArray();

    int m = Integer.parseInt(reader.readLine());
    Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .forEach(target -> {
          try {
            int index = search(0, n - 1, arr, target);
            int isPresent = index > -1 ? 1 : 0;
            writer.write(isPresent + "\n");
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });

    writer.flush();
    writer.close();
  }

  private static int search(int start, int end, int[] arr, int target) {
    if (start > end) {
      return -1;
    }

    int mid = (end + start) / 2;

    if (target == arr[mid]) {
      return mid;
    } else if (target > arr[mid]) {
      return search(mid + 1, end, arr, target);
    } else {
      return search(start, mid - 1, arr, target);
    }
  }
}
package programmers.kakao2023;

import java.util.Stack;

class Solution {

  /**
   * Stack과 Greedy를 활용한 풀이법.
   * 근데 시간초과랑 틀리는 문제가 너무 많음...
   */
  public long solution1(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    Stack<Integer> deliveryStack = new Stack<>();
    Stack<Integer> pickupStack = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (deliveries[i] > 0) {
        deliveryStack.push(i);
      }
      if (pickups[i] > 0) {
        pickupStack.push(i);
      }
    }

    while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
      int farDelivery = deliveryStack.isEmpty() ? -1 : deliveryStack.peek();
      int farPickup = pickupStack.isEmpty() ? -1 : pickupStack.peek();
      int destination = Math.max(farDelivery, farPickup);
      answer += (destination + 1) * 2L;

      int available = cap;
      while(available != 0 && !deliveryStack.isEmpty()) {
        int location = deliveryStack.pop();

        if (deliveries[location] <= available) {
          available -= deliveries[location];
          deliveries[location] = 0;
        } else {
          deliveries[location] -= available;
          available = 0;
          deliveryStack.push(location);
        }
      }

      available = cap - available;
      while(available != 0 && !pickupStack.isEmpty()) {
        int location = pickupStack.pop();

        if (pickups[location] <= available) {
          available -= pickups[location];
          pickups[location] = 0;
        } else {
          deliveries[location] -= available;
          available = 0;
          pickupStack.push(location);
        }
      }
    }

    return answer;
  }


  /**
   * 먼 지점부터 몇 번을 이동해야되는지 카운팅하여 거리를 계산.
   */
  public long solution2(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    int deliver = 0;
    int pickup = 0;

    for (int i = n - 1; i >= 0; i--) {
      if (deliveries[i] > 0 || pickups[i] > 0) {
        int count = 0;

        while (deliver < deliveries[i] || pickup < pickups[i]) {
          count++;

          deliver += cap;
          pickup += cap;
        }

        deliver -= deliveries[i];
        pickup -= pickups[i];
        answer += (i + 1) * 2 * count;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
//    int cap = 4;
//    int n = 5;
//    int[] deliveries = { 1, 0, 3, 1, 2 };
//    int[] pickups = { 0, 3, 0, 4, 0 };
    int cap = 2;
    int n = 7;
    int[] deliveries = { 1, 0, 2, 0, 1, 0, 2 };
    int[] pickups = { 0, 2, 0, 1, 0, 2, 0 };
    long answer = solution.solution2(cap, n, deliveries, pickups);
    System.out.println(answer);
  }
}

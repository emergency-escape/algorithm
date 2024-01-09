Dynamic Programming
==
- 큰 문제를 하위의 작은 문제들로 나누어 풀어 최적의 해를 구하는 기법
- Greedy와 마찬가지로 최적의 해를 구하는 방법 중 하나
- 작은 문제를 나누어 푼다는 점은 **분할정복**과 비슷하지만 작은 부분문제들의 답이 바뀌지 않는 다는 점이 DP의 큰 특징이다.

과정
--
- 모든 작은 문제들은 한번만 풀어야 한다.
1. 작은 문제의 정답을 구한다.
2. 정답을 어딘가에 메모한다. (`Memodization`)
3. 다시 그보다 큰 문제를 풀어나갈 때 똑같은 작은 문제가 나타나면 앞서 메모한 작은 문제의 결과값을 이용한다.

조건
--
- 작운 문제가 반복이 일어나는 경우
- 같은 문제는 구할 때마다 정답이 같다.

예제
--
- 피보나치 수열 문제 (1, 1, 2, 3, 5, 8. ,,,)
    - 재귀 함수를 이용하여 풀어도 되지만, n이 증가함에 따라 호출되는 함수의 수가 기하급수적으로 늘어나 일정 수 이상의 순열을 구하기가 어렵다.
```java
class Main {
  static long memory[] = new long[101];

  public static long fibonacci(int n) {
    if(n <= 2) {	// 2 이하는 1 반환
      return 1;
    }

    if(memory[n] != 0) {	// 이미 푼 적 있는 문제라면
      return memory[n];		// 저장된 값 호출
    }
    
    return memory[n] = fibonacci(n-1) + fibonacci(n-2);
  }
  public static void main(String[] args) {
    System.out.println(fibonacci(100));
  }
}
```
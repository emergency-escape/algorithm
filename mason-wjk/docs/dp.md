## 동적계획법 Dynamic Programming
### 단순재귀 (피보나치)
```java
public class Simple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp  = new int[n+1];
		System.out.println(fibo(n));
	}
	
	// 단순 재귀
	static int fibo(int x) {
		if( x ==1 || x==2) return 1;
		return fibo(x-1) + fibo(x-2);
	}
}
```
DP 문제가 성립할 조건
이럴 때 DP를 사용하면 된다. <br> 
단순 재귀코드보다 높은 효율을 갖는 코드를 설계할 수 있다. <br>

### 최적 부분 구조(Optimal Substructure) <br>
상위 문제를 하위 문제로 나눌 수 있으며 하위 문제의 답을 모아서 상위 문제를 해결할 수 있다. <br>
중복되는 부분 문제(Overlapping Subproblem) <br>
동일한 작은 문제를 반복적으로 해결해야 한다. → 그러므로, 피보나치 수열은 DP 사용조건에 만족한다

### Top-down(하향식) <br>
상위 문제를 해결하기 위해서 하위 문제를 재귀적으로 호출하여  하위 문제를 해결함으로써 상위 문제를 해결하는 방식이다. <br> 
이 때 해결해놓은 하위 문제를 저장해 놓기 위해 Memoization이 사용된다.

피보나치 함수를 만들 때 Top-down은 재귀 호출을 사용하여 구현한다 (메모이제이션 사용) <br>
메모이제이션은 DP구현 방법 중 하나로, 한 번 계산한 결과를 메모리 공간에 메모하는 기법이다. <br> 
이를 사용하면 모든 부분 문제가 한 번씩만 계산된다고 보장할 수 있기 때문에 함수 호출 횟수가 엄청나게 감소함을 예상할 수 있다.
```java
public class Topdown {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp  = new int[n+1];
		System.out.println(fibo(n));
		
	}
	
    // Top-down (메모이제이션 사용)
	static int fibo(int x) {
		if( x ==1 || x==2) return 1;
		if(dp[x] != 0) return dp[x];
		dp[x] = fibo(x-1) + fibo(x-2);
		return dp[x];
	}
}
```

### Bottom-up(상향식)
하위에서부터 문제를 해결해나가면서 먼저 계산했던 문제들의 값을 활용해서 상위 문제를 해결해나가는 방식으로 DP의 전형적인 형태는 Bottom-up이다. <br> 
여기서 사용되는 문제 결과 값 저장용 리스트는 DP 테이블이라고 부른다.

Bottom-up 방식은 반복문을 사용해서 구현한다.

```java
// 일반 재귀 함수
// 중복된 계산을 반복해서 하게 된다. 시간복잡도 O(2^n)으로 x의 수가 커질수록 복잡도가 엄청나게 커짐
static int fibo(int x) {
   if( x ==1 || x==2) return 1;
   return fibo(x-1) + fibo(x-2);
}


// Memoization 
// 하위 문제의 결과 값을 dp[]배열에 저장해놓고 필요할 때마다 계산된 값을 호출
static int fibo(int x) {
   if( x ==1 || x==2) return 1;
   if(dp[x] != 0) return dp[x];
   dp[x] = fibo(x-1) + fibo(x-2);
   return dp[x];
}
```
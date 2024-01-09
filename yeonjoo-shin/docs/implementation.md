Stream.flatMapToInt()

flatMap()메소드는 map() 메소드와 동일하게 매핑 메서드 역할을 하는데 
2차원 또는 2단계배열 또는 List 타입에 대해서 일괄적으로 하나의 Stream에서 연산할 수 있도록 도와준다.

``` java
//flatMap 메서드 인터페이스
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
```

예시
``` java
public class Main2669 {
    static int maxIndex = 100;
    static int array[][] = new int[maxIndex][maxIndex]

		public static int sumSquare() { 
        return Arrays.stream(array)
                .flatMapToInt(row -> Arrays.stream(row)) // stream type return
                .sum();
    }
}
```
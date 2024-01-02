import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Scanner;

public class Main {
        static int maxIndex = 100;
        static int array[][] = new int[maxIndex][maxIndex];

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            // 사각형 정보 저장
            for (int i = 0 ; i < 4 ; i ++) {
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();

                // 사각형 좌표 저장
                square(x1,y1,x2,y2);
            }
            // 넓이 계산
            System.out.println(sumSquare());
        }

        public static void square(int x1,int y1,int x2,int y2) {
            IntStream.range(x1,x2)
                    .forEach(i -> IntStream.range(y1,y2)
                            .forEach(j -> array[i][j] = 1));
        }

        // flatMapToInt로 모든 요소를 1차원으로 평면화
        public static int sumSquare() {
            return Arrays.stream(array)
                    .flatMapToInt(row -> Arrays.stream(row))
                    .sum();
        }

    }
}

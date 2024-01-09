
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.valueOf(st.nextToken()); // 나무의 수 N
        Integer M = Integer.valueOf(st.nextToken()); // 필요한 나무의 길이 M

        int[] trees = new int[N];
        int left = 0;
        int right = -1;
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<N ; i++) {
            trees[i] = Integer.valueOf(st.nextToken());
            if (right < trees[i]) right = trees[i]; // 최초의 절단기 높이 구하기
        }

        // 이분탐색 적용
        Arrays.sort(trees);
        while (left <= right) {
            long answer = 0;
            int middle = (left+right)/2;

            for (int i=0 ; i<N ; i++) {
                if (trees[i]-middle > 0) answer += trees[i]-middle;
            }
            if (answer >= M) left = middle+1;
            else {
                right = middle-1;
            }
        }

        bw.write(right+"");
        bw.flush();
        bw.close();
    }
}
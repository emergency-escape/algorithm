import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];
        for (int i=0 ; i<N ; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int plusCount = 1;
        int plusAnswer = 1;
        int minusCount = 1;
        int minusAnswer = 1;
        for (int i=1 ; i<N ; i++) {
            if (array[i-1] <= array[i]) {
                plusCount++;
                plusAnswer = Math.max(plusAnswer, plusCount);
            } else {
                plusCount=1;
            }

            if (array[i-1] >= array[i]) {
                minusCount++;
                minusAnswer = Math.max(minusAnswer, minusCount);
            } else {
                minusCount=1;
            }
        }

        bw.write(Math.max(minusAnswer, plusAnswer)+"");
        bw.flush();
        bw.close();
    }

}
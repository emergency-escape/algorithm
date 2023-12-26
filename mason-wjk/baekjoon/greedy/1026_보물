import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] A = new Integer[T];
        for (int i = 0; i < T; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        Integer[] B = new Integer[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B, Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0 ; i < T ; i++) {
            sum += A[i]*B[i];
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
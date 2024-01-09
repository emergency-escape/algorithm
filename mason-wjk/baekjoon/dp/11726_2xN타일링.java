import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[1001];
        array[0]= 1;
        array[1]= 2;
        for (int i=2 ; i<N ;i++) {
            array[i] = (array[i-1] + array[i-2]) % 10007;
        }


        bw.write(array[N-1]+"");
        bw.flush();
        bw.close();
    }
}
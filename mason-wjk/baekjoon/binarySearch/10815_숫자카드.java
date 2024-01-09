import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer N = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrayN = new int[N];
        for (int i=0 ; i<N ; i++) {
            arrayN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrayN);

        Integer M = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<M ; i++) {
            if (binarySearch(arrayN, Integer.parseInt(st.nextToken()))) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length-1;

        while (left <= right) {
            int middle = (right+left)/2;
            if (array[middle]<target) left=middle+1;
            else if (target<array[middle]) right=middle-1;
            else return true;
        }

        return false;
    }
}
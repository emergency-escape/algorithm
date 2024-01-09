
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] zeroArray = new int[41];
        int[] oneArrray = new int[41];
        zeroArray[0]=1;
        zeroArray[1]=0;
        oneArrray[0]=0;
        oneArrray[1]=1;

        for (int i=2 ; i<41 ;i++) {
            zeroArray[i] = zeroArray[i-1] + zeroArray[i-2];
            oneArrray[i] = oneArrray[i-1] + oneArrray[i-2];
        }

        for (int i=0 ; i<N ; i++) {
            int temp = Integer.parseInt(br.readLine());
            bw.write(zeroArray[temp] + " " + oneArrray[temp] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
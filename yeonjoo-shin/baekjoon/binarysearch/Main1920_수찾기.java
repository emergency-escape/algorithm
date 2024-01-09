package baekjoon.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main1920_수찾기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nArray = new int[N];
        for (int i = 0; i < N; i++) {
            nArray[i] = sc.nextInt();
        }
        Arrays.sort(nArray);

        int M = sc.nextInt();
        int[] mArray = new int[M];
        for (int i = 0; i < M; i++) {
            mArray[i] = sc.nextInt();
        }

        StringBuilder builder = new StringBuilder();
        for (int i =0; i< M; i++) {
            if (binarySearch(nArray,mArray[i]) >= 0) {
                builder.append(1).append("\n");
            } else {
                builder.append(0).append("\n");
            }
        }
        System.out.println(builder);
    }

    public static int binarySearch(int[] arr,int key) {
        int min = 0;
        int max = arr.length -1;

        while (min <= max) {
            int  mid =  (min+max)/2 ;
            if (key < arr[mid]) {
                max = mid -1;
            } else if (key > arr[mid]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

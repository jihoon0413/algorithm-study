package org.example.코딩챌린지._1일차;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int[] arr;
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        String str = br.readLine();
//
//        int n = str.length();
//
//        arr = new int[n];
//
//        for(int i = 0 ; i < n ; i++) {
//            arr[i] = str.charAt(i) -'0';
//        }
//
//        if(solve(arr)) {
//            for(int a : arr) {
//                sb.append(a);
//            }
//
//        } else {
//            sb.append(-1);
//        }
//
//        System.out.println(sb);
//
//    }
//    static boolean solve(int[] arr) {
//
//        int i =arr.length-1;
//        int j = arr.length-1;
//
//        while(i > 0 && arr[i] < arr[i-1]) {
//            i--;
//        }
//
//        if(i <= 0) {
//            return false;
//        }
//
//        while(j >= i && arr[j] <= arr[i-1]) {
//            j--;
//        }
//
//        int temp = arr[i-1];
//        arr[i-1] = arr[j];
//        arr[j] = temp;
//
//        j = arr.length-1;
//
//        while (i < j) {
//            temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//            i++;
//            j--;
//        }
//
//        return true;
//    }
//}

//정답코드
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] charArray = s.toCharArray();

        if (nextPermutation(charArray)) {
            System.out.println(new String(charArray));
        } else {
            System.out.println(s);
        }
    }

    public static boolean nextPermutation(char[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        reverse(array, i + 1, array.length - 1);
        return true;
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}

package org.example.코딩챌린지._3일차;

//import java.io.*;
//import java.util.*;
//
//// 문자열 압축 해제
//
//class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//
//        Stack<Object> stack = new Stack<>();
//        StringBuilder currentStr = new StringBuilder();
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//
//            if (Character.isDigit(ch)) {
//                int num = ch - '0';
//                if (i + 1 < str.length() && str.charAt(i + 1) == '(') {
//                    stack.push(num);
//                } else {
//                    currentStr.append(ch);
//                }
//            } else if (ch == '(') {
//                stack.push(currentStr.toString());
//                currentStr = new StringBuilder();
//            } else if (ch == ')') {
//                String tempStr = currentStr.toString();
//                currentStr = new StringBuilder((String) stack.pop());
//                int repeat = (int) stack.pop();
//                for (int j = 0; j < repeat; j++) {
//                    currentStr.append(tempStr);
//                }
//            } else {
//                currentStr.append(ch);
//            }
//        }
//
//        System.out.println(currentStr);
//        System.out.println(currentStr.length());
//    }
//}

//정답코드
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String string = new java.util.Scanner(System.in).nextLine();

        Stack<Character> stack = new Stack<>();
        int[] depthResult = new int[50];
        int depth = 0;

        for (char ch : string.toCharArray()) {
            if (ch != ')') {
                if (ch == '(') {
                    depth += 1;
                    depthResult[depth] = 0;
                }
                stack.push(ch);
            } else {
                for (int i = stack.size() - 1; i >= 0; i--) {
                    if (stack.get(i) == '(') {
                        int num = depthResult[depth];
                        for (int j = i + 1; j < stack.size(); j++) {
                            num += 1;
                        }
                        depth -= 1;
                        depthResult[depth] += num * Character.getNumericValue(stack.get(i - 1));
                        while (stack.size() > i - 1) {
                            stack.pop();
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(depthResult[0] + stack.size());
    }
}

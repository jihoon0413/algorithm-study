// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class Main {
//   public static void main(String[] args) throws IOException {

//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st;

//     int[] D = new int[51];    // 각 색의 개수를 저장하는 배열
//     double[] arr = new double[51]; // 각 공의 K를 뽑을 확률을 저장하는 배열

//     int M = Integer.parseInt(br.readLine());

//     st = new StringTokenizer(br.readLine());
//     int parent = 0;
//     for(int i = 0 ; i < M ; i++) {
//       D[i] = Integer.parseInt(st.nextToken());
//       parent += D[i];    // 박스에 들어갈 공의 총 개수
//     }

//     int K = Integer.parseInt(br.readLine());  // 뽑을 공의 개수

//     double answer = 0.0;

//     for(int i = 0 ; i < M ; i++) { // 각 색을 K씩 뽑을 확률 구라기
//       if(D[i] >= K) {    // 빨간색이 최대 50개인데 K에서 60개 뽑으라고 하면 아무것도 들어갈 수 없음 ==> answer = 0
//         arr[i] = 1.0;      // 각 공에서 i개를 뽑을 확률
//         for(int j = 0 ; j < K; j++) {
//           arr[i] *= (double) (D[i] - j) / (double) (parent - j);
//         }
//       }
//       answer += arr[i];
//     }

//     System.out.println(answer);
//   }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double answer = 0;

        double[][] arr = new double[51][51];

        int N = Integer.parseInt(br.readLine());

        int[] K = new int[N+1];
        st = new StringTokenizer(br.readLine());

        int parent = 0;
        for(int i = 1 ; i <= N ; i++) {
            K[i] = Integer.parseInt(st.nextToken());
            parent += K[i];
        }

        for(int i = 1 ; i <= 50 ; i++) {
            arr[i][1] = (double) i / (double) parent;
        }
        for(int i = 2 ; i <= 50 ; i++) {
            for(int j = 2 ; j <= i ; j++) {
                arr[i][j] = arr[i][j-1] * (double) (i- j + 1) / (double) (parent-j+1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        if(M < 51) {
            for(int i = 1 ; i <= N ; i++) {
                answer += arr[K[i]][M];
            }
        }

        System.out.println(answer);
    }
}


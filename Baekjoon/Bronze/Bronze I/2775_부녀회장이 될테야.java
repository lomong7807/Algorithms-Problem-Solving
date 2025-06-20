import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 평균
 *  - 번호 : 2775
 *  - 링크 : https://www.acmicpc.net/problem/2775
 * 2. 풀이핵심
 *  - 다이내믹 프로그래밍
 * 3. 풀이후기
 *  - 처음에는 재귀함수도 연습해볼겸 재귀함수로 구현을 했다.
 *  - 하지만 재귀함수로 구현했을때 O(2^n)의 시간복잡도가 나와서 매우 느렸다.
 *  - 그래서 DP = Dynamic Programming 사용
 *  - 간단히 말하면 "한 번 계산한 결과를 저장해두고 재사용하는 기법"
 *  - 애초에 15x15의 2차원 배열을 만들어두고, 층과 호수에 맞는 숫자들을 미리 넣어둠
 *  - 이렇게 하면 바로 접근이 가능하기 때문에 O(1)의 시간복잡도로 매우 빨라짐
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        int[][] memo = new int[15][15];
        
        for(int i = 0; i < 15; i++) {
            memo[0][i] = i;
            memo[i][1] = 1;
        }
        
        for(int i = 1; i < 15; i++) {
            for(int j = 2; j < 15; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            sb.append(memo[k][n]).append("\n");
        }
        
        System.out.print(sb);
    }
}

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         int T = Integer.parseInt(br.readLine());
        
//         for(int i = 0; i < T; i++) {
//             int k = Integer.parseInt(br.readLine());
//             int n = Integer.parseInt(br.readLine());
            
//             sb.append(solution(k, n)).append("\n");
//         }
        
//         System.out.print(sb);
//     }
    
//     public static int solution(int k, int n) {
//         // 0층일 때는 호수 그대로 반환
//         if(k < 1) {
//             return n;
//         }

//         // 해당 호실까지의 인원을 합칠 변수
//         int sum = 0;

//         // 1호실까지 반복
//         while(n > 0) {
//             sum += solution(k-1, n);
//             n--;
//         }

//         return sum;
//     }
// }
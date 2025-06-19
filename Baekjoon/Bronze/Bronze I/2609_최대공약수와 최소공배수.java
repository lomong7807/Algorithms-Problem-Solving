import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 평균
 *  - 번호 : 2609
 *  - 링크 : https://www.acmicpc.net/problem/2609
 * 2. 풀이핵심
 *  - 유클리드 호재법
 * 3. 풀이후기
 *  - 최대공약수: 2개의 자연수 a, b(a>b)가 있을때 a를 b로 나눈 나머지가 r일 때, a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
 *  - a를 b로 나눴을때의 나머지 값이 0이 될때 까지 나눔
 *  - 이때 나머지 값(r)이 0이 아니라면 그 나머지 값(r)을 b와 나눔.
 *  - 위 과정을 반복
 *  - 648 % 232 = 184 -> 232 % 184 = 48 -> 184 % 48 = 40 -> 48 % 40 = 8 -> 40 % 8 = 0 최대공약수 = 8
 * 
 *  - 최소공배수: a * b 를 최대공약수로 나눈 값
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = 0;
        
        if(A < B) {
            n = gcd(B, A);
        } else {
            n = gcd(A, B);
        }
        
        sb.append(n).append("\n").append((A * B) / n);
        System.out.print(sb);
    }
    
    public static int gcd(int a, int b) {
        int r = 0;

        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}
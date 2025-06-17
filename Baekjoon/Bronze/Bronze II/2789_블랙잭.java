import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 블랙잭
 *  - 번호 : 2789
 *  - 링크 : https://www.acmicpc.net/problem/2789
 * 2. 풀이핵심
 *  - 브루트 포스 알고리즘
 * 3. 풀이후기
 *  - brute: 무식한, force: 힘. 무식한 힘으로 해석
 *  - 완전탐색 알고리즘으로 가능한 모든 경우의 수를 탙ㅁ색하면서 요구조건에 충족되는 결과만을 가져온다.
 *  - 주어진 문제를 선형 구조로 구조화한다.
 *  - 구조화된 문제공간을 적절한 방법으로 해를 구성할 때까지 탐색한다.
 *  - 구성된 해를 정리한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(max < sum && sum <= M) {
                        max = sum;
                    }
                }
            }
        }
        
        System.out.print(max);
    }
}
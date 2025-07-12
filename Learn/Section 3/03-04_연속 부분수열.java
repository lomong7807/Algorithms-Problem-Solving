import java.io.*;
import java.util.*;
/*
 * 문제: 배열에서 연속된 3일간의 최대 매출액 출력
 * 입력: 배열의 크기 N(1<=N<=100,000), 연속된 날짜 K(2<=K<=N)
 *      N개의 배열 원소
 * 출력: 최대 매출액(연속된 3개의 원소 합이 가장 큰 값) 출력
 * 풀이후기:
 *  - 처음에는 while문 내부에 for문으로 계속 세개의 원소를 더해서 비교하는 방식을 했는데, 너무 느렸음
 *  - 슬라이딩 윈도우 방식으로 위치를 옮겨가면서 제일 앞의 값을 빼고, 제일 뒤의 값을 더하면서 이동하는 방식으로 구현
 *  - 기존 방식: 748ms
 *  - 개선 방식: 229ms
 * */

public class Main {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            while(sum > m) {
                sum -= arr[lt++];
            }
            if(sum == m) {
                answer++;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, m, arr));
    }
}
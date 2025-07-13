import java.io.*;
import java.util.*;
/*
 * 문제: N개의 수로 이루어진 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우의 수
 * 입력: 배열의 크기 N(1<=N<=100,000), 연속부분수열의 합 M(1<=M<=100,000,000)
 *      N개의 배열 원소
 * 출력: 경우의 수
 * 풀이후기:
 *  - 이번 문제도 슬라이딩 윈도우 문제다.
 *  - 처음에 lt와 rt를 둘 다 선언해서 작성했었는데, 그럴 필요 없이 rt 자체를 for문으로 돌리면 되는거였다.
 *  - 처음에 코드가 20줄 정도 되던게 10줄로 줄고 훨씬 보기 쉬워졌음.
 * */

public class Main {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            while(m < sum) {
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
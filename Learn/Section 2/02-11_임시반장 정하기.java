import java.io.*;
import java.util.*;
/*
 * 문제: 임시 반장을 선출하려는데 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정한다.
        한 번이라도 같은 반이 된적 있다면 된다.
 * 입력: 3 <= n <= 1000, n x 5의 자연수
 * 출력: 임시 반장이 될 수 있는 학생 번호. 단, 여러 명이 가능하다면 가장 작은 번호 출력
 * 풀이후기:
 *  - 배열 반복문을 너무 많이 돌리는데 이래도 되는건가 싶음
 * */

public class Main {

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int count = Integer.MIN_VALUE;
        boolean[][] cntArr = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < n; k++) {
                    if(i == k) {
                        continue;
                    }
                    if(arr[i][j] == arr[k][j] && !cntArr[i][k]) {
                        cntArr[i][k] = true;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                if(cntArr[i][j] && i != j) {
                    sum++;
                }
            }
            if(count < sum) {
                count = sum;
                answer = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(n, arr));
    }
}
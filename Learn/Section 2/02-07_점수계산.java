import java.io.*;
import java.util.*;
/*
 * 문제: n개의 자연수를 입력받고, 점수 합산
 *      단, 각 문제의 점수는 연속될때 1씩 증가함
 * 입력: 1 <= n <= 100
 *      n개의 자연수 1, 0
 * 출력: 합산 점수
 * 풀이후기:
 *  - 어려운거 없었음
 * */

public class Main {

    public static int solution(int[] arr) {
        int sum = 0;
        int score = 0;

        for(int n : arr) {
            if(n == 1) {
                score++;
                sum += score;
            }else {
                score = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(arr));
    }
}
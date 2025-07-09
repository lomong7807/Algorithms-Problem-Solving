import java.io.*;
import java.util.*;
/*
 * 문제: n개의 자연수를 입력받고, 등수 구하기
 *      단, 같은 등수가 여러명이면 그 다음 등수는 본인보다 점수가 높은 사람의 수 뒤의 등수임
 * 입력: 3 <= n <= 100
 *      n개의 자연수
 * 출력: 합산 점수
 * 풀이후기:
 *  - 어려운게 없는 문제인데, 머리가 너무 안돌아간다.
 *  - 문제를 풀 때 좀 더 집중해서 풀자
 * */

public class Main {

    public static String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int[] rankArr = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) {
                    count++;
                }
            }
            rankArr[i] = count;
            count = 1;
        }

        for(int m : rankArr) {
            sb.append(m).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(n, arr));
    }
}
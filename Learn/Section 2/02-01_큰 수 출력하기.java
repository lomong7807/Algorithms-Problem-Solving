import java.io.*;
import java.util.*;
/*
 * 문제: 입력받은 숫자들에서 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램
        단, 첫 번째 수는 반드시 출력
 * 입력: 숫자의 갯수 n, 다음 줄에 n개의 정수
 * 출력: 조건에 만족하는 수를 공백을 두고 출력
 * 풀이후기:
 *  - 딱히 어렵지 않은 문제였음
 * */

public class Main {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");

        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] < arr[i]) {
                sb.append(arr[i]).append(" ");
            }
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

        System.out.print(solution(arr));
    }
}
import java.io.*;
import java.util.*;
/*
 * 문제: 입력받은 n x n의 격자판에서 봉우리 찾기
        봉우리란, 상하좌우의 숫자보다 큰 숫자를 봉우리라고 함
 * 입력: 2 <= n <= 50, n x n의 자연수
 * 출력: 봉우리의 개수
 * 풀이후기:
 *  - 이런 문제 풀 때마다 느끼는건데 조건문을 생각할 때 좀 더 생각을 잘 해야겠다.
 * */

public class Main {

    public static int solution(int[][] arr) {
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                int tmp = arr[i][j];

                if(0 < i && arr[i - 1][j] >= tmp) {
                    continue;
                }
                if(i < arr.length - 1 && arr[i + 1][j] >= tmp) {
                    continue;
                }
                if(0 < j && arr[i][j - 1] >= tmp) {
                    continue;
                }
                if(j < arr.length - 1 && arr[i][j + 1] >= tmp) {
                    continue;
                }

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(arr));
    }
}
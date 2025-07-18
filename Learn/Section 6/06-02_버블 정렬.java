import java.io.*;
import java.util.*;
/*
 * 문제: N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하라.
        단, 정렬 방법은 버블정렬이다.
 * 입력: 첫 줄에 자연수 N(1<=N<=100)
        두 번째 줄에 N개의 자연수가 공백을사이에 두고 입력한다. 각 자연수는 정수형 범위 안에 있다
 * 출력: 오름차순으로 정렬된 수열 출력
 * 풀이후기:
 *  - Bubble Sort를 사용한다.
 *  - 버블정렬도 시간복잡도 O(N^2)로 그다지 좋은 성능은 아니지만 구현이 매우 간단하다.
 *  - 바로 옆에 있는 값과 비교하면서 더 크면 우측으로 움직이면서 제일 큰 값부터 차례대로 정렬함
 * */

public class Main {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for(int n : arr) {
            sb.append(n).append(" ");
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
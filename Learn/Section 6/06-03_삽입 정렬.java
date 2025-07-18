import java.io.*;
import java.util.*;
/*
 * 문제: N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하라.
        단, 정렬 방법은 삽입정렬이다.
 * 입력: 첫 줄에 자연수 N(1<=N<=100)
        두 번째 줄에 N개의 자연수가 공백을사이에 두고 입력한다. 각 자연수는 정수형 범위 안에 있다
 * 출력: 오름차순으로 정렬된 수열 출력
 * 풀이후기:
 *  - Insertion Sort를 사용한다.
 *  - 삽입정렬은 시간복잡도 O(N^2)로 그다지 좋은 성능은 아니지만 구현이 매우 간단하다.
 *  - 정렬되지 않은 영역을 첫 번째 인자부터로 상정한다.
 *  - 정렬되지 않은 영역의 가장 첫 번째 값을 target으로 설정하고, 정렬된 영역의 우측부터 좌측까지 순차적으로 비교
 *  - 비교했을 때 target이 더 작으면 해당값을 우측으로 밀어서 이동.
 *  - 비교했을 때 target이 더 크면 target을 이전 위치에 삽입.
 * */

public class Main {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < arr.length; i++) {

            int target = arr[i];    // 첫 번째 인자를 target으로 설정
            int j = i - 1;          // target의 왼쪽부분부터 순회해야되기 때문에 한자리 앞부터 순회

            // 정렬된 영역의 가장 좌측까지, target이 해당 값보다 작을때 까지 값을 우측으로 밀어줌
            while(0 <= j && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            // target이 해당 값보다 크기 때문에 해당 값의 우측에 삽입
            arr[j + 1] = target;
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
import java.io.*;
import java.util.*;
/*
 * 문제: N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하라.
        단, 정렬 방법은 선택정렬이다.
 * 입력: 첫 줄에 자연수 N(1<=N<=100)
        두 번째 줄에 N개의 자연수가 공백을사이에 두고 입력한다. 각 자연수는 정수형 범위 안에 있다
 * 출력: 오름차순으로 정렬된 수열 출력
 * 풀이후기:
 *  - Selection Sort를 사용한다.
 *  - 선택정렬은 시간복잡도 O(N^2)로 그다지 좋은 성능은 아니지만 구현이 매우 간단하다.
 *  - 돌아가면서 선택하고, 선택된 값으로 또 돌아가면서 확인하고, 제일 작은 값이면 선택된 값과 위치를 바꾼다.
 *  - 다시 한 번 주석을 쓰면서 흐름을 정확히 이해하자.
 * */

public class Main {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        // 배열의 길이보다 1 작게 순회
        for(int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];      // 가장 작은 값을 담을 변수 선택
            int minIdx = i;        // 가장 작은 값의 위치 기억

            // 정렬되지 않은 영역을 순회하며 지금 min에 있는 값과 비교하기 위해 정렬된 배열의 바로 다음 index부터 비교
            for(int j = i + 1; j < arr.length; j++) {
                // 선택되어있는 min 값과 비교해 더 작은 값이면 min, minIdx 저장
                if(arr[j] < min) {
                    min = arr[j];       // 해당 값을 저장
                    minIdx = j;         // 해당 index를 저장
                }
            }

            // 정렬되지 않은 영역의 순회가 끝나면 위치를 변경
            arr[minIdx] = arr[i];
            arr[i] = min;
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
import java.io.*;
import java.util.*;
/*
 * 문제: 일렬로 숫자가 서있을 때 제일 앞에서 봤을때 보이는 숫자의 수
        즉, 앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않는다.
 * 입력: 숫자의 갯수 n, 다음 줄에 n개의 정수
 * 출력: 보이는 숫자의 갯수
 * 풀이후기:
 *  - 이번 문제도 02-01_큰 수 출력하기와 비슷한 문제였다.
 *  - 다만 앞에 있는 수가 아닌 앞에 있는 수들 중에 최대값을 비교해야 된다는 점이 달랐음
 * */

public class Main {

    public static int solution(int[] arr) {
        int count = 1;
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                count++;
                max = arr[i];
            }
        }

        return count;
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
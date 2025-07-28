import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : solved.ac
 *  - 번호 : 18110
 *  - 링크 : https://www.acmicpc.net/problem/18110
 * 2. 풀이핵심
 *  - 형 변환
 *  - util.Math
 * 3. 풀이후기
 *  - 반올림을 위한 util의 Math를 사용해야 하는 문제
 *  - 형변환에 크게 신경쓰지 않았는데, int와 double을 연산하면 double로 나오는지 처음 알았다.
 *  - 그리고 처음에 List를 사용했는데, 시간 초과가 나옴. Array를 사용하는게 맞았다.
 *  - Array로 해보고 안되면 List로 하자.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cut = (int)Math.round(n * 0.15);
        int sum = 0;

        for(int i = cut; i < n - cut; i++) {
            sum += arr[i];
        }

        double result = sum / (double)(n - cut * 2);

        System.out.print(Math.round(result));
    }
}
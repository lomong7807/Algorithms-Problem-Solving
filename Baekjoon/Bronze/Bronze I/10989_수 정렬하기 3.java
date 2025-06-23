import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 수 정렬하기 3
 *  - 번호 : 10989
 *  - 링크 : https://www.acmicpc.net/problem/10989
 * 2. 풀이핵심
 *  - 카운팅 정렬
 * 3. 풀이후기
 *  - 처음엔 정렬을 하면 된다고 해서 바로 Arrays.sort()를 생각해서 구현했다.
 *  - 하지만 시간이 너무 오래 걸렸고, 그래서 퀵 정렬을 구현해봤다.
 *  - 하지만 퀵정렬 또한 너무 오래걸렸고, 애초에 Arrays.sort() 자체가 내부적으로 퀵 정렬으로 처리를 한다.
 *  - 그래서 카운팅 정렬이란 것으로 구현을 했다.
 *  - 자연수의 범위가 정해져있고, 자연수의 범위가 크지 않기 때문에 미리 1~10,000까지의 숫자를 카운트할 배열을 만든다.
 *  - 배열의 1~10,000까지를 자연수 1~10,000의 갯수라고 생각하고 입력된 값을 배열의 index라고 생각하여 1씩 추가해준다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        int[] countArr = new int[10001];

        for(int i = 0; i < N; i++) {
            countArr[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 1; i < 10001; i++) {
            for(int j = countArr[i]; 0 < j; j--) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
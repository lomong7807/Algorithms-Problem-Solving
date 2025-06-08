import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : A/B
 *  - 번호 : 1008
 *  - 링크 : https://www.acmicpc.net/problem/1008
 * 2. 풀이핵심
 *  - 입력에 대한 산수 계산 출력
 *  - 소수점까지 출력
 * 3. 풀이후기
 *  - 앞서 풀었던 산수에서는 Integer로 parse해줬다면 이번에는 Double으로 parse 해줘야했다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()));
    }
}
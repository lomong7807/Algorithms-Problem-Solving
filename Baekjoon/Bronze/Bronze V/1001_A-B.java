import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : A-B
 *  - 번호 : 1001
 *  - 링크 : https://www.acmicpc.net/problem/1001
 * 2. 풀이핵심
 *  - 입력에 대한 산수 계산 출력
 * 3. 풀이후기
 *  - 앞서 풀었던 A+B 산수와 다를게 없어 어렵지 않았다
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
    }
}
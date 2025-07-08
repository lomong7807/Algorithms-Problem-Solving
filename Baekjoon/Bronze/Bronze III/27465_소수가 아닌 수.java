import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 소수가 아닌 수
 *  - 번호 : 27465
 *  - 링크 : https://www.acmicpc.net/problem/27465
 * 2. 풀이핵심
 *  - 소수가 아닌 수 출력
 * 3. 풀이후기
 *  - 처음에는 입력받은 수보다 큰 수 중에 제일 작은 정수를 찾기 위해 코드를 짰는데,
 *  - 그럴 필요가 없는 문제였음. 너무 허무하고, 뭐 이런 문제가 있는가 싶다.
 *  - 정답이 여러 개 존재한다면 아무거나 출력해도 상관없기 때문에 n의 최댓값인 9^10 을 출력하면 되는거였음
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(1000000000);
    }
}
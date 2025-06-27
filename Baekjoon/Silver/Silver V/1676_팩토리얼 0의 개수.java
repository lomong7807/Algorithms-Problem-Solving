import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 팩토리얼 0의 개수
 *  - 번호 : 1676
 *  - 링크 : https://www.acmicpc.net/problem/1676
 * 2. 풀이핵심
 *  - 5의 배수의 개수
 * 3. 풀이후기
 *  - 처음에는 factorial을 구현하고 BigInteger로 결과를 만들어 0의 개수를 세었다.
 *  - 그런데 그렇게 하니 숫자가 너무 커서 출력에 걸림
 *  - 그래서 5의 배수의 개수를 구하는 방식으로 구현
 *  - 팩토리얼 연산에서 5의 배수가 곱해질때마다 뒷자리 0이 더해짐
 *  - 따라서 주어진 숫자에 5를 나누어 5의 배수를 구하면 되는데 이때, 조건이 하나 더 있다.
 *  - 예를 들어 N = 100으로 할당됐을때를 생각해보면 25, 50, 75, 100은 25의 배수인데,
 *    25 = 5 x 5이므로 5가 2개 들어있다.
 *  - 이미 5의 배수로 한 번 세어졌지만, 5가 하나씩 더 있으므로 추가로 0이 하나씩 더 생긴다.
 *    125 = 5 x 5 x 5이므로 5가 3개 들어있다.
 *  - 이것도 위에서 추가로 0이 하나 더 생겼지만, 5가 하나 더 있으므로 추가로 0이 하나 더 생긴다.
 *  - 따라서 N / 5로 5의 배수의 개수를 구하고 N / 25로 25의 배수의 개수를 구하고 N /125로 125의 배수의 개수를 구해 더한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 5; i <= N; i *= 5) {
            count += N / i;

        System.out.print(count);
    }
}
import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 달팽이는 올라가고 싶다
 *  - 번호 : 2869
 *  - 링크 : https://www.acmicpc.net/problem/2869
 * 2. 풀이핵심
 *  - 정점에 도달하면 끝이라는 조건
 * 3. 풀이후기
 *  - 조건을 보면 단순하게 높이 / (올라가는 거리 - 떨어지는 거리) 라고 생각할 수 있지만, 정점에 도착한다면 끝이라는 조건이다.
 *  - 즉, 높이에서 올라가는 거리를 뺀 거리를 구하면 그 다음날 도달하여 끝이 나게 되는 것이다.
 *  - 그렇다면 (높이 - 올라가는 거리) / (올라가는 거리 - 떨어지는 거리) 는 아닐까?
 *  - 비슷하지만 딱 나누어떨어지지 않는 경우가 있다. ex) 4.5일
 *  - 그런 경우는 날짜를 올림하여야 하는데 그래서 Math.ceil()을 사용해 올림해주자.
 *  - 그 다음 우리가 구한 날짜인 (높이 - 올라가는 거리) / (올라가는 거리 - 떨어지는 거리) 는 높이에서 올라가는 거리를 뺀 거리까지 도달한 날짜다.
 *  - 그러므로 다음 날 완전하게 도달하기 때문에 +1으로 하루를 더해주자.
 *  - 참고로 Math.ceil()은 double만 되기 때문에 형변환을 해서 처리해주자.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (int)Math.ceil(((double)(V - A) / (double)(A - B))) + 1;
        
        System.out.print(day);
    }
}
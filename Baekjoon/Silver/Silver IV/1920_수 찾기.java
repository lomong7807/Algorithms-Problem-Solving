import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 수 찾기
 *  - 번호 : 1920
 *  - 링크 : https://www.acmicpc.net/problem/1920
 * 2. 풀이핵심
 *  - HashSet
 * 3. 풀이후기
 *  - 입력 받은 숫자 중에 어떤 정수가 존재하는지 확인하는 프로그램이다.
 *  - 대게 이런건 Hash자료구조를 사용해야 큰 수더라고 Runtime 오류 없이 해결이 가능하다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) {
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
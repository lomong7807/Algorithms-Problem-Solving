import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 단어의 개수
 *  - 번호 : 1152
 *  - 링크 : https://www.acmicpc.net/problem/1152
 * 2. 풀이핵심
 *  - 입력된 단어의 개수 세기
 * 3. 풀이후기
 *  - StringTokenizer를 사용해 공백을 제거한 뒤 countTokens()로 총 개수 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        System.out.println(st.countTokens());
    }
}
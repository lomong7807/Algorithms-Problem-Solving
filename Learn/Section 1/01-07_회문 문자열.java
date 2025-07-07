import java.io.*;
import java.util.*;
/*
 * 문제: 문자열을 입력받아 뒤집어도 같은 문자열인지 확인
 * 입력: 문자열
 * 출력: "YES", "NO"
 * 풀이후기:
 *  - 처음엔 lt, rt를 사용해서 순회하며 비교했음
 *  - 그런데 문자열 뒤집기는 StringBuilder()를 사용하면 정말 간단하게 할 수 있는거였다.
 *  - 그리고 두 문자열을 비교할때에도 대소문자를 구분하지 않는다면, String.equalsIgnoreCase()로 비교하면 된다.
 * */

public class Main {

    public static String solution(String s) {
        String tmp = new StringBuilder(s).reverse().toString();

        if(s.equalsIgnoreCase(tmp)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(solution(str));
    }
}
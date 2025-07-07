import java.io.*;
import java.util.*;
/*
 * 문제: 팰린드롬(앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열)
        단, 알파벳만 가지고 검사, 대소문자를 구분하지 않음.
        즉, 알파벳 이외의 문자들 무시
 * 입력: 문자열
 * 출력: "YES", "NO"
 * 풀이후기:
 *  - 이전에 풀었던 01-07_회문 문자열에서 조건이 조금 추가된 문제였음.
 *  - 처음에 lt, rt변수로 이동시키면서 확인했는데, 굳이 그렇게 안해도 되는 문제였다.
 *  - String의 내부 기능들로 충분히 풀이 가능한 문제
 *  - 먼저 모두 대문자로 변경하고 replaceAll()으로 알파벳이 아닌 문자들을 제거해버린다.
 *    ([^A-z], ""): A-Z가 아닌 문자들은 모두 ""으로 변경한다는 의미
 *  - 그 값을 tmp에 담아서 비교했을때 같으면 팰린드롬임
 * */

public class Main {

    public static String solution(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        
        String tmp = new StringBuilder(s).reverse().toString();

        if(s.equals(tmp)) {
            return "YES"
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(solution(str));
    }
}
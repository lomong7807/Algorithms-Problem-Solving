import java.io.*;
import java.util.*;
/*
 * 문제: 문자열을 입력받아 중복된 문자를 제거하여 출력
        단, 문자의 순서는 앞에서부터 동일해야 한다.
 * 입력: 문자열
 * 출력: 중복된 문자를 제거한 문자열
 * 풀이후기:
 *  - 처음엔 중복이라는 말을 보고 자료구조 Set을 생각했는데, 순서도 맞춰야돼서 List를 사용함
 *  - 이번 문제는 어려울게 없었음
 * */

public class Main {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            if(!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(solution(str));
    }
}
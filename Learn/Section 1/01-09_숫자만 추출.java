import java.io.*;
import java.util.*;
/*
 * 문제: 숫자와 알파벳이 섞여있는 문자열에서 숫자만으로 문자열을 만들기
 *  - 추출된 숫자 0, 1, 2, 0, 5 -> 1205
 * 입력: 숫자와 알파벳(대소문자)가 섞여있는 문자열
 * 출력: 숫자
 * 풀이후기:
 *  - Character.isAlphabetic() 정말 유용하게 쓴다.
 *  - 별로 어려울거 없었음.
 *  - 그런데 알파벳인지 확인하는 Character.isAlphabetic()이 있다면
 *    숫자인지 확인하는 Character.isDigit()이 있다.
 * */

public class Main {

    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        for(char c : arr) {
            if(Character.isDigit(c)) {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(solution(str));
    }
}
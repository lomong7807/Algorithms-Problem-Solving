import java.io.*;
import java.util.*;
/*
 * 문제: 대문자와 소문자가 존재하는 문자열을 받은 후 대문자는 소문자로. 소문자는 대문자로 변환 후 출력
 * 입력: 문자열
 * 출력: 대소문자가 바뀐 문자열
 * 풀이후기:
 *  - Character.isLoweCase()라는 함수로 소문자인지 확인하고 출력하면 됨
 *  - 어려울거 없었음
 * */

public class Main {

    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for(char x : str.toCharArray()) {
            char c;

            if(Character.isLowerCase(x)) {
                c = Character.toUpperCase(x);
            }else {
                c = Character.toLowerCase(x);
            }

            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.print(solution(str));
    }
}
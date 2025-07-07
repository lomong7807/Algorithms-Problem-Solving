import java.io.*;
import java.util.*;
/*
 * 문제: 입력받은 특수문자를 이진수로 치환하고 해당 숫자의 아스키코드로 문자열 변경
 * 입력: #, * 으로 이루어진 문자열 # = 1, * = 0이라고 생각한다.
 * 출력: 입력받은 특수문자 문자열을 가공한 알파벳 문자열
 * 풀이후기:
 *  - 머릿속으로 어떻게 풀면 되겠다라는 생각은 드는데, 바로 구현이 되지 않았다.
 *  - Math.pow의 return 값은 double이라 int로 형변환 해줘야 함.
 * */

public class Main {

    public static String solution(int n, String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 7;
        

        while(end <= s.length()) {
            int sum = 0;    

            while(start < end) {
                if(s.charAt(start) == '#') {
                    sum += (int)Math.pow(2, end - start - 1);
                }
                start++;
            }

            sb.append((char)sum);

            sum = 0;
            end += 7;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.print(solution(n, str));
    }
}
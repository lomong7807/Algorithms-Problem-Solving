import java.io.*;
import java.util.*;
/*
 * 문제: 입력받은 특수문자를 이진수로 치환하고 해당 숫자의 아스키코드로 문자열 변경
 * 입력: #, * 으로 이루어진 문자열 # = 1, * = 0이라고 생각한다.
 * 출력: 입력받은 특수문자 문자열을 가공한 알파벳 문자열
 * 풀이후기:
 *  - 머릿속으로 어떻게 풀면 되겠다라는 생각은 드는데, 바로 구현이 되지 않았다.
 *  - Math.pow의 return 값은 double이라 int로 형변환 해줘야 함.
 *  - 또 너무 쉬운 방법이 있었음
 *  - String.substring()함수로 7개씩 잘라서 해당 부분을 replace()함수로 # -> 1, * -> 0 할 수 있음
 *  - 또 해당 이진수를 바로 int로 변환할때 인자값으로 2를 넣어주면 2진수로 인식해서 변환해준다.
 *  - 마지막으로 s.substring()함수를 통해 읽은 부분을 자름
 *  - replace함수와 Integer.parseInt(n, 2)로 매우 간단하게 풀 수 있는 문제였다.
 * */

public class Main {

    public static String solution(int n, String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            sb.append((char)num);
            s = s.substring(7);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.print(solution(n, str));
    }
}
import java.io.*;
import java.util.*;
/*
 * 문제: 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 숫자 우측에 숫자 출력
        단, 반복횟수가 1인 경우 생략
 * 입력: 알파벳 대문자로 이루어진 문자열 
 * 출력: 입력받은 문자열을 가공한 문자열
 * 풀이후기:
 *  - 처음에 바로 어떻게 해야될지는 생각이 됐는데, 어떻게 효율적으로 해야될지 몰랐음
 *  - 처음엔 prev라는 변수에 이전 문자열의 값을 저장해서 비교하는 방식으로 구현했음
 *  - 하지만 현재 방식이 메모리나 시간 성능이 훨씬 좋음
 *  - 다음 문자열과 비교하여 count 값으로 count해줌
 * */

public class Main {

    public static String solution(int n, String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 6;
        

        while(end < s.length()) {
            int sum = 0;    

            while(start < end) {
                if(s.charAt(start) == '#') {
                    sum += (int)Math.pow(2, end - start + 1);
                }
                start++;
            }

            sb.append((char)sum);

            sum = 0;
            start += 7;
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
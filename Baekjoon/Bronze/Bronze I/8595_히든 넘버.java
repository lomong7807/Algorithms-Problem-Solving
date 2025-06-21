import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 평균
 *  - 번호 : 8595
 *  - 링크 : https://www.acmicpc.net/problem/8595
 * 2. 풀이핵심
 *  - 연속된 수 문자를 숫자로 변환
 *  - 알파벳과 숫자 구분
 * 3. 풀이후기
 *  - char를 int로 바꿔서 비교 후 다시 문자열로 숫자를 만들어서 그걸 또 파싱했는데, 그럴 필요 없었다.
 *  - 0이라는 숫자에 10을 곱하고 해당 숫자를 더하면 다음 자리에 숫자가 또 있다면 자연스럽게 그 전 숫자는 자리 올림이 됨
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        long sum = 0;
        int num = 0;
        
        for(int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if('0' <= temp && temp <= '9') {
                num = 10 * num + (temp - '0');
            } else if(num != 0) {
                sum += num;
                num = 0;
            }
        }
        
        if(num != 0) {
            sum += num;
        }
        
        System.out.print(sum);
    }
}
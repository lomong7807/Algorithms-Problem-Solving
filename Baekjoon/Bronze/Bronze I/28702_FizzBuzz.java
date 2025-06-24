import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : FizzBuzz
 *  - 번호 : 28702
 *  - 링크 : https://www.acmicpc.net/problem/28702
 * 2. 풀이핵심
 *  - 조건문에 따른 출력
 * 3. 풀이후기
 *  - 문제는 어려울게 없었다.
 *  - 다만 처음에 만들었던 코드가 1280B 였는데, 리팩토링으로 1039B 까지 줄임
 *  - 보기 좋은 코드를 만들자
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int next = 0;
        
        for(int i = 0; i < 3; i++) {
            String temp = br.readLine();
            if(!isFizzBuzz(temp)) {
                next = Integer.parseInt(temp) + (3 - i);
            }
        }
        
        System.out.print(check(next, sb));
    }
    
    public static boolean isFizzBuzz(String str) {
        return str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz");
    }
    
    public static StringBuilder check(int n, StringBuilder sb) {
        if(n % 15 == 0) {
            return sb.append("FizzBuzz");
        }else if(n % 3 == 0 && n % 5 !=0) {
            return sb.append("Fizz");
        }else if(n % 3 != 0 && n % 5 ==0) {
            return sb.append("Buzz");
        }
        
        return sb.append(n);
    }
}
import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 팰린드롬수
 *  - 번호 : 1259
 *  - 링크 : https://www.acmicpc.net/problem/1259
 * 2. 풀이핵심
 *  - 문자열 뒤집기
 * 3. 풀이후기
 *  - 문자열 뒤집기를 그냥 함수를 쓸까하다가 직접 만들었다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String S = "";
        
        while(!(S = br.readLine()).equals("0")) {
            int strLength = S.length();
            
            if(strLength == 1) {
                sb.append("yes");
            } else {
                char[] arr = new char[strLength];
                
                for(int i = strLength - 1; 0 <= i; i--) {
                    arr[i] = S.charAt(strLength - i - 1);
                }
                
                if(String.valueOf(arr).equals(S)) {
                    sb.append("yes");
                } else {
                    sb.append("no");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
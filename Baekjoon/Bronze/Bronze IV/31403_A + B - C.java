import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : A + B - C
 *  - 번호 : 31403
 *  - 링크 : https://www.acmicpc.net/problem/31403
 * 2. 풀이핵심
 *  - 형 변환
 * 3. 풀이후기
 *  - 문자열을 합쳐준 뒤 Integer.parseInt로 형변환하는거라 어려울게 없었다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        String a = br.readLine();
        String b = br.readLine();
        int c = Integer.parseInt(br.readLine());
        
        String sum = sb2.append(a).append(b).toString();
        
        sb1.append(Integer.parseInt(a) + Integer.parseInt(b) - c).append("\n");
        sb1.append(Integer.parseInt(sum) - c);
        
        System.out.println(sb1);
    }
}
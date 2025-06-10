import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 :곱셈
 *  - 번호 : 2588번
 *  - 링크 : https://www.acmicpc.net/problem/2588
 * 2. 풀이핵심
 *  - 주어진 조건대로 출력하는 입출력 기초
 * 3. 풀이후기
 *  - 기초 문제
 *  - String의 특정 위치의 문자를 가져오고 싶다면 str.charAt() 함수로 가져오자.
 *  - char to int는 char에 '0'을 빼주면 된다. ASCII 코드로 처리돼서 숫자로 나오게 됨
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        
        bw.write(String.valueOf(a * (b.charAt(2) - '0')) + "\n");
        bw.write(String.valueOf(a * (b.charAt(1) - '0')) + "\n");
        bw.write(String.valueOf(a * (b.charAt(0) - '0')) + "\n");
        bw.write(String.valueOf(a * Integer.parseInt(b)));
        bw.flush();
       
        bw.close();
        br.close();
    }
}
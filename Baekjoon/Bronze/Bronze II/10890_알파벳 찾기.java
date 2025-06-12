import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 알파벳 찾기
 *  - 번호 : 10890
 *  - 링크 : https://www.acmicpc.net/problem/10890
 * 2. 풀이핵심
 *  - char
 *  - 아스키코드 비교
 * 3. 풀이후기
 *  - 처음엔 -1로 채워진 배열을 미리 만들어서 처리했음
 *  - char도 ++연산이 가능한지 몰랐음
 *  - 하지만 String.indexOf()를 사용하면 됨
 *  - String.indexOf()는 해당 문자가 없으면 -1을 반환함
 *  - 따라서 문자열에 없는 알파벳을 추가하면 -1을 추가하는게 되는셈
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str = br.readLine();
        
        for(char c = 'a'; c <= 'z'; c++) {
            sb.append(str.indexOf(c)).append(" ");
        }
        System.out.print(sb);
    }
}
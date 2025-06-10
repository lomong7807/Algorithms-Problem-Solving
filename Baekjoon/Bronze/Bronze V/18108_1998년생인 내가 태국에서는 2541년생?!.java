import java.io.*;
/**
 * 1. 문제정보
 *  - 제목 : 1998년생인 내가 태국에서는 2541년생?!
 *  - 번호 : 18108번
 *  - 링크 : https://www.acmicpc.net/problem/18108
 * 2. 풀이핵심
 *  - 입출력 기초
 * 3. 풀이후기
 *  - 기초 문제
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int year = Integer.parseInt(br.readLine());
        System.out.println(year - 543);
        
        br.close();
    }
}
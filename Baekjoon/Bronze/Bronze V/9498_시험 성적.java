import java.io.*;
/**
 * 1. 문제정보
 *  - 제목 : 시험 성적
 *  - 번호 : 9498번
 *  - 링크 : https://www.acmicpc.net/problem/9498
 * 2. 풀이핵심
 *  - 조건이 여러 개 있는 조건문
 * 3. 풀이후기
 *  - 조금 더 보기 쉬운 코드를 작성하기 위해 리팩토링에도 집중하자.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int score = Integer.parseInt(br.readLine());
        
        if(90 <= score && score <= 100) {
            System.out.println("A");
        } else if(80 <= score && score <= 89) {
            System.out.println("B");
        } else if(70 <= score && score <= 79) {
            System.out.println("C");
        } else if(60 <= score && score <= 69) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
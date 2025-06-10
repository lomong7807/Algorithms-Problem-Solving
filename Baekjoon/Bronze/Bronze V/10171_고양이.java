import java.io.*;
/**
 * 1. 문제정보
 *  - 제목 : 고양이
 *  - 번호 : 10171번
 *  - 링크 : https://www.acmicpc.net/problem/10171
 * 2. 풀이핵심
 *  - 이스케이프 시퀀스 출력
 *  - 원하는 출력값 찾기
 * 3. 풀이후기
 *  - 이스케이프가 어디서 되는지는 아는데, 어떻게 수정해야될지 몰랐다.
 *  - 그리고 여기서부터는 BufferedWriter를 쓰지 않고, StringBuilder만 사용한다.
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        sb.append("\\    /\\\n")
            .append(" )  ( ')\n")
            .append("(  /  )\n")
            .append(" \\(__)|");
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
    }
}
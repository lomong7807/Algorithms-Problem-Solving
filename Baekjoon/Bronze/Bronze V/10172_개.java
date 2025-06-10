/**
 * 1. 문제정보
 *  - 제목 : 개
 *  - 번호 : 10172번
 *  - 링크 : https://www.acmicpc.net/problem/10172
 * 2. 풀이핵심
 *  - 이스케이프 시퀀스 출력
 *  - 원하는 출력값 찾기
 * 3. 풀이후기
 *  - 이스케이프가 어디서 되는지도 헷갈렸다.
 */
public class Main {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        
        sb.append("|\\_/|\n")
            .append("|q p|   /}\n")
            .append("( 0 )\"\"\"\\\n")
            .append("|\"^\"`    |\n")
            .append("||_/=\\\\__|");
        
        System.out.println(sb.toString());
    }
}
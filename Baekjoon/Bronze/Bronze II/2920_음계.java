import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 음계
 *  - 번호 : 2920
 *  - 링크 : https://www.acmicpc.net/problem/2920
 * 2. 풀이핵심
 *  - 조건에 따른 문자 출력
 * 3. 풀이후기
 *  - 처음엔 조건에 따른 문자열을 만들고, 입력된 값도 배열로 만들어 반복문으로 비교를 했음
 *  - 하지만 반복문을 굳이 하나 더 추가하지 않고 boolean 값으로 입력된 값을 읽으면서 바로바로 체크 가능
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        boolean asc = true;
        boolean desc = true;
        
        for(int i = 1; i < 9; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if(i != temp) {
                asc = false;
            }
            if(9 - i != temp) {
                desc = false;
            }
        }
        
        if(asc) {
            sb.append("ascending");
        } else if(desc) {
            sb.append("descending");
        } else {
            sb.append("mixed");
        }
        
        System.out.print(sb);
    }
}
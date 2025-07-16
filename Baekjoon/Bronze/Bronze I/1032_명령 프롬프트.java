import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 명령 프롬프트
 *  - 번호 : 1032
 *  - 링크 : https://www.acmicpc.net/problem/1032
 * 2. 풀이핵심
 *  - 문자열의 각 문자가 같은지 확인
 * 3. 풀이후기
 *  - 어려운 내용이 딱히 없었음
 *  - 계속 작은 실수들이 있는데, 집중 좀 하자.
 */

public class Main {

    public static char[] solution(int n, String[] arr) {
        char[] answer = arr[0].toCharArray();

        for(int i = 1; i < n; i++) {
            String tmp = arr[i];
            
            for(int j = 0; j < answer.length; j++) {
                if(tmp.charAt(j) != answer[j]) {
                    answer[j] = '?';
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        System.out.print(solution(n, arr));
    }
}
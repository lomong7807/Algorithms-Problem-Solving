import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 분해합
 *  - 번호 : 2231
 *  - 링크 : https://www.acmicpc.net/problem/2231
 * 2. 풀이핵심
 *  - 브루트 포스 알고리즘
 *  - 범위 좁히기
 * 3. 풀이후기
 *  - 이번 문제도 무식하게 전체 탐색을 해줘야 한다.
 *  - 하지만 최대 숫자가 10,000,000인데 1부터 1천만까지 반복문을 돌리면 성능이 엄청나게 떨어진다.
 *  - 그래서 시작 범위를 최대한 결과와 가깝게 도출하여 반복문을 최소화해야 한다.
 *  - 한 자리당 최대 수는 9이므로 자릿수 * 9의 값을 뺀 값을 시작값으로 설정하면 된다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int N = Integer.parseInt(S);
        
        int start = Math.max(1, N - S.length() * 9);
        int sum = 0;
        
        for(int i = start; i < N; i++) {
            String temp = String.valueOf(i);
            sum = i;
            
            for(int j = 0; j < temp.length(); j++) {
                sum += temp.charAt(j) - '0';
            }
            
            if(sum == N) {
                sum = i;
                break;
            } else {
                sum = 0;
            }
        }
        
        System.out.print(sum);
    }
}
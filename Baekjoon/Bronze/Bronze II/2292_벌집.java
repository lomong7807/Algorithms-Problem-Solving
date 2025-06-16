import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 벌집
 *  - 번호 : 2292
 *  - 링크 : https://www.acmicpc.net/problem/2292
 * 2. 풀이핵심
 *  - 조건에 따른 출력
 * 3. 풀이후기
 *  - 처음에 for문으로 min, max, range 세 개의 값을 초기화 후 구현했는데, while문으로 더 간단하게 만들 수 있었음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 1;
        int max = 1;
        
        while(max < N) {
            max += count * 6;
            count++;
        }
        
        System.out.print(count);
    }
}
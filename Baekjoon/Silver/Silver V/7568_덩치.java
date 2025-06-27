import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 수 정렬하기 2
 *  - 번호 : 2751
 *  - 링크 : https://www.acmicpc.net/problem/2751
 * 2. 풀이핵심
 *  - 조건문 구현
 * 3. 풀이후기
 *  - 나보다 더 큰 덩치의 인원수 + 1이 내 등수이다.
 *  - 따라서 전체 배열을 순회하면서 더 큰 덩치의 수를 세고 + 1 해주면 내 등수임.
 *  - 별로 어려울게 없었음.
 *  - 조건문을 잘 보고 구현하면 되는 문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 0; j < N; j++) {
                if(arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j]) {
                    count++;
                }
            }
            sb.append(count).append(" ");
        }
        
        System.out.print(sb);
    }
}
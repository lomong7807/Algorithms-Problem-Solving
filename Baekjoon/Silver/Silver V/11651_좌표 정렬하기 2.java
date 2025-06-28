import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 좌표 정렬하기 2
 *  - 번호 : 11651
 *  - 링크 : https://www.acmicpc.net/problem/11651
 * 2. 풀이핵심
 *  - 2차원 배열
 *  - Comparable 커스텀
 * 3. 풀이후기
 *  - 11650_좌표 정렬하기와 다른 내용이 없었으나 이번에는 배열로 구현해봤다.
 *  - Map으로 구현했을 때
 *    메모리: 66950KB
 *    시간: 592ms
 *  - 배열으로 구현했을 때
 *    메모리: 52564KB
 *    시간: 656ms
 *  - 확실히 배열으로 구현한게 오버헤드가 적어 메모리를 덜 쓰는걸 볼 수 있다.
 *  - 그리고 구현도 Map과 비교했을 때 그다지 보기 어렵거나 하지 않음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for(int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        
        System.out.print(sb);
    }
    
}
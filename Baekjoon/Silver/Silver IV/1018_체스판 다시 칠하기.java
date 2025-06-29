import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 체스판 다시 칠하기
 *  - 번호 : 1018
 *  - 링크 : https://www.acmicpc.net/problem/1018
 * 2. 풀이핵심
 *  - 2차원 배열
 *  - 2가지 경우
 * 3. 풀이후기
 *  - 너무 어려워서 결국 풀지 못하고 찾아봤음
 *  - 사실 아직도 완벽하게 이해하지 못했는데, 시간이 너무 오래 걸려 천천히 이해해보려고 주석으로 정리를 해둠
 */

public class Main {
    
    public static boolean[][] arr;
    public static int min = 64;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력받은 크기만큼의 체스판 생성
        arr = new boolean[N][M];

        // 체스판에 boolean으로 W와 B를 입력
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W') {
                    arr[i][j] = true;    // W일 때는 true
                }else {
                    arr[i][j] = false;   // B일 때는 false
                }
            }
        }
        
        // 8 x 8 체스판의 경우의 수
        int N_row = N - 7;
        int M_col = M - 7;
        
        // 전체 체스판 탐색
        // N_row: 0 -> 1 -> 2 -> 3 끝부분이 입력받은 체스판을 넘어서면 안됨
        for(int i = 0; i < N_row; i++) {
            for(int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }

        System.out.print(min);
    }
    
    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;
        
        boolean TF = arr[x][y]; // 첫번째 칸의 색
        
        // 하나의 row 탐색
        for(int i = x; i < end_x; i++) {
            for(int j = y; j < end_y; j++) {
                
                // 올바른 색이 아닐 경우 count 1 증가
                if(arr[i][j] != TF) {
                    count++;
                }
                
                /*
                다음 칸은 색이 바뀌므로
                true라면 false로 false라면 true로 변경
                */
                TF = (!TF);
            }
            
            // 다음 row를 확인할때는 첫 시작이 바뀌어야 되니 변경
            TF = !TF;
        }
        
        /*
        기존 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
        첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
        색칠 할 개수(64 - count) 중 최솟값을 count에 저장
        */
        count = Math.min(count, 64 - count);
        
        /*
        이전까지의 경우 중 최솟값보다 현재 count 값이
        더 작을 경우 최솟값을 갱신
        */
        min = Math.min(min, count);
    }
}
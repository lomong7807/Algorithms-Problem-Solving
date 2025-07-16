import java.io.*;
import java.util.*;
/*
 * 문제: 인형 뽑기를 하는데, 바구니에 차곡차곡 인형이 쌓인다.
        하지만 이 바구니에 같은 인형이 겹쳐지면 터지면서 없어지는데, 이 터진 인형의 개수를 구하라.
 * 입력: 첫 줄에 자연수 N(5<=N<=30)
        두 번째 줄부터 N*N board 배열 (각 칸에는 0 이상 100 이하인 정수)
        0은 빈 칸을 나타낸다.
        1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하여 같은 숫자는 같은 모양의 인형을 나타낸다.
        board 배열이 끝난 다음 줄에 moves 배열의 길이 M이 주어진다.
        마지막 줄에는 moves 배열이 주어진다. (moves 배열의 크기는 1 이상 1,000 이하)
        moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수
 * 출력: 터트려져 사라진 인형의 개수 출력
 * 풀이후기:
 *  - Deque 자료구조를 Stack으로 사용한다.
 *  - 문제가 되게 재밌음.
 *  - 문제 내용은 되게 긴데 크게 어렵지 않았음.
 *  - stack의 가장 위에 있는 값을 구할 때는 Deque.peekFirst()를 사용하면 됨
 * */

public class Main {

    public static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Deque<Integer> bucket = new ArrayDeque<>();

        for(int x : moves) {
            int cmd = x - 1;

            for(int i = 0; i < n; i++) {
                int tmp = board[i][cmd];
                if(tmp != 0) {
                    if(!bucket.isEmpty() && bucket.peekFirst() == tmp) {
                        bucket.pop();
                        answer += 2;
                    }else {
                        bucket.push(tmp);
                    }
                    board[i][cmd] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, board, m, moves));
    }
}
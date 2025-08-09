import java.io.*;
import java.util.*;
/*
 * 문제: 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
        현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
        송아지는 움직이지 않고 제자리에 있다.
        현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
        최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램
 * 입력: 첫 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지다.
 * 출력: 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재한다.
 * 풀이후기:
 *  - 지금 네번이나 풀었다.
 *  - BFS의 원리에 대해서 정확하게 이해하기 위해서 계속 풀어보자.
 *  - 움직일 수 있는 거리는 {-1, 1, 5}이므로 이 모든 거리를 움직여봐야 한다.
 *  - 하지만 이미 도착했었던 위치는 더이상 갈 필요가 없기 때문에(이미 앞에서 도착을 했다는건 더 빠르게 갈 수 있다는 루트가 있다는 것)
 *    확인하며 움직인다.
 * */

public class Main {

    static int[] ranges = {-1, 1, 5};
    static boolean[] ch = new boolean[10001];

    public static int solution(int s, int e) {
        int L = 0;

        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(s);
        ch[s] = true;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int n = Q.remove();

                for(int range : ranges) {
                    int nx = n + range;
                    if(nx == e) return L + 1;
                    if(ch[nx] != true && 1 <= nx && nx <= 10000) {
                        ch[nx] = true;
                        Q.add(nx);
                    }
                }
            }
            L++;
        }


        return L;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.print(solution(s, e));
    }
}
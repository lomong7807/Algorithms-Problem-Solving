import java.io.*;
import java.util.*;
/*
 * 문제: 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
        해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
 * 입력: 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종
        류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
        각 동전의 종류는 100원을 넘지 않는다.
 * 출력: 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * 풀이후기:
 *  - dfs는 그냥 유형을 한 번 익히고 풀자. 그게 맞다..
 * */

public class Main {

    static Integer[] arr;
    static int n, m, answer = Integer.MAX_VALUE;

    public static void dfs(int L, int sum) {
        if(m < sum || answer <= L) return;
        if(sum == m) {
            answer = L;
        }else {
            for(int i = 0; i < n; i++) {
                dfs(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        dfs(0, 0);

        System.out.print(answer);
    }
}
import java.io.*;
import java.util.*;
/*
 * 문제: 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
        철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
        N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램
 * 입력: 첫 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어진다.
        두 번째 줄부터 N마리 바둑이의 무게가 주어진다.
 * 출력: 첫 번째 줄에 가장 무거운 무게가 주어진다.
 * 풀이후기:
 *  - 이전의 합이 같은 부분집합 문제랑 매우 유사하다. 거의 똑같아서 금방 풀었다.
 * */

public class Main {

    static int[] arr;
    static int c, n, answer = Integer.MIN_VALUE;

    public static void dfs(int L, int sum) {
        if(c < sum) return;
        if(L == n) {
            answer = Math.max(answer, sum);
        }else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        System.out.print(answer);
    }
}
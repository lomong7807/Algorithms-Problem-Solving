import java.io.*;
import java.util.*;
/*
 * 문제: N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
        두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 "YES"를 출력하고, 그렇지 않으면 "NO"를 출력하는 프로그램
        둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어야 한다.
        예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10}으로 두 부분집합의 합이 16으로 같은 경우가 존재한다.
 * 입력: 첫 줄에 자연수 N(1<=N<=10)이 주어진다.
        두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 * 출력: 첫 번째 줄에 "YES" 또는 "NO"를 출력한다.
 * 풀이후기:
 *  - dfs는 여전히 어렵다....
 *  - 여기선 visited로 확인을 하지 않는데, 이유는 바로 sum에 arr[L](현재값)을 더해주냐 안더해주냐로 이미 확인이 되기 때문이다.
 * */

public class Main {

    static String answer = "NO";
    static int n;
    static int[] arr;
    static int total = 0;
    static boolean flag;

    public static void dfs(int L, int sum) {
        if(flag || sum > total/2) return;
        if(L == n) {
            if(total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        }else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            total += a;
        }

        dfs(0, 0);

        System.out.print(answer);
    }
}
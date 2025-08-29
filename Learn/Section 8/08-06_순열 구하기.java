import java.io.*;
import java.util.*;
/*
 * 문제: 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
        니다.
 * 입력: 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
        두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 * 출력: 첫 번째 줄에 결과를 출력합니다.
        출력순서는 사전순으로 오름차순으로 출력합니다.
 * 풀이후기:
 *  - dfs는 그냥 유형을 한 번 익히고 풀자. 그게 맞다..
 *  - 지난번 중복 순열과 다르게 이번에는 중복을 허용하지 않기 때문에 체크 배열(ch[])을 두고 체크해야 한다.
 * */

public class Main {

    static int n, m;
    static int[] arr;
    static int[] pm;
    static boolean[] ch;

    public static void dfs(int L) {
        if(L == m) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }else {
            for(int i = 0; i < n; i++) {
                if(!ch[i]) {
                    ch[i] = true;
                    pm[L] = arr[i];
                    dfs(L + 1);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
    }
}
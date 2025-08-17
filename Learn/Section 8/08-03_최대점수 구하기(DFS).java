import java.io.*;
import java.util.*;
/*
 * 문제: 이번 정보올림피아드대회에서 좋은 성적을 내기 위해 현수는 선생님이 주신 N개의 문제를 풀려고 한다.
        각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 된다.
        제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 한다.
        (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있다.)
 * 입력: 첫 줄에 자연수 N(1<=N<=20)와 M(10<=M<=300)이 주어진다.
        두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어진다.
 * 출력: 첫 번째 줄에 시간 안에 얻을 수 있는 최대 점수를 출력한다.
 * 풀이후기:
 *  - 이것도 결국 부분집합 문제였다.
 *  - 부분집합은 dfs 기억하자.
 * */

public class Main {

    static int n, timeLimit;
    static int answer = Integer.MIN_VALUE;
    static int[][] test;


    public static void dfs(int L, int scoreSum, int timeSum) {
        if(timeLimit < timeSum) return;

        if(L == n) {
            answer = Math.max(answer, scoreSum);
        }else {
            dfs(L + 1, scoreSum + test[L][0], timeSum + test[L][1]);
            dfs(L + 1, scoreSum, timeSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());

        test = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            test[i][0] = score;
            test[i][1] = time;
        }

        dfs(0, 0, 0);

        System.out.print(answer);
    }
}
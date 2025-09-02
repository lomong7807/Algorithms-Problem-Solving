import java.io.*;
import java.util.*;
// 완전탐색 DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Main {

    static boolean[] visited;
    static int max = 0;

    public static void dfs(int k, int[][] dungeons, int cnt) {
        
        // [STEP1] 모든 던전을 순회한다.
        for(int i = 0; i < dungeons.length; i++) {
            int visitFatigue = dungeons[i][0];  // 방문에 필요한 최소 필요도
            int useFatigue = dungeons[i][1];    // 방문 후 사용되는 피로도

            // [STEP2] 기존에 방문 확인, 최소 피로도 확인
            if(visited[i] || k < visitFatigue) {
                continue;
            }

            // [STEP3] 방문했음을 체크
            visited[i] = true;

            // [STEP4] 재귀적으로 현재 피로도를 제외하여 호출
            dfs(k - useFatigue, dungeons, cnt + 1);
            // 다른 케이스를 위해 방문 취소
            visited[i] = false;
        }

        max = Math.max(max, cnt);
    }

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int k = 80;
        // 최소 피로도, 소모 피로도
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        // [STEP1] visited 방문한 방을 체크한다. (던전과 동일한 사이즈로 지정한다)
        visited = new boolean[dungeons.length];

        // [STEP2] dfs 함수에 값들을 전달한다. (* cnt: 방에 방문한 횟수를 체크한다)
        dfs(k, dungeons, 0);
        answer = max;
        
    }
}
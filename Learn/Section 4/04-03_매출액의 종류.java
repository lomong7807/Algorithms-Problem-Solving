import java.io.*;
import java.util.*;
/*
 * 문제: 현수의 아빠는 제과점을 운영한다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
        각 구간별로 구하라고 했다.
        만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
        20 12 20 10 23 17 10
        [20, 12, 20, 10] -> {20, 12, 10} : 3
        [12, 20, 10, 23] -> {12, 20, 10, 23} : 4
        [20, 10, 23, 17] -> {20, 10, 23, 17} : 4
        [10, 23, 17, 10] -> {10, 23, 17} : 3
 * 입력: N(5<=N<=100,000), K(2<=K<=N)
        N개의 숫자열. 숫자는 500 이하의 음이 아닌 정수
 * 출력: 각 구간의 매출액 종류를 순서대로 출력
 * 풀이후기:
 *  - HashMap 응용 문제
 *  - 이번에도 computeIfPresent(), computeIfAbsent()로 풀려고 했는데, 그냥 getOrDefault()가 더 깔끔하다.
 * */

public class Main {

    public static String solution(int n, int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;

        for(int rt = 0; rt < k; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
        }

        sb.append(map.size()).append(" ");

        for(int rt = k; rt < n; rt++) {
            map.computeIfPresent(arr[lt], (key, v) -> v - 1);

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            if(map.containsKey(arr[lt]) && map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            sb.append(map.size()).append(" ");
            lt++;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, k, arr));
    }
}
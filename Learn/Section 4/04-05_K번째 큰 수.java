import java.io.*;
import java.util.*;
/*
 * 문제: 1부터 100 사이의 자연수가 적힌 N장의 카드가 있다. 같은 숫자의 카드가 여러장 있을 수 있다.
        이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록한다.
        모든 경우의 수에서 합을 기록하는데, 이 기록된 값 중 K번째로 큰 수를 출력해라.
        만약 기록된 값을 내림차순 정렬했을 때 25 25 23 23 22 20 19...이고, K값이 3이라면 K번째 큰 값은 22이다.
 * 입력: 첫 줄에 자연수 N(3<=N<=100), K(1<=K<=50)
        두 번째 줄에 N개의 카드값
 * 출력: 3장의 카드 합산 중 K번째로 큰 수
 * 풀이후기:
 *  - Set 자료구조를 사용한다.
 * */

public class Main {

    public static int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        if(set.size() < k) {
            return answer;
        }

        int count = 0;
        for(int x : set) {
            count++;
            if(count == k) {
                answer = x;
                break;
            }
        }

        return answer;
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
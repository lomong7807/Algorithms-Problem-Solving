import java.io.*;
import java.util.*;
/*
 * 문제: 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
        필요할때 바로 사용해서 처리속도를 높이는 장치다.
        LRU 알고리즘은 Least Recently Used의 약자로 직역자하면 가장 최근에 사용되지 않은 것 정도의 의미다.
        캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘이다.
        만약 캐시의 사이즈가 5이고 작업이 {2, 3, 1, 6, 7} 순으로 저장되어 있다면,
        (맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 쓰이지 않은 작업이다.)
        1) Cache Miss: 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작업을
        CPU가 사용한다면 Cache miss가 되고 모든 작업이 뒤로 밀리고 5번 작업은 캐시의 맨 앞에 위치한다.
        {5, 2, 3, 1, 6} (7번 작업은 캐시에서 삭제)
        2) Cache Hit: 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면
        Cache Hit가 되고, 3번 앞에 있는 5, 2번 작업은 한 칸 뒤로 밀리고, 3번이 맨 앞으로 위치한다.
        {5, 2, 3, 1, 6} -> {3, 5, 2, 1, 6}
        캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
        캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램
 * 입력: 첫 줄에 자연수 S(1<=S<=10), 작업의 개수 N(5<=N<=1,000)
        두 번째 줄에 N개의 작업번호가 처리순으로 중진다. 작업번호는 1 ~ 100
 * 출력: 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력
 * 풀이후기:
 *  - Insertion Sort 알고리즘의 변형문제
 *  - 작업이 있는지 확인하고 Cache Hit와 Cache Miss의 작업을 분리한다.
 *  - Cache Hit일 때에는 
 * */

public class Main {

    public static String solution(int s, int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int[] cache = new int[s];

        for(int x : arr) {
            int idx = Integer.MIN_VALUE;

            // 해당 작업이 캐시에 있는지 확인
            for(int i = 0; i < s; i++) {
                if(x == cache[i]) {
                    idx = i;
                }
            }

            // Cache Hit
            if(0 <= idx) {
                for(int j = idx; 0 < j; j--) {
                    cache[j] = cache[j - 1];
                }
            // Cache Miss
            }else {
                for(int j = s - 1; 0 < j; j--) {
                    if(cache[j - 1] == 0) continue;
                    cache[j] = cache[j - 1];
                }
            }
            cache[0] = x;
        }

        for(int x : cache) {
            sb.append(x).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(s, n, arr));
    }
}
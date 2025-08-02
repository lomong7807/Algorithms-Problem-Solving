import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : ATM
 *  - 번호 : 11399
 *  - 링크 : https://www.acmicpc.net/problem/11399
 * 2. 풀이핵심
 *  - 그리디 알고리즘
 * 3. 풀이후기
 *  - 처음엔 일일히 더해주는 방식으로 구현을 했는데 그것보다 아래처럼 바로 구현해주는게 효율적으로 더 좋다.
 *  - 최소 대기 시간을 위해서는 인출 시간이 짧은 사람부터 먼저 처리해야 한다.
 *  - 아래의 로직은 각 사람의 인출시간이 전체 대기시간에 몇 번 영향을 주는지 계산하는 것이다.
 * 
사람:  1분  2분  3분  3분  4분
순서:  [0]  [1]  [2]  [3]  [4]

arr[0]=1이 영향주는 횟수: ●●●●● (5번)
arr[1]=2가 영향주는 횟수:  ●●●● (4번)  
arr[2]=3이 영향주는 횟수:   ●●● (3번)
arr[3]=3이 영향주는 횟수:    ●● (2번)
arr[4]=4가 영향주는 횟수:     ● (1번)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (n - i) * arr[i];
        }

        System.out.print(sum);
    }
}
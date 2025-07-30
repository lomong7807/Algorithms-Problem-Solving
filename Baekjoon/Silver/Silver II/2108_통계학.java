import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 통계학
 *  - 번호 : 2108
 *  - 링크 : https://www.acmicpc.net/problem/2108
 * 2. 풀이핵심
 *  - 구현
 * 3. 풀이후기
 *  - 다른 값들은 모두 간단하게 구할 수 있었는데, 최빈값을 구하는데 시간이 걸렸다.
 *  - 최빈 값이 여러개일 경우 두 번째로 작은 수를 출력해야되는데, 해당 부분이 바로 떠오르지 않아서 claude한테 힌트만 알려달라고 하며 풀었음.
 *  - 갯수가 적을때는 count 값을 세는 배열을 만들어서 구현하는게 성능적으로 상당히 좋다.
 *  - 시간복잡도 O(N)에 끝냄.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] ch = new int[8001];
        double sum = 0;

        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sum += tmp;
            ch[tmp + 4000]++;
            arr[i] = tmp;
        }

        Arrays.sort(arr);

        int max = Arrays.stream(ch).max().getAsInt();
        int result = 0;
        int cnt = 0;
        for(int i = 0; i < ch.length; i++) {
            if(max == ch[i]) {
                result = i - 4000;
                cnt++;
                if(cnt == 2) break;
            }
        }

        sb.append((int)Math.round(sum / n)).append("\n");
        sb.append(arr[n / 2]).append("\n");
        sb.append(result).append("\n");
        sb.append(arr[n - 1] - arr[0]);

        System.out.print(sb);
    }
}
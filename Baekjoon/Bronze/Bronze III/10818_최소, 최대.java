import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 최소, 최대
 *  - 번호 : 10818
 *  - 링크 : https://www.acmicpc.net/problem/10818
 * 2. 풀이핵심
 *  - 입력할 수 있는 정수의 개수가 최대 1,000,000개
 *  - 이에 따른 오버헤드를 생각해야 함
 * 3. 풀이후기
 *  - 처음에 간단하게 Stream API를 사용해 구현했으나 stream() 호출에 따른 오버헤드 발생
 *  - Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
 *  - StringTokenizer로 끊어주는게 훨씬 성능적으로 좋았다.
 *  - Math.max와 Math.min을 사용해 값 비교
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer.parseInt(br.readLine());
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        sb.append(min).append(" ").append(max);
        
        System.out.println(sb);
    }
}
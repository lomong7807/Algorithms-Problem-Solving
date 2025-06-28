import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 좌표 정렬하기
 *  - 번호 : 11650
 *  - 링크 : https://www.acmicpc.net/problem/11650
 * 2. 풀이핵심
 *  - Map
 *  - Map 순회
 * 3. 풀이후기
 *  - x와 y가 있다는 조건에 2차원 배열을 바로 떠올릴수도 있다.
 *  - 하지만, 2차원 배열로 구현하면 코드가 상당히 복잡해지고 보기 불편하여 이번에도 TreeMap을 사용
 *  - 조건
 *    1. x 오름차순 정렬
 *    2. y 오름차순 정렬
 *    3. x는 같은 값일 수도 있음
 *  - 이전에 10814_나이순 정렬 문제에서와 똑같이 풀어주면 된다.
 *  - 자동으로 key값을 정렬해주는 TreeMap을 사용하고 value는 ArrayList로 하나의 key에 여러 value가 들어갈 수 있음
 *  - 출력은 TreeMap이므로 key는 자동정렬이 되어있고, value는 Collections를 사용해 정렬
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int x = entry.getKey();
            List<Integer> values = entry.getValue();
            Collections.sort(values);
            for(Integer y : values) {
                sb.append(x).append(" ").append(y).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
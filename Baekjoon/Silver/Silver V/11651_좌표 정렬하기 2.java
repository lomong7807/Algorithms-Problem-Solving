import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 좌표 정렬하기 2
 *  - 번호 : 11651
 *  - 링크 : https://www.acmicpc.net/problem/11651
 * 2. 풀이핵심
 *  - Map
 *  - Map 순회
 * 3. 풀이후기
 *  - x와 y의 조건이 뒤집혔을 뿐 11650_좌표 정렬하기 문제랑 똑같아서 어려울게 없었음
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
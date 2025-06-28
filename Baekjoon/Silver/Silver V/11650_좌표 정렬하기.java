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
 *  - 다들 배열로 풀었던데, TreeMap으로 구현해봤다.
 *  - 시간은 빠르지만, 2차원 배열으로 구현한것보다 메모리를 좀 더 사용하긴 한다.
 *  - Map 사용
 *    TreeMap: 각 노드마다 추가 메타데이터 저장
 *    ArrayList: 각 y값마다 별도의 ArrayList 객체 생성
 *    Integer 박싱: 모든 x, y값이 Integer 객체로 박싱되어 저장
 *    Map.Entry: 각 키-값 쌍마다 Entry 객체 생성
 *  - 2차원 배열 int[][] 사용
 *    int[][]: 연속적인 메모리 공간에 primitive 타입으로 직접 저장
 *    추가 객체 없음: 컬렉션 프레임워크의 래퍼 객체들이 없음
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
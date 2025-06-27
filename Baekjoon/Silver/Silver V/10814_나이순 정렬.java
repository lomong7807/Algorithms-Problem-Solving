import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 나이순 정렬
 *  - 번호 : 10814
 *  - 링크 : https://www.acmicpc.net/problem/10814
 * 2. 풀이핵심
 *  - Map
 *  - Map 순회
 * 3. 풀이후기
 *  - 나이가 있고 이름이 있다. 보자마자 <K, V>구조인 자료구조 Map이 떠올라야 한다.
 *  - 조건
 *    1. 회원 나이 순 정렬
 *    2. 나이가 같다면 가입 순(입력 순) 정렬
 *  - 나이 순으로 정렬을 해야되기 때문에 기본적으로 정렬을 해주는 자료구조인 TreeMap을 사용하고 나이를 Key로 사용하자.
 *  - 그리고 같은 Key에 여러 이름이 들어올 수 있도록 Value는 List로 해주자.
 *  - List가 Value이고 해당 List에 값들을 추가해야 되니 입력을 받을 때 computeIfAbsent()를 사용하자.
 *  - computeIfAbsent()
 *    1. 해당 매개변수(k)가 Key에 없다면 새로운 List를 생성하여 반환
 *    2. 해당 매개변수(k)가 Key에 있다면 기존 List를 반환
 *  - computeIfAbsent().add()
 *    반환된 값에 추가
 *  - 즉 반환된 List에 해당 값을 추가할 수 있음.
 *  - Map을 순회할때는 Entry를 사용하자
 *    반복문에서 한번만 get으로 가져오니 추가로 검색이 불필요해진다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        Map<Integer, List<String>> map = new TreeMap<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            map.computeIfAbsent(age, k -> new ArrayList<>()).add(name);
        }
        
        for(Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Integer age = entry.getKey();
            List<String> list = entry.getValue();
            for(String name : list) {
                sb.append(age).append(" ").append(name).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
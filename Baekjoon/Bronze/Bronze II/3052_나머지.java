import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 나머지
 *  - 번호 : 3052
 *  - 링크 : https://www.acmicpc.net/problem/3052
 * 2. 풀이핵심
 *  - 중복된 값 확인
 *  - HashSet 사용
 * 3. 풀이후기
 *  - 처음엔 ArrayList에 각 값들을 담았다.
 *  - 그리고 값들을 넣을때마다 list.contains()로 값이 있다면 넣지 않고, 없다면 넣음
 *  - 그런데 애초에 중복된 값을 허용하지 않는 자료구조인 HashSet을 사용하면 값들을 추가할때마다 내부적으로 알아서 처리해줌
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < 10; i++) {
            set.add(Integer.parseInt(br.readLine()) % 42);
        }
        
        System.out.println(set.size());
    }
}
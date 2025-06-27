import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 수 정렬하기 2
 *  - 번호 : 2751
 *  - 링크 : https://www.acmicpc.net/problem/2751
 * 2. 풀이핵심
 *  - 1,000,000 수의 빠른 정렬
 * 3. 풀이후기
 *  - 배열로 받아서 Arrays.sort로 정렬하면 통과되지 못할 수도 있다.
 *  - Arrays.sort()의 경우 내부적으로 dual-pivot QuickSort를 사용하는데
 *    평균 시간복잡도가 O(NlogN)이지만 최악의 경우 O(2^N)이라는 것이다.
 *  - 그래서 최악의 경우 O(NlogN)을 보장하는 병합정렬으로 구현했었다.
 *  - 하지만 Java의 내장 정렬 라이브러리 성능이 훨씬 좋다..
 *  - Collections.sort()는 TimeSort로 병합 및 삽입정렬 알고리즘을 섞어서 사용한다. (hybrid sorting algorithm)
 *    병합정렬은 최선,최악의 경우 모두 O(NlogN)이다.
 *    삽입정렬은 최선의 경우:O(N), 최악의 경우:O(2^N)이다.
 *  - 즉, 시간복잡도 O(n) ~ O(NlogN)을 보장한다.
 *  - 단, Collections.sort()를 사용하기 위해서는 List계열의 자료구조를 사용해야 한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}
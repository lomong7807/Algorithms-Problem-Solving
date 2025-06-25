import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 단어 정렬
 *  - 번호 : 1181
 *  - 링크 : https://www.acmicpc.net/problem/1181
 * 2. 풀이핵심
 *  - Comparator 람다 표현식
 * 3. 풀이후기
 *  - 중복 처리는 간단하게 Set 자료구조를 사용하면 바로 해결됨
 *  - 처음에는 아예 접근 자체를 잘못해서 애먹었다.
 *  - String 배열에 모두 넣어서 퀵 정렬을 하려했는데, 정렬 조건이 두가지여서 안됨
 *  - 그래서 list로 변환 후 Comparator를 사용해 직접 정렬 기준을 정의해줘야 한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}
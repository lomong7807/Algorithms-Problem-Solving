import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 듣보잡
 *  - 번호 : 1764
 *  - 링크 : https://www.acmicpc.net/problem/1764
 * 2. 풀이핵심
 *  - 해시맵
 *  - 정렬
 * 3. 풀이후기
 *  - 이번 문제도 별 생각 없이 풀면 시간 초과다.
 *  - n, m이 500,000 이하의 자연수이므로 최악의경우 500,000 * 500,000까지 시간이 걸린다.
 *  - 따라서 웬만해서 String에선 O(1)의 성능을 보여주는 HashSet.contains()를 활용해야 한다.
 *  - 마지막으로 문자열 순으로 출력하라했으니 list로 담아서 정렬해줌
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if(hashSet.contains(tmp)) {
                list.add(tmp);
                count++;
            }
        }

        Collections.sort(list);

        sb.append(count).append("\n");
        for(String tmp : list) {
            sb.append(tmp).append("\n");
        }

        System.out.print(sb);
    }
}
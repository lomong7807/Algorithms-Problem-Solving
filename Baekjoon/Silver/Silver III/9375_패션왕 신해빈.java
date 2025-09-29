import java.util.*;
import java.io.*;
/**
 * 1. 문제정보
 *  - 제목 : 패션왕 신해빈
 *  - 번호 : 9375
 *  - 링크 : https://www.acmicpc.net/problem/9375
 * 2. 풀이핵심
 *  - Map
 * 3. 풀이후기
 *  - 옷 이름이 겹치지 않아서 Map<String, Integer>로 풀면 되는 문제
 *  ex) headgear 2개 (hat, turban, 안입기) = 3 가지
 *      eyewear 1개 (sunglasses, 안입기) = 2가지
 *      총 경우의 수 = 3 x 2 = 6
 *      알몸(모두 안입기) 제외 = 6 - 1 =5
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> cloth = new HashMap<>();

            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();

                cloth.put(category, cloth.getOrDefault(category, 0) + 1);
            }

            int answer = 1;
            for (int value : cloth.values()) {
                answer *= value + 1;
            }
            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}
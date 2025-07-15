import java.io.*;
import java.util.*;
/*
 * 문제: S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램
        단, 아나그램 판별시 대소문자 구분. 구분문자열은 연속된 문자열
 * 입력: 첫 줄에 첫 번째 문자열 S, 두 번째 줄에 T문자열
        단, S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같다.
 * 출력: S단어에 T문자열과 아나그램이 되는 부분문자열의 개수
 * 풀이후기:
 *  - HashMap, Sliding Window 알고리즘 응용 문제
 *  - 어떻게 해야 문제를 간단하게 풀 수 있을까 너무 고민했다.
 *  - HashMap 두개를 만들어서 S문자열에서 부분문자열을 HashMap에 넣어 Sliding Window알고리즘으로 이동하며
 *    T문자열의 HashMap과 비교한다.
 *  - HashMap.equals()로 HashMap 자료구조끼리 같은지 확인할 수 있는지 처음 알았음.
 * */

public class Main {

    public static int solution(String s, String t) {
        int answer = 0;
        int lt = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(int rt = 0; rt < t.length() - 1; rt++) {
            char tmp = s.charAt(rt);
            map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
        }

        for(int rt = t.length() - 1; rt < s.length(); rt++) {
            char lc = s.charAt(lt);
            char rc = s.charAt(rt);

            map2.put(rc, map2.getOrDefault(rc, 0) + 1);
            if(map1.equals(map2)) {
                answer++;
            }

            map2.put(lc, map2.get(lc) - 1);
            if(map2.get(lc) < 1) {
                map2.remove(lc);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.print(solution(s, t));
    }
}
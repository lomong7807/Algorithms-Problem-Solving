import java.io.*;
import java.util.*;
/*
 * 문제: Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 한다.
        길이가 같은 두 개의 단어가 주어졌을 때 두 단어가 아나그램인지 판별하는 프로그램 작성
        단, 아나그램 판별시 대소문자가 구분된다.
 * 입력: 첫 줄에 첫 번째 단어, 두 번째 줄에 두 번째 단어가 입력
        단어의 길이는 100을 넘지 않는다.
 * 출력: 두 단어가 아나그램이면 "YES", 아니면 "NO"
 * 풀이후기:
 *  - HashMap 응용 문제
 *  - 처음엔 HashMap을 두 개 구현해서 마지막으로 비교하는 반복문까지 총 3개의 반복문이 필요했는데,
 *    두 번째 반복문에서 HashMap에 넣지 않고, 기존 HashMap의 값을 비교하는게 더 효율적이다.
 * */

public class Main {

    public static String solution(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()) {
            map.putIfAbsent(c, 1);
            map.computeIfPresent(c, (k, v) -> v + 1);
        }

        for(char c : s2.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v - 1);
            if(!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.print(solution(s1, s2));
    }
}
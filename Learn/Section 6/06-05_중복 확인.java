import java.io.*;
import java.util.*;
/*
 * 문제: 현수네 반에는 N명의 학생들이 있다.
        선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나를 적어 내라고 했다.
        만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)을 출력하고,
        N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램
 * 입력: 첫 줄에 자연수 N(4<=N<=100,000)
        두 번째 줄에 학생들이 적어 낸 N개의 자연수
 * 출력: D or U
 * 풀이후기:
 *  - Set 자료구조를 사용하면 너무 쉬운 문제라 당황스럽다.
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.print(set.size() == n ? "U" : "D");
    }
}
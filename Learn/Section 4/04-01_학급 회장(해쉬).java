import java.io.*;
import java.util.*;
/*
 * 문제: 학급 회장을 뽑는데 후보로 A, B, C, D, E 후보가 등록한다.
        투표를 할 때 본인이 선택한 기호가 쓰여져 있어 어떤 후보가 학급 회장이 되었는지 출력
        단, 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정한다.
 * 입력: 수열의 길이 자연수 N(5<=N<=50)
        N개의 투표용지에 쓰여져 있던 각 후보의 기호
 * 출력: 학급 회장으로 선택된 기호
 * 풀이후기:
 *  - HashMap을 사용하면 어렵지 않은 문제
 *  - HashMap.putIfAbsent(key, value)
 *    해당 key 값이 없으면 key와 value를 넣음
 *  - HashMap.computeIfPresent(key, (k, v) -> v + 1)
 *    해당 key 값이 없으면 해당 key값에 해당하는 value에 어떤 식을 실행
 * */

public class Main {

    public static char solution(int n, String s) {
        char answer = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            Character tmp = s.charAt(i);
            hashMap.putIfAbsent(tmp, 1);
            hashMap.computeIfPresent(tmp, (k, v) -> v + 1);
        }

        for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(max < value) {
                max = value;
                answer = key;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.print(solution(n, s));
    }
}
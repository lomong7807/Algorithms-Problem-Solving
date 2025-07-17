import java.io.*;
import java.util.*;
/*
 * 문제: 정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 한다.
        다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했다.
        왕자들을 1번부터 N번까지 차례로 번호를 매긴다.
        그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
        그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
        한 왕자가 K 를 외치면 그 왕자는 제외되어 원 밖으로 나오게 된다.
        그 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
        마지막까지 남아있는 왕자가 공주를 구하러 갈 수 있다.
 * 입력: 첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)
 * 출력: 마지막 남은 왕자의 번호
 * 풀이후기:
 *  - Deque 자료구조를 Queue으로 사용한다.
 *  - 이렇게 순환되는 형식에서는 자료구조 Queue를 사용해주자.
 *  - 제일 앞의것을 없애고 다시 Queue에 넣으면 순환되기 때문이다.
 *  - 그리고 마지막에 answer에 값을 넣어줄때 queue.poll()을 사용하면 NullPointerException이 발생할 수 있어 remove()를 사용함.
 * */

public class Main {

    public static int solution(int n, int k) {
        int answer;
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 0;
        while(1 < queue.size()) {
            count++;
            int tmp = queue.poll();
            if(count == k) {
                count = 0;
            }else {
                queue.add(tmp);
            }
        }
        answer = queue.remove();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.print(solution(n, k));
    }
}
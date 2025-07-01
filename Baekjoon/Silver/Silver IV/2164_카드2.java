import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 카드2
 *  - 번호 : 2164
 *  - 링크 : https://www.acmicpc.net/problem/2164
 * 2. 풀이핵심
 *  - Queue 자료구조
 *  - 하지만 Deque
 * 3. 풀이후기
 *  - 처음에 Queue 자료구조가 바로 떠오르지 않았다. 적절한 자료구조를 떠올리는게 정말 중요한거 같음
 *  - Queue 자료구조라고 했으나 Deque을 사용했음
 *  - 왜?
 *  - 메모리 차이
 *    Queue: 45000KB ~ 54000KB
 *    Deuqe: 28000KB ~ 29000KB
 *  - Deque은 Queue 인터페이스를 상속받아서 Queue의 기능을 모두 사용할 수 있음
 *  - 또 인터페이스를 상속받은것이기 때문에 오버헤드가 없음
 *  - 성능차이가 나는 이유는 내부구조 차이 때문
 *    Queue<Integer> q = new LinkedList<>();
 *    Deque<Integer> deq = new ArrayDeque<>();
 *  - 노드 기반 vs 배열 기반
 *    Queue는 LinkedList 구현체를 사용. 노드 기반임
 *    Deque는 ArrayDeque 구현체를 사용. 내부적으로 배열을 사용해 요소들을 연속적으로 저장
 *  - 객체 오버헤드
 *    LinkedList에서 n개의 요소를 저장하려면 n개의 Node가 필요, 각 Node 객체는 헤더 + 데이터 참조 + next 참조 + prev 참조
 *    ArrayDeque는 하나의 배열 객체만 필요
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            deq.add(i);
        }
        while(deq.size() != 1) {
            deq.remove();
            deq.add(deq.poll());
        }

        System.out.print(deq.poll());
    }
}
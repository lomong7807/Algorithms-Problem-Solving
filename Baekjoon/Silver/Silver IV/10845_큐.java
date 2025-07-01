import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 큐
 *  - 번호 : 10845
 *  - 링크 : https://www.acmicpc.net/problem/10845
 * 2. 풀이핵심
 *  - Queue 자료구조
 *  - 하지만 Deque
 * 3. 풀이후기
 *  - 문제 이름이 Queue라서 자료구조 Queue를 써야될거 같지만 Deque를 사용해야 함.
 *  - 애초에 Deque의 성능이 더 좋아서 Deque를 쓰는게 맞지만 문제 조건에서도 Deque를 사용해야 될 이유가 있음
 *  - 명령어 중에 "back"이라는 명령어가 있는데, 이건 해당 자료구조의 제일 뒤에 있는 값을 "읽기만" 해야된다.
 *    삭제를 하면 안됨
 *  - Deque는 앞, 뒤에서 모두 접근이 가능하기 때문에 Deque를 사용하면 간단하게 해결되는 문제임
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()) {
                case "push":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
            }
        }
        
        System.out.print(sb);
    }
}
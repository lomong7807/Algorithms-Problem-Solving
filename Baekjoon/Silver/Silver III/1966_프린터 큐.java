import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 프린터 큐
 *  - 번호 : 1966
 *  - 링크 : https://www.acmicpc.net/problem/1966
 * 2. 풀이핵심
 *  - Queue
 * 3. 풀이후기
 *  - 큐만 사용하면 되는 간단한 문제인줄 알았는데, 내부에 중요도가 높은 문서가 있는지 확인까지 해줘야 했다.
 *  - 확인을 위해서 중요도만을 담은 배열을 하나 만들었고, 해당 배열을 정렬하여 중요도가 높은 순서인지 확인하며 Queue를 처리함.
 *  - Queue에서 값을 가져올때는 웬만해서 remove()를 사용하자
 */

class Document {
    int idx;
    int importance;

    Document(int idx, int importance) {
        this.idx = idx;
        this.importance = importance;
    }
}

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void solution(int n, int m, StringTokenizer st) {
        int answer = 0;

        Deque<Document> Q = new ArrayDeque<>();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int importance = Integer.parseInt(st.nextToken());
            Q.add(new Document(i, importance));
            arr[i] = importance;
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            int maxImportance = arr[n - i - 1];

            while(Q.peek() != null && Q.peek().importance != maxImportance) {
                Q.add(Q.remove());
            }

            Document doc = Q.remove();
            answer++;
            if(doc.idx == m) {
                break;
            }
        }

        sb.append(answer).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            solution(n, m, st);
        }

        System.out.print(sb);
    }
}
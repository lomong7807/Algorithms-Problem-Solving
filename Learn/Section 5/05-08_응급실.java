import java.io.*;
import java.util.*;
/*
 * 문제: 메디컬 병원 응급실에는 의사가 한 명밖에 없다.
        응급실은 환자가 도착한 순서대로 진료를 한다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 한다.
        이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정한다.
        - 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼낸다.
        - 꺼낸 환자보다 나머지 대기 목록에서 위험도가 높은 환자가 존재하면 꺼낸 환자를 다시 대기목록 제일 뒤로 넣는다.
        - 그렇지 않으면 진료를 받는다.
        즉, 대기목록에 자기보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조이다.
        현재 N명의 환자가 대기목록에 있을 때, N명의 대기목록 순서의 환자 위험도가 주어지면, 최초 대기목록상의 M번째 환자는 몇 번째 진료를 받는가
        단, 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것이다.
 * 입력: 첫 줄에 자연수 N(5<=N<=100), M(0<=M<N)
        두 번째 줄에 접수한 순서대로 환자의 위험도 (50<=위험도<=100)이 주어진다.
        위험도는 값이 높을수록 더 위험하다는 뜻이다. 같은 값의 위험도가 존재할 수 있다.
 * 출력: M번째 환자가 몇 번째로 진료받는지 출력
 * 풀이후기:
 *  - Deque 자료구조를 Queue으로 사용한다.
 *  - 제일 아래 주석처리해둔게 내 첫 번째 풀이인데, 불필요한 정렬과 리스트 조작으로 복잡도가 증가한다.
 *  - 개선된 코드에서는 큐만 사용하여 O(N^2) 시간복잡도로 간단하게 해결
 *  - Person이라는 객체를 만들어서 해당 객체에 원래 순서와 위험도를 넣어서 확인하며 진료
 *  - 최대한 문제의 논리적인 흐름과 비슷하게 코드를 짜려고 하자.
 * */

class Person {
    int id;
    int danger;

    public Person(int id, int danger) {
        this.id = id;
        this.danger = danger;
    }
}

public class Main {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;

        Deque<Person> Q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            Q.add(new Person(i, arr[i]));
        }

        while(!Q.isEmpty()) {
            Person tmp = Q.poll(); // 현재 진료받을 차례인 환자

            // 현재 진료받을 환자를 제외한 나머지 환자들 전체 확인
            for(Person p : Q) {
                // 해당 환자를 처리하기에는 더 위험도가 높은 환자가 존재함
                if(tmp.danger < p.danger) {
                    Q.add(tmp);     // 그럼 해당 환자를 제일 뒤에 다시 줄 세움
                    tmp = null;     // 해당 환자는 진료를 받지 못했다는 표시
                    break;          // 어쨌든 1명 이상의 위험도가 더 높은 환자가 존재하기 때문에 더이상 순회 할 필요 없음
                }
            }
            
            // tmp가 null이 아니라는 것은 "이 환자가 진료를 받는다"는 의미
            if(tmp != null) {
                answer++;          // 진료를 받으므로 순번 증가
                if(tmp.id == m) {
                    return answer; // 진료를 받는 환자가 M 번째 환자이면 순서 반환
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, m, arr));
    }
}



// public static int solution(int n, int m, int[] arr, List<Integer> list) {
//     int answer = 0;

//     Collections.sort(list, Collections.reverseOrder());
//     Deque<Integer> queue = new ArrayDeque<>();
//     for(int i = 0; i < n; i++) {
//         queue.add(i);
//     }

//     while(!list.isEmpty()) {
//         int tmp = list.remove(0);

//         while(true) {
//             if(!queue.isEmpty() && arr[queue.peek()] != tmp) {
//                 queue.add(queue.remove());
//             }else {
//                 answer++;
//                 if(!queue.isEmpty() && queue.peek() == m) {
//                     return answer;
//                 }
//                 queue.remove();
//                 break;
//             }
//         }
//     }

//     return answer;
// }
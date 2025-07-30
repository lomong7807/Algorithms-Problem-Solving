import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 스택 수열
 *  - 번호 : 1874
 *  - 링크 : https://www.acmicpc.net/problem/1874
 * 2. 풀이핵심
 *  - 스택
 * 3. 풀이후기
 *  - 문제를 이해하는데 너무 어려웠다.
 *  - 그러니까 스택에 1~n까지의 수를 차례대로 넣고(push) 빼는(pop)과정을 할건데 해당 과정을 통해 수열을 만들 수 있는지 판단하는 문제다.
 *  - [4, 3, 6, 8, 7, 5, 2, 1] 좌측에서부터 해당 순서대로 순열이 입력되면
 *  - 4까지 스택에 수를 넣고 뺀다.
 *  - 3은 스택에 이미 있기 때문에 뺀다.
 *  - 6까지 스택에 수를 넣고 뺀다.
 *  - 8까지 스택에 수를 넣고 뺀다.
 *  - 7은 스택에 이미 있기 때문에 뺀다.
 *  - 5는 스택에 이미 있기 때문에 뺀다.
 *  - 2는 스택에 이미 있기 때문에 뺀다.
 *  - 1은 스택에 이미 있기 때문에 뺀다.
 * 
 *  - [1, 2, 5, 3, 4] 좌측에서부터 해당 순서대로 순열이 입력되면
 *  - 1을 스택에 넣고 뺀다.
 *  - 2를 스택에 넣고 뺀다.
 *  - 5까지 스택에 수를 넣고 뺀다.
 *  - 3을 빼려는데 3을 빼내려면 4도 빼내야된다. 그렇다면 4를 빼고 3을 빼낸다.
 *  - 마지막으로 4를 빼야되는데 방금 3을 빼면서 4를 빼버려서 stack이 비어있다. 따라서 수열을 만들 수 없는 경우가 되는 것이다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;

        for(int i = 1; i <= n; i++) {
            if(i <= arr[idx]) {
                stack.push(i);
                sb.append("+\n");
            }

            while(!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            }
        }

        if(!stack.isEmpty()) {
            System.out.print("NO");
        }else {
            System.out.print(sb);
        }
    }
}
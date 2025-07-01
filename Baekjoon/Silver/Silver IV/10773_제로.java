import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 제로
 *  - 번호 : 10773
 *  - 링크 : https://www.acmicpc.net/problem/10773
 * 2. 풀이핵심
 *  - Stack 자료구조
 *  - 하지만 Deque
 * 3. 풀이후기
 *  - 어려운 내용은 없었음
 *  - 처음에 2^31 - 1의 값이 뭔지 몰라서 안전하게 Long으로 구현했었음.
 *  - 근데 2^31 - 1 이 Integer 최대값이라 Integer로 구현 가능
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < k; i ++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(n);
            }
        }
        
        int sum = 0;
        for(int a : stack) {
            sum += a;
        }
        
        System.out.print(sum);
    }
}
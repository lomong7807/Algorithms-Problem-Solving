import java.io.*;
import java.util.*;
/*
 * 문제: N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 경우의 수
 * 입력: 배열의 크기 N(7<=N<=1,000)
 * 출력: 경우의 수
 * 풀이후기:
 *  - 슬라이딩 윈도우 문제로 배열이 주어지지 않고, 자연수를 움직이며 계산하면 됨
 *  - 그런데 n / 2 + 1 까지만 진행하면 됨
 *  - 연속된 자연수의 합이니, 중간을 넘어가면 무조건 n보다 크기 때문임
 * */

public class Main {

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;

        for(int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;

            while(n < sum) {
                sum -= lt++;
            }

            if(sum == n) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(solution(n));
    }
}
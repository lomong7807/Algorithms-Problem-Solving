import java.io.*;
import java.util.*;
/*
 * 문제: 0과 1로 구성된 길이가 N인 수열에서 최대 k번을 0을 1으로 변경할 수 있음.
        최대 k 번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾아라.
 * 입력: 수열의 길이 자연수 N(5<=N<=100,000)
        N의 길이의 0과 1로 구성된 수열
 * 출력: 최대 연속부분수열의 길이
 * 풀이후기:
 *  - 조건이 좀 복잡했지만, 결국 슬라이딩 윈도우 문제였음.
 *  - 0으로 바꿀 수 있는 회수를 계산해야돼서 좀 복잡했다.
 * */

public class Main {

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;

        int zeroCnt = 0;
        int len = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) {
                zeroCnt++;
            }

            len++;

            while(k < zeroCnt) {
                if(answer < len) {
                    answer = len - 1;
                }
                if(arr[lt] == 0) {
                    zeroCnt--;
                }
                len--;
                lt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, k, arr));
    }
}
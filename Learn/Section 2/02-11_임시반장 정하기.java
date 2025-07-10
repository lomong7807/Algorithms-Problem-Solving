import java.io.*;
import java.util.*;
/*
 * 문제: 임시 반장을 선출하려는데 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정한다.
        한 번이라도 같은 반이 된적 있다면 된다.
 * 입력: 3 <= n <= 1000, n x 5의 자연수
 * 출력: 임시 반장이 될 수 있는 학생 번호. 단, 여러 명이 가능하다면 가장 작은 번호 출력
 * 풀이후기:
 *  - 배열 반복문을 너무 많이 돌리는데 이래도 되는건가 싶음
 *  - 추가) 역시 더 좋은 방법이 있었음. 기존에는 boolean[][] 배열을 또 만들어서 체크를 했는데 그렇게 하지 않고 그냥 바로 확인을 할 수 있음
 *  - 한번이라도 겹쳐졌을때 딱 한 번만 추가를 하면 되기 때문에 break; 조건을 빼먹지 말자.
 * */

public class Main {

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 5; k++) {
                    if(i != j && arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }

            if(count > max) {
                max = count;
                answer = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(n, arr));
    }
}
import java.io.*;
import java.util.*;
/*
 * 문제: 문자열 s와 문자 t가 주어졌을 때 문자열 내에서 각 문자가 문자열 내의 t와 떨어진 최소거리
 * 입력: 문자열 공백 문자가 한 줄
 * 출력: 숫자 배열 한 줄
 * 풀이후기:
 *  - 처음에 접근 자체를 잘못했었음.
 *  - lt와 rt로 각 문자마다 좌측 우측 탐색을 했는데, 그것보다 한번 우측까지 전부 싹 탐색 후
 *  - 거꾸로 탐색하면서 거리를 비교하는게 훨씬 보기 좋고 빠르다.
 *  - 처음 p값을 1000으로 하는 이유는 앞에서부터 순차적으로 탐색하는데 첫 t를 찾기 전까지는 계산된 거리를 넣을 수가 없기 때문이다.
 * */

public class Main {

    public static String solution(String s, char t) {
        int[] arr = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        int p = 1000;

        for(int i = 0; i < arr.length; i++) {
            if(s.charAt(i) == t) {
                p = 0;
            }else {
                p++;
            }
            arr[i] = p;
        }

        for(int i = arr.length - 1; 0 <= i; i--) {
            if(s.charAt(i) == t) {
                p = 0;
            }else {
                p++;
                arr[i] = Math.min(p, arr[i]);
            }
        }

        for(int n : arr) {
            sb.append(n).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(solution(st.nextToken(), st.nextToken().charAt(0)));
    }
}
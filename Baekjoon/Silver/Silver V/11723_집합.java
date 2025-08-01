import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 집합
 *  - 번호 : 11723
 *  - 링크 : https://www.acmicpc.net/problem/11723
 * 2. 풀이핵심
 *  - 2차원 배열
 *  - 비트마스킹
 * 3. 풀이후기
 *  - 이번 문제는 언뜻 봤을때 쉬워보이지만 제약조건으로 메모리 4MB 제한이 있었다.
 *  - 그래서 빠르게 조회, 수정할 수 있는 Map으로 처음에 구현했으나 굉장히 보기 더러운 코드가 나왔다.
 *  - 생각해보니 공집합의 길이는 20밖에 되지 않고 비트마스킹만 하면 되니 boolean 타입의 배열로 해결 가능했음
 *  - 간단한 자료구조부터 복잡한 자료구조까지 차근차근 생각하자. 너무 급하게 생각했다.
 */

public class Main {

    static boolean[] arr;

    public static void iter(boolean tf) {
        for(int i = 1; i <= 20; i++) arr[i] = tf;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new boolean[21];
        int n = Integer.parseInt(br.readLine());

        int x = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case "add":
                    if(!arr[x]) arr[x] = true;
                    break;
                case "remove":
                    if(arr[x]) arr[x] = false;
                    break;
                case "check":
                    if(arr[x]) {
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "toggle":
                    arr[x] = !arr[x];
                    break;
                case "all":
                    iter(true);
                    break;
                case "empty":
                    iter(false);
                    break;
            }
        }

        System.out.print(sb);
    }
}
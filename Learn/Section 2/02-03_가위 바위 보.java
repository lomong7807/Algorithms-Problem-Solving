import java.io.*;
import java.util.*;
/*
 * 문제: 가위, 바위, 보 대결 (1:가위, 2:바위, 3:보)
        단, 비겼을 때는 D 출력
 * 입력: 대결횟수, 횟수만큼의 a, b의 가위, 바위, 보 정보
 * 출력: 대결의 결과를 개행처리하여 출력
 * 풀이후기:
 *  - 조건만 잘 읽으면 풀기 어렵지 않은 문제
 *  - Section 1이 더 어려웠던거 같기도 하다.
 * */

public class Main {

    public static String solution(int n, int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(a[i] == b[i]) {
                sb.append("D").append("\n");
                continue;
            }
            
            if((a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)) {
                sb.append("A");
            }else {
                sb.append("B");
            }
                
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.print(solution(n, a, b));
    }
}
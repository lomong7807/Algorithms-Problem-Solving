import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 계단 오르기
 *  - 번호 : 2579
 *  - 링크 : https://www.acmicpc.net/problem/2579
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.print();
    }
}
import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 숫자 카드 2
 *  - 번호 : 10816
 *  - 링크 : https://www.acmicpc.net/problem/10816
 * 2. 풀이핵심
 *  - HashMap
 * 3. 풀이후기
 *  - HashMap 자료구조를 사용하면 그리 풀기 어렵지 않은 문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");
        }

        System.out.print(sb);
    }

    public static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(key <= arr[mid]) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(key < arr[mid]) {
                hi = mid
            }else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         int n = Integer.parseInt(br.readLine());
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         HashMap<Integer, Integer> map = new HashMap<>();

//         while(st.hasMoreTokens()) {
//             int key = Integer.parseInt(st.nextToken());
//             map.putIfAbsent(key, 0);
//             map.computeIfPresent(key, (k, v) -> v + 1);
//         }

//         int m = Integer.parseInt(br.readLine());
//         st = new StringTokenizer(br.readLine());

//         while(st.hasMoreTokens()) {
//             int key = Integer.parseInt(st.nextToken());
//             if(map.containsKey(key)) {
//                 sb.append(map.get(key));
//             }else {
//                 sb.append(0);
//             }
//             sb.append(" ");
//         }

//         System.out.print(sb);
//     }
// }
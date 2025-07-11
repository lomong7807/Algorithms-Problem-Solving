import java.io.*;
import java.util.*;
/*
 * 문제: 오름차순으로 정렬이 된 두 배열을 오름차순으로 합쳐 출력
 * 입력: 첫 번째 배열의 크기 N(1<=N<=100)
 *      N개의 배열 원소 오름차순
 *      두 번째 배열의 크기 M(1<=M<=100)
 *      M개의 배열 원소 오름차순
 * 출력: 오름차순으로 정렬된 합쳐진 배열
 * 풀이후기:
 *  - 딱히 어렵지 않은 문제였음
 *  - 나는 병합 자료구조를 배열으로 했는데, List로 하면 코드가 훨씬 줄어들고 가독성도 좋아졌다.
 *  - 배열을 합치라고 해서 당연히 배열에다 합칠 생각을 한건데, 좀 더 다양하게 생각을 해봐야겠다.
 *  - 실제로 성능도 List 자료구조로 합친게 더 좋음
 *  - array: 118ms, 26MB
 *  - list: 126ms, 26MB
 *  - 그리고 몰랐는데, 이런걸 투 포인터 알고리즘이라고 하더라. 포인터가 두개라 그런가보다.
 * */

public class Main {

    public static String solution(int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int lt1 = 0;
        int lt2 = 0;

        while(lt1 < arr1.length && lt2 < arr2.length) {
            if(arr1[lt1] < arr2[lt2]) {
                list.add(arr1[lt1]);
                lt1++;
            }else {
                list.add(arr2[lt2]);
                lt2++;
            }
        }

        while(lt1 < arr1.length) {
            list.add(arr1[lt1]);
            lt1++;
        }

        while(lt2 < arr2.length) {
            list.add(arr2[lt2]);
            lt2++;
        }

        for(int n : list) {
            sb.append(n).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(arr1, arr2));
    }

    // public static String solution(int[] arr1, int[] arr2) {
    //     StringBuilder sb = new StringBuilder();
    //     int[] merge = new int[arr1.length + arr2.length];
    //     int i = 0;
    //     int lt1 = 0;
    //     int lt2 = 0;

    //     while(lt1 < arr1.length && lt2 < arr2.length) {
    //         if(arr1[lt1] < arr2[lt2]) {
    //             merge[i] = arr1[lt1];
    //             lt1++;
    //             i++;
    //         }else {
    //             merge[i] = arr2[lt2];
    //             lt2++;
    //             i++;
    //         }
    //     }

    //     if(lt1 < arr1.length) {
    //         while(i < merge.length) {
    //             merge[i] = arr1[lt1];
    //             lt1++;
    //             i++;
    //         }
    //     }

    //     if(lt2 < arr2.length) {
    //         while(i < merge.length) {
    //             merge[i] = arr2[lt2];
    //             lt2++;
    //             i++;
    //         }
    //     }

    //     for(int n : merge) {
    //         sb.append(n).append(" ");
    //     }

    //     return sb.toString();
    // }
}
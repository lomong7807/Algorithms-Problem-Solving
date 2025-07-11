import java.io.*;
import java.util.*;
/*
 * 문제: 두 배열을 입력받아 공통된 원소의 배열을 오름차순 출력
 * 입력: 첫 번째 배열의 크기 N(1<=N<=30,000)
 *      N개의 배열 원소
 *      두 번째 배열의 크기 M(1<=M<=30,000)
 *      M개의 배열 원소
 * 출력: 오름차순으로 정렬된 공통된 원소의 배열
 * 풀이후기:
 *  - 문제가 그리 어려운게 아니었는데, 자꾸 Time Limitted Exception이 발생했다.
 *  - 처음에 List.contains()로 해당 원소가 있는지 확인했는데, 이게 문제였음
 *  - HashSet.conatins()를 사용해야 했다.
 *  - List.contains(): 내부적으로 반복문을 통해 확인. O(n)
 *  - HashSet.contains(): 내부적으로 해시코드로 바로 해당 버킷에 접근. 평균적으로 O(1)
 * */

public class Main {

    public static String solution(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        Collections.sort(list);
        for(int n : list) {
            sb.append(n).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(set.contains(tmp)) {
                list.add(tmp);
            }
        }

        System.out.print(solution(list));
    }
}
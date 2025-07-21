import java.io.*;
import java.util.*;
/*
 * 문제: 임의의 N개의 숫자가 입력으로 주어진다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
        이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램.
        단, 중복값은 존재하지 않음
 * 입력: 첫 줄에 좌표의 개수인 N(3<=N<=1,000,000), M
        두 번째 줄부터 N개의 수가 공백을 사이에 두고 주어짐
 * 출력: 정렬 후 M의 값의 위치 번호
 * 풀이후기:
 *  - 이분검색을 어떻게 해야될지는 알겠는데, 코드로 직접 구현하는데 어려움이 있어 결국 풀이를 봤음
 *  - 시작 위치와 마지막 위치를 합친 후 나눠 중간 위치를 찾는다.
 *  - 만약 바로 해당 위치의 값이 m이라면 해당 값을 return하고 종료
 *  - 만약 해당 위치의 값이 m보다 크면 좌측 영역을 재탐색해야 하므로 rt의 값을 mid - 1으로 설정
 *  - 만약 해당 위치의 값이 m보다 작으면 우측 영역을 재탐색해야 하므로 lt의 값을 mid + 1으로 설정
 *  - 중복된 값이 없으므로 이렇게 반복하다보면 값을 찾게 됨
 *  - 종료: 만약 lt=7, rt=8으로 된다면 mid = 7이 되고, arr[7]이 m인지 확인한다.
 *         m < arr[7]이라면 rt = 7이 되고 다시 lt=7,rt=7으로 다음에는 어떻게든 실행이 안됨
 *         arr[7] < m이라면 lt = 8이 되고 다시 lt=8,rt=8으로 다음에는 어떻게든 실행이 안됨
 * */

public class Main {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if(m < arr[mid]) {
                rt = mid - 1;
            }else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, m, arr));
    }
}
import java.io.*;
import java.util.*;
/*
 * 문제: N개의 마구간이 수직선상에 있다. 각 마구간은 x1, x2, x3, ..., xN의 좌표를 가지며, 마구간에 좌표가 중복되는 일은 없다.
        현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않는다.
        각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶다.
        C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력해라.
 * 입력: 첫 줄에 자연수 N(1<=N<=200,000), C(2<=C<=N)
        두 번째 줄에는 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어진다.
 * 출력: 가장 가까운 두 말의 최대 거리
 * 풀이후기:
 *  - 이분검색과 결정알고리즘을 사용한 구현 문제.
 *  - 너무 어려워서 풀이는 아래의 주석으로 달아뒀음.
 *  - 결정 알고리즘에서 count() 함수를 구현하는게 제일 중요하다. 이분탐색은 그냥 그대로 외워도 무관함.
 * */

public class Main {

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);

        // 탐색 범위 설정
        int lt = 1;                   // 최소 거리의 하한 (최소 1은 되어야 함)
        int rt = arr[n - 1];          // 최소 거리의 상한 (전체 구간의 길이)

        while(lt <= rt) {            
            int mid = (lt + rt) / 2;    // 시도해볼 최소 거리
            if(c <= count(mid, arr)) {  // mid 거리로 C마리 이상 배치 가능하다면
                answer = mid;           // 답 후보로 저장
                lt = mid + 1;           // 더 큰 거리도 가능한지 확인
            }else {                     // C마리 배치 불가능하다면
                rt = mid - 1;           // 거리를 줄여서 다시 시도
            }
        }

        return answer;
    }

    // 모든 말들 사이의 거리를 최소 dist 이상으로 유지하면서 최대 몇 마리까지 배치할 수 있는가?를 계산
    public static int count(int dist, int[] arr) {
        int count = 1;              // 첫 번째 마구간에는 무조건 말을 배치
        int endPosition = arr[0];   // 마지막으로 말을 배치한 위치
        // 이전에 배치한 말과의 거리가 우리가 목표로 하는 최소 거리(dist) 이상인가?
        // 이 조건을 만족해야만 "가장 가까운 두 말의 거리가 최소 dist가 되는" 배치가 가능하기 때문이다.
        for(int i = 0; i < arr.length; i++) {
            if(dist <= arr[i] - endPosition) {  // 현재 위치가 마지막 배치 위치로부터 dist 이상 떨어져 있다면
                count++;                        // 말을 배치
                endPosition = arr[i];           // 배치 위치 업데이트
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, c, arr));
    }
}
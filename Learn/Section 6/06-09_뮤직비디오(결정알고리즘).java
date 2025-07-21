import java.io.*;
import java.util.*;
/*
 * 문제: 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
        DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
        즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다.
        또한 한 노래를 쪼개서 두 개의 DVD로 녹화하면 안된다.
        지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
        고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 했다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
        그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
 * 입력: 첫 줄에 좌표의 개수인 N(1<=N<=1,000), M(1<=M<=N)
        두 번째 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
        부른 곡의 길이는 10,000분을 넘지 않는다.
 * 출력: DVD의 최소 용량의 크기를 출력한다
 * 풀이후기:
 *  - 이분검색과 결정알고리즘을 사용한 구현 문제.
 *  - 이것도 처음 보는거라 이해하기 쉽지 않았음.
 *  - Stream API
 *    최대값 구하기: Arrays.stream(arr).max().getAsInt()
 *    - max()의 반환 값이 int가 아니므로 꼭 getAsInt()를 해줘야 한다. (long: getAsLong, double: getAsDouble)
 *    합 구하기: Arrays.stream(arr).sum()
 *    - int를 반환하므로 getAsInt()를 해주지 않아도 됨
 *  - 결정알고리즘이라는게 너무 이해가 안갔는데 솔직히 아직도 막 정확히는 모르겠다. 조금이라도 다른 유형으로 변형돼서 나오면 어려울듯함
 * */

public class Main {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(mid, arr) <= m) {
                rt = mid - 1;
                answer = mid;
            }else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static int count(int capcacity, int[] arr) {
        int count = 1;
        int sum = 0;

        for(int x : arr) {
            if(capcacity < sum + x) {
                count++;
                sum = x;
            }else {
                sum += x;
            }
        }

        return count;
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
import java.io.*;
import java.util.*;
/*
 * 문제: 철수네 반에는 N명의 학생들이 있다.
        선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠다.
        제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여한다. 철수는 짝꿍보다 키가 크다.
        그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨다.
        선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했다.
        철수와 짝꿍이 자리를 반꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호화 철수 짝꿍이 받은 번호를
        차례로 출력하는 프로그램
 * 입력: 첫 줄에 자연수 N(5<=N<=100)
        두 번째 줄에 제일 앞에서부터 일렬로 서있는 학생들의 키가 주어진다.
        키(높이) 값 H는 (120<=H<=180)의 자연수이다.
 * 출력: 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력
 * 풀이후기:
 *  - 분명 쉬워보이는데 1시간을 넘게 고민해봐도 모르겠어서 풀이를 봤음
 *  - 답은 정렬된 배열을 하나 더 만드는것이었다.
 *  - 원래의 순서(오름차순)대로 있어야 되는데 잘못된 부분이 있다면 해당 부분이 바뀐 것으로 알면 된다.
 *  - 굉장히 단순한 문제였는데, 너무 복잡하게 생각하고 있었고 해당 풀이 방식을 떠올리지도 못했다.
 *  - 배열을 그대로 복사할 때는 arr.clone()으로 그대로 깊은 복사를 할 수 있음.
 * */

public class Main {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] != sortArr[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }

        System.out.print(solution(arr));
    }
}
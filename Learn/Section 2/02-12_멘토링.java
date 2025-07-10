import java.io.*;
import java.util.*;
/*
 * 문제: 멘토링 시스템.
 *      멘토링은 멘토와 멘티가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것이다.
 *      만약 A학생이 멘토이고, B학생이 멘티이면 A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 한다.
 *      M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지인지 출력하는 프로그램 작성
 * 입력: 학생의 수 N(1<=N<=20), 수학 테스트 횟수 M(1<=M<=10)
 *      두 번째 줄부터는 M개의 줄에 걸쳐 수학테스트 결과가 학생 번호로 주어진다. 제일 왼쪽에서부터 1등, 2등, ...N등 순으로 표시
 *      만약 한 줄에 N=4이고, 테스트 결과가 3 1 4 2로 입력되었다면
 *      1등: 3번 학생
 *      2등: 1번 학생
 *      3등: 4번 학생
 *      4등: 2번 학생
 * 출력: 멘토, 멘티가 성립하는 총 경우의 수
 * 풀이후기:
 *  - 이번 문제 너무 어려웠다.
 *  - 4중 for문까지 할 일이 잘 없으니 조건을 생각하는데 머리가 너무 복잡했다. 결국 풀이를 봤음
 *  - 근데 강사님이 풀이한 풀이 내용보다 claude의 풀이가 훨씬 직관적으로 이해가 됐음.
 *  - 해당 문제는 많이 복잡하니 주석에 풀이 해석을 달아두겠음
 * */

public class Main {

    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;

        // 모든 학생 쌍을 확인 (멘토 후보 i, 멘티 후보 j)
        for(int i = 1; i <= n; i++) {       // 멘토 후보 (1번~n번 학생)
            for(int j = 1; j <= n; j++) {   // 멘티 후보 (1번~n번 학생)
                if(i == j) continue;        // 자기 자신은 제외

                boolean canMentor = true;   // i가 j의 멘토가 될 수 있는지 확인

                // 모든 시험에서 i가 j보다 등수가 높은지 확인
                for(int test = 0; test < m; test++) {
                    int mentorRank = 0, menteeRank = 0;

                    // 해당 시험에서 i와 j의 등수를 찾기
                    for(int rank = 0; rank < n; rank++) {
                        if(arr[test][rank] == i) {
                            mentorRank = rank + 1;  // 등수는 1부터 시작
                        }
                        if(arr[test][rank] == j) {
                            menteeRank = rank + 1;
                        }
                    }

                    // 만약 한 시험에서라도 i가 j보다 등수가 낮다면
                    if(mentorRank > menteeRank) {
                        canMentor = false;
                        break;
                    }
                }
                // 모든 시험에서 i가 j보다 등수가 높다면 멘토-멘티 가능
                if(canMentor) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken());
        int exam = Integer.parseInt(st.nextToken());

        int[][] arr = new int[exam][student];

        for(int i = 0; i < exam; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < student; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution(student, exam, arr));
    }
}
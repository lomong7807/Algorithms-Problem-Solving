import java.io.*;
/*
* 문제: 입력된 문자열에서 입력된 문자의 개수 찾기(대소문자 구분 x)
* 입력: 문자열, 문자
* 출력: 문자열에서 문자의 개수
* 풀이후기:
*  - 대소문자 구분을 안한다는 조건은 처음 봤음
*  - 그래서 어떻게 해야 생각을 많이 했는데, 그냥 문자열과 문자를 모두 toUpperCase()로 변환 후 비교하면 됨
* */

public class Main {

    public static int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(char x : str.toCharArray()) {
            if(x == t) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = br.readLine().charAt(0);

        System.out.print(solution(str, c));
    }
}
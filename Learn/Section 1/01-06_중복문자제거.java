import java.io.*;
import java.util.*;
/*
 * 문제: 문자열을 입력받아 중복된 문자를 제거하여 출력
        단, 문자의 순서는 앞에서부터 동일해야 한다.
 * 입력: 문자열
 * 출력: 중복된 문자를 제거한 문자열
 * 풀이후기:
 *  - 처음엔 중복이라는 말을 보고 자료구조 Set을 생각했는데, 순서도 맞춰야돼서 List를 사용함
 *  - 그런데 List 자료구조도 굳이 안써도 됐다.
 *  - 간단하게 String.indexOf()를 사용하면 됐다. 
 *  - indexOf()는 문자열의 제일 앞에서부터 탐색해 가장 앞에 있는 문자 index를 return한다.
 *  - 따라서 순회하면서 i의 값과 indexOf()의 값이 같다면 해당 문자가 처음으로 나왔다는 뜻이니 sb에 추가하고
 *  - 아니라면 추가할 필요가 없음
 * */

public class Main {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(i == s.indexOf(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(solution(str));
    }
}
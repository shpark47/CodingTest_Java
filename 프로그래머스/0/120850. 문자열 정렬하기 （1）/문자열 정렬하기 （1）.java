import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String num = my_string.replaceAll("[^0-9]", "");
        int[] answer = new int[num.length()];
        for(int i = 0; i < num.length(); i++) {
            answer[i] = Integer.parseInt(num.charAt(i) + "");
        }
        Arrays.sort(answer);
        return answer;
    }
}
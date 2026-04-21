import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sort = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(sort);
        for (int i = 0; i < sort.length / 2; i++) {
            int temp = sort[i];
            sort[i] = sort[sort.length - 1 - i];
            sort[sort.length - 1 - i] = temp;
        }
        for(int i = 0; i < sort.length; i++) {
            for(int j = 0; j < sort.length; j++) {
                if(emergency[i] == sort[j]) {
                    answer[i] = j + 1;
                }
            }
        }
        return answer;
    }
}
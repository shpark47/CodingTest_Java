import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> list = new ArrayList<>();
        for(int i : numbers) {
            list.add(i);
        }
        
        if(direction.equals("right")) {
            list.remove(list.size() - 1);
            list.add(0, numbers[numbers.length - 1]);
        }else{
            list.remove(0);
            list.add(numbers[0]);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int max = 0;
        int answer = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count > max) {
                max = count;
                answer = num;
            }else if(count == max) {
                answer = -1;
            }
        }
        
        return answer;
    }
}
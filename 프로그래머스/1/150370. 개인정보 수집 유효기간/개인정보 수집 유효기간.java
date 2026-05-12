import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] todayArr = Arrays.stream(today.split("\\."))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        Map<String, Integer> term = new HashMap();
        List<Integer> answer = new ArrayList();
        
        for(int i = 0; i < terms.length; i++) {
            String[] arr = terms[i].split(" ");
            term.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            int[] dayArr = Arrays.stream(arr[0].split("\\."))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            
            int termDay = term.get(arr[1]) * 28;
            
            int num = (todayArr[0] - dayArr[0]) * 12 * 28 + (todayArr[1] - dayArr[1]) * 28 + (todayArr[2] - dayArr[2]);
            
            if(num >= termDay) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
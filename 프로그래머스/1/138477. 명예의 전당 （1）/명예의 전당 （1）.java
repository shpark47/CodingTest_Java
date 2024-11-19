import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        for(int i = 0; i < score.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j = 0; j <= i; j++){
                list.add(score[j]);
            }
            
            Collections.sort(list,Collections.reverseOrder());
            
            if(i < k){
                answer[i] = list.get(i);
            }else{
                answer[i] = list.get(k-1);
            }
        }
        
        return answer;
    }
}
class Solution {
    public String solution(int[] food) {
        String answer = "";
        int[] level = new int[food.length];
        
        level[0] = 0;
        
        for(int i = 1; i < food.length; i++){
            level[i] = food[i]/2;
        }
        
        for(int i = 0; i < level.length; i++){
            for(int j = 0; j < level[i]; j++){
                answer += i;
            }
        }
        
        answer += 0;
        
        for(int i = level.length-1; i > 0; i--){
            for(int j = level[i]; j > 0; j--){
                answer += i;
            }
        }
        
        return answer;
    }
}
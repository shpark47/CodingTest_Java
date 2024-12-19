class Solution {
    public String solution(int[] food) {
        String answer = "";
        int[] level = new int[food.length];
        
        level[0] = 0; // 0레벨(물)은 무조건 1개라 따로 넣어줌
        
        for(int i = 1; i < food.length; i++){ // 레벨마다 2로나눈 개수를 넣음 -> 한사람 몫의 음식개수
            level[i] = food[i]/2;
        }
        
        for(int i = 0; i < level.length; i++){ // 음식 개수의 레벨을 넣음
            for(int j = 0; j < level[i]; j++){
                answer += i;
            }
        }
        
        answer += 0;
        
        for(int i = level.length-1; i > 0; i--){ // 반대로 넣음
            for(int j = level[i]; j > 0; j--){
                answer += i;
            }
        }
        
        return answer;
    }
}
class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(String bab : babbling){
            for(String w : words){
                if(bab.contains(w)){
                    bab = bab.replace(w, " ");
                }
            }
            bab = bab.replace(" ", "");
            if(bab.equals("")) answer++;
        }
        
        return answer;
    }
}
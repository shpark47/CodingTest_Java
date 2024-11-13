class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int count = 0;
        for(int i=0; i < photo.length; i++){
            int num = 0;
            for(int j=0; j < photo[i].length; j++){
                for(int k=0; k < name.length; k++){
                    if(photo[i][j].equals(name[k])){
                        num+=yearning[k];
                    }else{
                        num+=0;
                    }
                }
            }
            answer[i] += num;
        }
        return answer;
    }
}
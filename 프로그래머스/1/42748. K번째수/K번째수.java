import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0]-1; // 시작
            int end = commands[i][1]-1; // 끝
            int find = commands[i][2]-1; // 찾을 값
            
            int a = 0;
            int[] arr = new int[end-start+1];
            for(int j = 0; j < array.length; j++){
                if(j >= start && j <= end){ // 시작과 끝 사이에 있으면
                    arr[a++] = array[j];
                }
            }
            Arrays.sort(arr); // 정렬
            answer[i] = arr[find];
        }
        return answer;
    }
}
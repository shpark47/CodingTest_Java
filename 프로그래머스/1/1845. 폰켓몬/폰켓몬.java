import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]); // 중복 제거
        }
        
        if(set.size() > nums.length/2){ // 중복을 제거했음에도 최댓값보다 크면
            answer = nums.length/2; // 최댓값
        }else{
            answer = set.size(); // 중복을 제거한 개수
        }
        
        return answer;
    }
}
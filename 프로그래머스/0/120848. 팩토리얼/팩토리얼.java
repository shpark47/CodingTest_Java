class Solution {
    public int solution(int n) {
        int answer = 0;
        int fac = 1;
        int i = 1;
        
        while(true) {
            fac *= i;
            System.out.println(fac);
            if(fac > n) {
                answer = i - 1;
                break;
            }
            i++;
        }
        
        
        return answer;
    }
}
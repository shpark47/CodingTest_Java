class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wmax = Math.max(wallet[0],wallet[1]);
        int wmin = Math.min(wallet[0],wallet[1]);
        int bmax = Math.max(bill[0],bill[1]);
        int bmin = Math.min(bill[0],bill[1]);
        
        while(bmin > wmin || bmax > wmax){
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            }else{
                bill[1] = bill[1] / 2;
            }
            bmax = Math.max(bill[0],bill[1]);
            bmin = Math.min(bill[0],bill[1]);
            answer++;
        }
        
        return answer;
    }
}
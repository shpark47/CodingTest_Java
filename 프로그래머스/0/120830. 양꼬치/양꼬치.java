class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int food = n * 12000;
        int drink = (k - n / 10) * 2000;
        answer = food + drink;
        return answer;
    }
}
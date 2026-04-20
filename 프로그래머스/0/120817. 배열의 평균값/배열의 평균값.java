class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double num = 0;
        for(int number : numbers) {
            num += number;
        }
        answer = num / numbers.length;
        return answer;
    }
}
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String num = my_string.replaceAll("[^0-9]", "");
        for(int i = 0; i < num.length(); i++) {
            answer += Integer.parseInt(num.charAt(i) + "");
        }
        return answer;
    }
}
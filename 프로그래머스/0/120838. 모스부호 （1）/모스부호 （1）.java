import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] str = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        for(int i = 0; i < str.length; i++) {
            for(int j = 0; j < morse.length; j++) {
                if(str[i].equals(morse[j])) {
                    answer += alpha[j];
                }
            }
        }
        return answer;
    }
}
import java.util.*; // 안하면 안됨

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i); // 이름과 그에 맞는 순위 저장
        }
        
        for(int i = 0; i < callings.length; i++){
            int no = map.get(callings[i]); // 이름에 맞는 현재 순위 불러놓기
            
            // 순위 바꾸기
            String name = players[no - 1];
            players[no-1] = players[no];
            players[no] = name;
            
            // 바꾼 순위 맵에 저장
            map.put(players[no], no);
            map.put(players[no-1], no-1);
        }
        
        return players;
    }
}
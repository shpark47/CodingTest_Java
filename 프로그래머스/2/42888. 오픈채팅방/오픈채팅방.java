import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();

        ArrayList<String> system = new ArrayList<>(); // Enter, Leave, Change 넣기용
        ArrayList<String> uid = new ArrayList<>(); // uid 넣기용
        ArrayList<String> name = new ArrayList<>(); // name 넣기용

        for(int i = 0; i < record.length; i++){
            String str[] = record[i].split(" "); // 행동, uid, 이름으로 나누기
            system.add(str[0]); // 행동
            uid.add(str[1]); // uid
            if(str.length > 2){ // Leave가 아니면
                map.put(uid.get(i), str[2]); // 이름 넣기
            }
        }

        ArrayList<String> answer = new ArrayList<>(); // 답
        for(int i = 0; i < system.size(); i++){
            if(system.get(i).equals("Enter")){
                answer.add(map.get(uid.get(i)) + "님이 들어왔습니다."); // uid를 키값으로 이름 가져오기
            }else if(system.get(i).equals("Leave")){
                answer.add(map.get(uid.get(i)) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}
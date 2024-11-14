// import java.util.*;

// class Solution {
//     public String[] solution(String[] record) {
//         HashMap<String, String> map = new HashMap<>();

//         int n = record.length;
        
//         List<String> list = new ArrayList<>();

//         for(int i = 0; i < n; i++){
//             String str[] = record[i].split(" ");
            
//             String action = str[0];
//             String id = str[1];
            
//             if(action.equals("Enter")){
//                 map.put(id, str[2]);
//                 list.add(id + ":님이 들어왔습니다.");
//             }else if(action.equals("Leave")){
//                 list.add(id + ":님이 나갔습니다.");
//             }else{
//                 map.put(id, str[2]);
//             }
//         }

//         String answer[] = new String[list.size()];
//         for(int i = 0; i < list.size(); i++){
            
//         }
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();

        int n = record.length;

        ArrayList<String> system = new ArrayList<>();
        ArrayList<String> uid = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String str[] = record[i].split(" ");
            system.add(str[0]);
            uid.add(str[1]);
            if(str.length > 2){
                map.put(uid.get(i), str[2]);
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < system.size(); i++){
            if(system.get(i).equals("Enter")){
                answer.add(map.get(uid.get(i)) + "님이 들어왔습니다.");
            }else if(system.get(i).equals("Leave")){
                answer.add(map.get(uid.get(i)) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}
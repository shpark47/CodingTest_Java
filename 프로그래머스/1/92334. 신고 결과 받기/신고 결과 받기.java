import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>();
        int[] irr = new int[id_list.length];
        
        int n = report.length;
        
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        
        for(int i = 0; i < n; i++){ // 중복된 애들 제거
            set.add(report[i]);
        }
        
        String[] srr = new String[set.size()];
        int l = 0;
        Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			srr[l] = it.next(); // 중복된 애들 없애고 남은 report 넣기
            l++;
		}
        
        for(int i = 0; i < srr.length; i++){
            String[] s = srr[i].split(" ");
            str1[i] = s[0]; // 신고자
            str2[i] = s[1]; // 신고 당한 사람
        }
        
        // 신고당한 횟수 넣기
        int count=0;
        for(int i = 0; i < id_list.length; i++){
            for(int j = 0; j < str2.length; j++){
                if(id_list[i].equals(str2[j])){
                    count++;
                }
            }
            irr[i] = count;
            count=0;
        }
        
        // k회 이상 신고 당한 사람들 넣기
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < irr.length; i++){
            if(irr[i] >= k){
                list.add(id_list[i]);
            }
        }
        
        int[] answer = new int[id_list.length];
        int count2 = 0;
        for(int i = 0; i < id_list.length; i++){
            for(int j = 0; j < str1.length; j++){
                // id_list에 있는 사람과 신고자가 같으면
                if(id_list[i].equals(str1[j])){
                    for(int a = 0; a < list.size(); a++){
                        // 신고자가 신고한 사람과 리스트에 있는 사람이 같으면
                        if(str2[j].equals(list.get(a))){
                            count2++;
                            answer[i] += count2;
                        }
                    }
                }
                count2 = 0;
            }
        }
        return answer;
    }
}
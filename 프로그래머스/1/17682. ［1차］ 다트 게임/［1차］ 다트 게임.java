import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> no = new ArrayList<>();
        ArrayList<String> bonus = new ArrayList<>();
        ArrayList<String> op = new ArrayList<>();
        
        for(int i = 0; i < dartResult.length(); i++){ //한 글자씩 넣기
            String s = dartResult.substring(i, i+1);
            list.add(s);
        }
        
        for(int i = 0; i < list.size(); i++){ //10이 있을경우
            // 앞에 들어간게 1이고 지금 가져온게 0이면 = 10이면
            if(i > 0 && list.get(i-1).equals("1") && list.get(i).equals("0")){
                list.set(i-1, "10"); //앞에 걸 10으로 변경
                list.remove(i); //지금 리스트 삭제 = 뒤에있는 리스트 당겨짐
            }
        }
        
        boolean nock = false; //숫자가 들어갔는지
        boolean bock = false; //보너스가 들어갔는지
        int ncount = 0; //숫자가 몇개 들어갔는지
        int bcount = 0; //보너스가 몇개 들어갔는지
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if(nock && bock){ //숫자와 보너스가 들어왔으면
                if(!(s.equals("*") || s.equals("#"))){ //*이나 #이 아니면 빈칸
                    op.add("");
                }else{
                    op.add(s);
                }
                nock = false; //숫자, 보너스 체크 초기화
                bock = false;
            }
            //숫자면
            if(!(s.equals("S") || s.equals("D") || s.equals("T") || s.equals("*") || s.equals("#"))){
                if(ncount == 0){ //첫번째 숫자
                    no.add(Integer.parseInt(s));
                }else if(ncount == 1){ //두번째 숫자
                    no.add(Integer.parseInt(s));
                }else if(ncount == 2){ //세번째 숫자
                    no.add(Integer.parseInt(s));
                }
                nock = true; //숫자 들어옴
                ncount++; //들어올때마다 +
            }else if(s.equals("S") || s.equals("D") || s.equals("T")){ //보너스면
                if(bcount == 0){ //bonus
                    bonus.add(s);
                }else if(bcount == 1){
                    bonus.add(s);
                }else if(bcount == 2){
                    bonus.add(s);
                }
                bock = true;
                bcount++;
            }
        }
        
        for(int i = 0; i < 3; i++){ //옵션이 3개 미만이면
            if(op.size() < 3){
                op.add(""); //빈 데이터 넣기
            }
        }
        
        int[] nb = new int[3];
        for(int i = 0; i < 3; i++){ //점수, 보너스 합침
            String bo = bonus.get(i);
            int n = no.get(i);
            if(bo.equals("S")){
                nb[i] = n;
            }else if(bo.equals("D")){
                nb[i] = n * n;
            }else{
                nb[i] = n * n * n;
            }
        }
        
        int[] nbo = new int[3];
        for(int i = 0; i < 3; i++){ //점수, 보너스 합친거에 옵션 적용
            int n = nb[i];
            String o = op.get(i);
            if(i == 0 && o.equals("*")){
                nbo[i] = n * 2;
            }else{
                if(o.equals("")){
                    nbo[i] = n;
                }else if(o.equals("*")){
                    nbo[i - 1] = nbo[i - 1] * 2;
                    nbo[i] = n * 2;
                }else if(o.equals("#")){
                    nbo[i] = n * (-1);
                }
            }
        }
        
        answer = nbo[0] + nbo[1] + nbo[2];
        
        return answer;
    }
}
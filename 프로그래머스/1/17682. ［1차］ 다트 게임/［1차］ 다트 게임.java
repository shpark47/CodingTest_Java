import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> no = new ArrayList<>();
        ArrayList<String> bonus = new ArrayList<>();
        ArrayList<String> op = new ArrayList<>();
        
        for(int i = 0; i < dartResult.length(); i++){
            String s = dartResult.substring(i, i+1);
            list.add(s);
        }
        
        for(int i = 0; i < list.size(); i++){
            if(i > 0 && list.get(i-1).equals("1") && list.get(i).equals("0")){
                list.set(i-1, "10");
                list.remove(i);
            }
        }
        
        boolean nock = false;
        boolean bock = false;
        int ncount = 0;
        int bcount = 0;
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if(nock && bock){
                if(!(s.equals("*") || s.equals("#"))){ //op
                    op.add("");
                }else{
                    op.add(s);
                }
                nock = false;
                bock = false;
            }
            if(!(s.equals("S") || s.equals("D") || s.equals("T") || s.equals("*") || s.equals("#"))){
                if(ncount == 0){ //no
                    no.add(Integer.parseInt(s));
                }else if(ncount == 1){
                    no.add(Integer.parseInt(s));
                }else if(ncount == 2){
                    no.add(Integer.parseInt(s));
                }
                nock = true;
                ncount++;
            }else if(s.equals("S") || s.equals("D") || s.equals("T")){
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
        
        for(int i = 0; i < 3; i++){
            if(op.size() < 3){
                op.add("");
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
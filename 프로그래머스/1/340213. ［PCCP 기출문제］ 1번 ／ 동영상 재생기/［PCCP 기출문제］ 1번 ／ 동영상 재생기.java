class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoSec = changeTime(video_len);
        int posSec = changeTime(pos);
        int opStartSec = changeTime(op_start);
        int opEndSec = changeTime(op_end);
        
        posSec = checkOpening(posSec, opStartSec, opEndSec);
        
        for(String s : commands){
            if(s.equals("next")){
                posSec += 10;
                if(posSec > videoSec){
                    posSec = videoSec;
                }
            }else{
                posSec -= 10;
                if(posSec < 10){
                    posSec = 0;
                }
            }
            posSec = checkOpening(posSec, opStartSec, opEndSec);
        }
        
        answer = String.format("%02d:%02d", posSec/60, posSec%60);
        
        return answer;
    }
    
    public int changeTime(String time){
        String[] timeSec = time.split(":");
        return Integer.parseInt(timeSec[0]) * 60 + Integer.parseInt(timeSec[1]);
    }
    
    public int checkOpening(int posSec, int opStartSec, int opEndSec){
        if(posSec < opEndSec && posSec >= opStartSec){
            return posSec = opEndSec;
        }
        return posSec;
    }
}
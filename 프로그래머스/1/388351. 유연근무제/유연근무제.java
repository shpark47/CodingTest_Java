class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int schedule = schedules[i];
            int limitTime = getLimitTime(schedule);
            
            boolean isPerfect = true;
            int currentDay = startday;

            for (int j = 0; j < 7; j++) {
                if (currentDay != 6 && currentDay != 7) {
                    if (timelogs[i][j] > limitTime) {
                        isPerfect = false;
                        break;
                    }
                }
                
                currentDay++;
                if (currentDay > 7) {
                    currentDay = 1;
                }
            }

            if (isPerfect) {
                answer++;
            }
        }

        return answer;
    }

    private int getLimitTime(int time) {
        int hour = time / 100;
        int min = time % 100;

        min += 10;

        if (min >= 60) {
            hour += 1;
            min -= 60;
        }

        return (hour * 100) + min;
    }
}
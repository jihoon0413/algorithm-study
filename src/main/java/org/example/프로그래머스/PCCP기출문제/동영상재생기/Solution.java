package org.example.프로그래머스.PCCP기출문제.동영상재생기;

import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int video_len_int = getInt(video_len);
        int pos_int = getInt(pos);
        int op_start_int = getInt(op_start);
        int op_end_int = getInt(op_end);

        if(isInOpening(pos_int, op_start_int, op_end_int)) {
            pos_int = op_end_int;
        }

        for(int i = 0 ; i < commands.length ; i++) {
            if(commands[i].equals("next")) {
                pos_int +=10;
                if(pos_int > video_len_int) {
                    pos_int = video_len_int;
                }
            } else {
                pos_int -= 10;
                if(pos_int < 0) {
                    pos_int = 0;
                }
            }

            if(isInOpening(pos_int, op_start_int, op_end_int)) {
                pos_int = op_end_int;
            }
        }

        int ans_min = pos_int/60;
        int ans_sec = pos_int%60;


        String answer = String.format("%02d",ans_min) + ":" + String.format("%02d",ans_sec);
        return answer;
    }

    private int getInt(String str) {
        StringTokenizer st = new StringTokenizer(str,":");
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        return min*60+sec;

    }

    private boolean isInOpening(int pos, int op_start, int op_end) {
        if(op_start <= pos && pos <= op_end) {
            return true;
        }
        return false;
    }
}

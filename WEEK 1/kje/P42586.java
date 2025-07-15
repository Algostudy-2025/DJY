package programmers;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> end = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int leftday = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.add(leftday);
        }
        
        while(!q.isEmpty()){
            
            int count = 0;
            
            int fixed_date = q.poll();
            count ++;
            
            while(!q.isEmpty() && fixed_date >= q.peek()){
                q.poll();
                count ++;
            }
            
            end.add(count);
        } 
            
        int[] answer = new int[end.size()];
        for (int i = 0; i < end.size(); i++) {
            answer[i] = end.get(i);
        }
        
    return answer;
    }
}

//자료구조 함수들 다시 정리하기 Queue는 pop이 아니라 poll 
//peek 하기 전에 Queue가 null인지 확인하기
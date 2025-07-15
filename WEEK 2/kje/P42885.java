package programmers;

import java.util.*;

//2개씩 짝짓는 문제 -> 정렬 시키고 투포인터로 풀기
class Solution {
  public int solution(int[] people, int limit) {
      Arrays.sort(people);
      
      int heavy = people.length -1; //가장 무거운 사람 인덱스
      int light = 0; //가장 가벼운 사람 인덱스
      int count = 0; //보트 수
      
      while(heavy >= light){
          if(limit >= people[heavy] + people[light]){ //한 보트에 둘 다 태울 경우
              light++; 
          }
          //무거운 사람만 태울 경우
          heavy--;
          count++;
      }
      return count;
  }
}


/*
class Solution {
  public int solution(int[] people, int limit) {
      
      boolean[] visited = new boolean[people.length];
      int count = 0;
      
      Arrays.sort(people);
              
      for(int i = 0; i < people.length; i++){
                                              
          if(visited[i]) continue;
          
          int minMargin = Integer.MAX_VALUE;
          int idx = -1;
          
          for (int j = people.length - 1; j > i; j--) {
              if(visited[j]) continue;

              if(people[i] + people[j] <= limit){
                  int gap = limit - (people[i] + people[j]);
              
                  if(gap >= 0 && gap < minMargin){
                      minMargin = gap;
                      idx = j;
                  }
              }
          }
          
          if (idx != -1) {
              visited[i] = true;
              visited[idx] = true;
              count++;
          } else {
              visited[i] = true;
              count++;
          }
      }
      return count;
  }
}
*/
package sprinklInter;

import java.util.HashSet;
import java.util.Set;

public class longestStringWIthiutRepeating {
    public static void main(String[] args){
      int[] j={4,52,0,5,0,0,0,34,0,33,8,9,0};
      int count=0;
      for(int i=0;i<j.length;i++){
          if(j[i]!=0){
              j[count]=j[i];
              count ++;
          }
      }
      while(count<j.length){
          j[count]=0;
          count++;
      }
       for(int i:j){
           System.out.println(i);
       }
    }
}

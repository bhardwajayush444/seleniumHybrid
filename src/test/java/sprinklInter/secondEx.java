package sprinklInter;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class secondEx {
    public static void main(String[] args){
        int[] j={3,2,1,5,6,4};
        List<Integer> hi=new LinkedList<>();
        for(int i=0;i<j.length;i++){
            hi.add(j[i]);
        }
        for(int k=0;k<hi.size();k++){
            int currentInt=hi.get(k);
            if(currentInt%2==0){
                hi.remove(k);
                hi.add(0,currentInt);
            }
        }
        System.out.println(hi);
    }
}

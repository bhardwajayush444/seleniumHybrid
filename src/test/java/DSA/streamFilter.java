package DSA;

import java.util.ArrayList;
import java.util.List;

public class streamFilter {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(12);
       // System.out.println(list);
        list.stream().filter(num -> num%3==0).forEach(System.out::println);
    }
}

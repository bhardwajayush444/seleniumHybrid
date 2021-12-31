package DSA;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args){
        int[] arr={1,-1,0,-2};
        for(int i=0;i<=arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<=arr.length-1;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int smallerNo=arr[min];
            arr[min]=arr[i];
            arr[i]=smallerNo;
        }

        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }

}

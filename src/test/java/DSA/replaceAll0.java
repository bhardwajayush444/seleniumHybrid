package DSA;

public class replaceAll0 {
    public static void main(String[] args){
        int a[]={1,0,1,1,1,0,0,0,0,1};
        int temp=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                a[temp++]=a[i];
            }
        }
        while(temp<a.length){
            a[temp++]=0;
        }
        for(int j:a){
            System.out.println(j);
        }

    }
}

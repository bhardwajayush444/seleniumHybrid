package DSA;

public class reverseNumber {
    public static void main(String[] args){
        int a=1678;
        int rev=0;
        while(a!=0){
            int rem=a%10;
            System.out.print(rem+" ");
            rev=rev*10+rem;
            System.out.print(rev+" ");
            a=a/10;
            System.out.print(a);
            System.out.println(" ");

        }
    }
}

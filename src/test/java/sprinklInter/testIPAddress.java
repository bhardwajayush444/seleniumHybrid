package sprinklInter;

public class testIPAddress {
    public int isValidIp(String ip){
        String[] myIp=ip.split(".");
        int result=0;
        if(myIp.length!=4){
            return -1;
        }
        else{
            for(int i=0;i<myIp.length;i++){
                int currentIp=Integer.valueOf(myIp[i]);
                if(currentIp<0 || currentIp>255){
                    result=-1;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        testIPAddress myclass=new testIPAddress();
        System.out.println(myclass.isValidIp("100.256.255.121"));
    }
}

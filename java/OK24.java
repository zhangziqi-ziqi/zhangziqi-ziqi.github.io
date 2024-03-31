import java.util.Scanner;
public class OK24{
    //mian方法,表示程序主入口
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n=myScanner.nextInt(),i,j,k,l,m,sum=0;
        int[] card= new int[5];
        while(n-->0){
            //数组赋值
            i=0;
            while(i<5){
                card[i]=myScanner.nextInt();
                i++;
            }
            int canGet24=0;
 l1:        for(i=-1;i<2;i++){//枚举
                for(j=-1;j<2;j++){
                    for(k=-1;k<2;k++){
                        for(l=-1;l<2;l++){
                            for(m=-1;m<2;m++){
                                sum=card[0]*i+card[1]*j+card[2]*k+card[3]*l+card[4]*m;
                                if(sum==24){
                                    canGet24=1;
                                    break l1;
                                }
                            }
                        }
                    }
                }
            }
            if(canGet24==1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        myScanner.close();
    }
}
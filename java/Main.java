import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n,i,j,sum=0,min=0,temp;
        n = cin.nextInt();
        int[] CMem=new int[n];
        for(i=0;i<n;i++){
            CMem[i]=cin.nextInt();
        }
        for(j=0;j<(n+1)/2;j++){
            min=0;
            for(i=0;i<n-j;i++){
                if( CMem[i] < CMem[min]){
                    min=i;
                }
            }
            //计算和
            sum+=(CMem[min]+1)/2;
            //数组排序
            if(n-j-1 != min){
                temp=CMem[n-j-1];
                CMem[n-j-1]=CMem[min];
                CMem[min]=temp;
            }
        }
        System.out.println(sum);
        cin.close();
    }
}
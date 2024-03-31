import java.util.Scanner;
public class xunhuanLshift {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int length=cin.nextInt(),shiftby=cin.nextInt(),i;
        int count;//填入temp数组内容时用于记录下标
        int[] arry = new int[length];
        int[] temp=new int[shiftby];
        //建立数组
        for(i=0;i<length;i++){
            arry[i]=cin.nextInt();
        }
        //存放开头移位数个整数
        for(i=0;i<shiftby;i++){
            temp[i]=arry[i];
        }
        //左移shiftby位
        for(i=0;i<length-shiftby;i++){
            arry[i]=arry[i+shiftby];
        }
        count=0;
        for(;i<length;i++){
            arry[i]=temp[count++];
        }
        for(i=0;i<length;i++){
            System.out.printf("%d", arry[i]);
            if(i!=length-1) System.out.printf(" ");
            else  System.out.printf("\n");
        }
        cin.close();
    }
}

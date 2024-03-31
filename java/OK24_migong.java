import java.util.Scanner;
public class OK24_migong {
    //mian方法,表示程序主入口
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n=myScanner.nextInt(),i;
        int[] card= new int[5];
        boolean Ok24;
        while(n-->0){
            //数组赋值
            i=0;
            while(i<5){
                card[i]=myScanner.nextInt();
                i++;
            }
            //深度优先4轮运算
            YesNo judge =new YesNo();
            Ok24=judge.cardDFS(card);
            if(Ok24)
            System.out.printf("Yes");
            else
            System.out.printf("No");

        }
        myScanner.close();
    }
}
class Stack{
    public int sum;
    public int i;
    public int count;
}
class YesNo{
    Stack[] operation = new Stack[10];
    int n=0;
    //深度优先4轮运算
    public boolean cardDFS(int[] card){
        int count,i,sum,j;
        for (j= 0; j < operation.length; j++) {
            operation[j] = new Stack();
        }
        push(0,0,3);
        while(!isEmpty()){
            pop();
            count=operation[n].count;
            i=operation[n].i;
            sum=operation[n].sum;
            if(sum==24)
            return true;
            else
            {
                    if(count==3){
                        push(sum,i,count-1);
                        sum+=card[i];
                    }
                    if(count==2)
                        push(sum,i,count-1);
                    if(count==1){
                        sum-=card[i];
                    }
                    if (i<4) {
                        push(sum,i+1,3);
                    }
            }
        }
        return false;
    }
    private boolean isEmpty(){
        if(n==0)
            return true;
        else 
            return false;
    }
    private void pop(){
        n--;
    }
    private void push(int sum,int i,int count){
        operation[n].sum=sum;
        operation[n].i=i;
        operation[n].count=count;
        n++;
    }
}

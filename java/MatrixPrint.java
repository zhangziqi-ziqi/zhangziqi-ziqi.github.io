import java.util.Scanner;
public class MatrixPrint {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//n阶方阵
        int[][] Matrix = new int[n][n];
        int i,j,i1,j1,count=1;
        for(j=0;j<n;j++){//第j列
            i=j;
            for(i1=0;i1<=i;i1++)//0~i行
            {
                Matrix[i1][j]=count;
                count++;
            }
            for(j1=j-1;j1>-1;j1--){//j-1~0列
                Matrix[i][j1]=count;
                count++;
            }
        }
        //按行打印
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.printf("%d",Matrix[i][j]);
                if(j!=n-1) System.out.printf(" ");
                else System.out.printf("\n");
            }
        }
        cin.close();
    }
}

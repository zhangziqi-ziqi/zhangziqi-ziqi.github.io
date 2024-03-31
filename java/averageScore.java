import java.util.Scanner;
public class averageScore {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(),m;
        int i,j,sum,min=0,k;
        int[][] SCORE = new int[n][];//二维数组，记录每位老师信息
        int[] AVERAGE = new int[n];//一维数组，按序记录平均成绩
        for(i=0;i<n;i++){//每位老师
            m = cin.nextInt();
            int[] x = new int[m];//创建记录行
            SCORE[i]=x;
            sum=0;
            for(j=0;j<m;j++){//每个学生
                SCORE[i][j] = cin.nextInt();
                sum+=SCORE[i][j];
            }
            AVERAGE[i]=sum/m;
        }
        //按序输出
        for (k = 0; k < n; k++) {
            min = k;
            for (i = k + 1; i < n; i++) {
                if (AVERAGE[i] < AVERAGE[min]) {
                    min = i;
                }
            }
            int[] tempScore = SCORE[k];
            SCORE[k] = SCORE[min];
            SCORE[min] = tempScore;

            int tempAverage = AVERAGE[k];
            AVERAGE[k] = AVERAGE[min];
            AVERAGE[min] = tempAverage;

            for (j = 0; j < SCORE[k].length; j++) {
                System.out.print(SCORE[k][j]);
                if (j != SCORE[k].length - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
        cin.close();
    }
}
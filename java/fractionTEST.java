import java.util.Scanner;

public class fractionTEST {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int aZI = cin.nextInt();
        int aMu = cin.nextInt();
        int bZI = cin.nextInt();
        int bMu = cin.nextInt();
        fraction F  = new fraction();
        F.SETfraction(aZI, aMu, bZI, bMu);
        int gcd = gcd(Math.abs(aZI), Math.abs(aMu));
        aZI /= gcd;
        aMu /= gcd;
        if(aMu<0){
            aZI = -aZI;
            aMu = -aMu;
        }
        System.out.printf("%d/%d\n",aZI,aMu);
        gcd = gcd(Math.abs(bZI), Math.abs(bMu));
        bZI /= gcd;
        bMu /= gcd;
        if(bMu<0){
            bZI = -bZI;
            bMu = -bMu;
        }
        System.out.printf("%d/%d\n",bZI,bMu);
        F.ADDfraction();
        F.ReducedFraction();
        F.PRINTfraction();

        F.SUBfraction();
        F.ReducedFraction();
        F.PRINTfraction();

        F.MULfraction();
        F.ReducedFraction();
        F.PRINTfraction();

        F.DIVfraction();
        F.ReducedFraction();
        F.PRINTfraction();

        F.INVERSEfraction();
        F.ReducedFraction();
        F.PRINTfraction();

        F.TOdecimal();
        cin.close();
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

class fraction {
    private int aZI;
    private int aMu;
    private int bZI;
    private int bMu;
    private int cZI;
    private int cMu;
    private double a; 
    public void SETfraction(int aZI, int aMu, int bZI, int bMu) {
        this.aZI = aZI;
        this.aMu = aMu;
        this.bZI = bZI;
        this.bMu = bMu;
    }
    public void PRINTfraction() {
        System.out.println(cZI + "/" + cMu);
    }
    //转化为既约分数
    public void ReducedFraction() {
        int gcd = gcd(Math.abs(this.cZI), Math.abs(this.cMu));
        this.cMu /= gcd;
        this.cZI /= gcd;
        if(cMu<0){
            cZI = -cZI;
            cMu = -cMu;
        }
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public void ADDfraction() {
        cZI = this.aZI * this.bMu + this.bZI * this.aMu;
        cMu = this.aMu * this.bMu;
    }
    public void SUBfraction(){
        cZI = this.aZI * this.bMu - this.bZI * this.aMu;
        cMu = this.aMu * this.bMu;
    }
    public void MULfraction(){
        cZI = this.aZI * this.bZI;
        cMu = this.aMu * this.bMu;
    }
    public void DIVfraction(){
        cZI = this.aZI * this.bMu;
        cMu = this.aMu * this.bZI;
    }
    public void INVERSEfraction(){
        if(aZI>0){
            cZI = this.aMu;
            cMu = this.aZI;
        }
        else{
            cZI = -this.aMu;
            cMu = -this.aZI;
        }
    }
    public void TOdecimal(){
        a = (double)aZI/aMu;
        System.out.printf("%.1f",a);
    }
}
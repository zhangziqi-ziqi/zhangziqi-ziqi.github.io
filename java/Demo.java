import java.util.Scanner;

public  class Demo{
    public static void main(String[] args) {
Scanner a=new Scanner(System.in);
int e=0,b=0,c=0,d=0;
String f=a.nextLine();
int j=0,count=0;
while(j<f.length()&&f.charAt(j)!=' '){
    if(f.charAt(j)=='-')count++;
    else{
        b=b*10+f.charAt(j)-'0';
    }
    j++;
}
if(count==1)b=-b;
j++;
count=0;
while(j<f.length()&&f.charAt(j)!=' '){
    if(f.charAt(j)=='-')count++;
    else{
        c=c*10+f.charAt(j)-'0';
    }
    j++;
}
if(count==1)c=-c;
j++;
count=0;
while(j<f.length()&&f.charAt(j)!=' '){
    if(f.charAt(j)=='-')count++;
    else{
        d=d*10+f.charAt(j)-'0';
    }
    j++;
}
if(count==1)d=-d;
j++;
count=0;
while(j<f.length()&&f.charAt(j)!=' '){
    if(f.charAt(j)=='-')count++;
    else{
        e=e*10+f.charAt(j)-'0';
    }
    j++;
}
if(count==1)e=-e;
mark m1=new mark(b,c);
mark m2=new mark(d,e);
m1.print();
m2.print();
m1.add(m2);
m1.sub(m2);
m1.multi(m2);
m1.divi(m2);
m1.rever();
m1.printfac();
}
public static int maxfactor(int a,int b){
        if(a<0)a=-a;
        if(b<0)b=-b;
        int max=a>b?a:b;
        int min=a>b?b:a;

        while(max%min!=0){
            int c=max%min;
            max=min>c?min:c;
            min=min>c?c:min;
        }
        return min;
}}

class mark{
    public int numer;
    public  int deno;
    public mark(int a,int b){
        if(a<0&&b<0){
            a=-a;
            b=-b;
        }
        if(a>0&&b<0){
            b=-b;
            a=-a;
        }
        numer=a;
        deno=b;
    }
    public void add(mark a){
        int factor= Demo.maxfactor(a.deno,this.deno);
        int c=this.deno/factor;
        int d=a.deno/factor;
        int numer1=c*a.numer+d*this.numer;
        int deno1=c*factor*d;
        int factor1=Demo.maxfactor(numer1,deno1);
        numer1=numer1/factor1;
        deno1=deno1/factor1;
        System.out.println(numer1+"/"+deno1);

    }
    public void sub(mark a){
        int factor= Demo.maxfactor(a.deno,this.deno);
        int c=this.deno/factor;
        int d=a.deno/factor;
        int count=0;
        int numer1=-c*a.numer+d*this.numer;
        int deno1=c*factor*d;
        if(numer1<0){
            count=1;
            numer1=-numer1;
        }
        int factor1=Demo.maxfactor(numer1,deno1);
        numer1=numer1/factor1;
        deno1=deno1/factor1;
        if(count==1) System.out.println("-"+numer1+"/"+deno1);
        else System.out.println(numer1+"/"+deno1);
    }
    public void multi(mark a){
        int numer1=a.numer*this.numer;
        int deno1=a.deno*this.deno;
        int factor=Demo.maxfactor(numer1,deno1);
        numer1=numer1/factor;
        deno1=deno1/factor;
        if(numer1>0&&deno1<0){
            numer1=-numer1;
            deno1=-deno1;
        }
        System.out.println(numer1+"/"+deno1);
    }
    public void divi(mark a){
        int numer1=this.numer*a.deno;
        int deno1=this.deno*a.numer;
        int factor=Demo.maxfactor(numer1,deno1);
        numer1=numer1/factor;
        deno1=deno1/factor;
        if(numer1>0&&deno1<0){
            numer1=-numer1;
            deno1=-deno1;
        }
        if(numer1<0&&deno1<0){
            numer1=-numer1;
            deno1=-deno1;
        }
        System.out.println(numer1+"/"+deno1);
    }
    public void rever(){
        int factor=Demo.maxfactor(numer,deno);
        numer=numer/factor;
        deno=deno/factor;
        if(numer<0&&deno>0){
            numer=-numer;
            deno=-deno;
        }
        System.out.println(deno+"/"+numer);
    }
    public void printfac(){
        float b=numer+(float)0.0;
        float a=b/deno;
        System.out.printf("%.1f\n",a);

    }
    public void print(){
        int factor=Demo.maxfactor(numer,deno);
        numer=numer/factor;
        deno=deno/factor;
        if(numer>0&&deno<0){
            numer=-numer;
            deno=-deno;
        }
        System.out.println(numer+"/"+deno);
    }
}

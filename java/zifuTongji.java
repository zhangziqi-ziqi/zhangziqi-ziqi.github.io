import java.util.Scanner;
import java.util.Arrays;
public class zifuTongji {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String StrIn;
        char letter;
        int i;
        int[] COUNT = new int[26];//默认初始化为0
        Arrays.fill(COUNT,0);//再赋值一遍比较安心
        StrIn=cin.nextLine();
        for(i=0;i<StrIn.length();i++){
            letter=StrIn.charAt(i);
            if(letter>=97&&letter<=122){
                COUNT[letter-97]++;
            }
        }
        for(i=0;i<26;i++){
            if(COUNT[i]>0){
                letter= (char) (97+i);
                System.out.println(""+letter+':'+COUNT[i]);
            }
        }
        cin.close();
    }
}

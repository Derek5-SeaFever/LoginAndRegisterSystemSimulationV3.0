package loginsystemv3;
import java.util.Scanner;

public class ErgonomicsTest {
    public boolean ergonomicsTest(){
        boolean successOrFailure = false;
        int verificationCode = 1000+(int) (Math.random()*10000);
        System.out.println("请输入以下数字来验证您不是机器："+"\n"+verificationCode);
        Scanner input = new Scanner(System.in);
        int codeOfUser = input.nextInt();
        input.nextLine();
        if(codeOfUser==verificationCode){
            successOrFailure = true;
        }
        return successOrFailure;
    }
}

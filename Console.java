package loginsystemv3;
import java.util.Scanner;

public class Console {
    public  static void main(String[] args){
        System.out.println("欢迎来到 不知道是什么的 专有账号注册系统v3.0：");
        System.out.println("QQ群号：637340739");
        Login login = new Login();
        Register register = new Register();
        Scanner input = new Scanner(System.in);

        A:for(;;) {
            System.out.println("您是否已经拥有一个账号？（选填[“YES”或“NO”]）");
            String ask1 = input.nextLine();
            if (ask1.equals("YES")) {
                for(;;) {
                    boolean a = login.startLoginProgram();
                    if (a) {
                        MainPage.mainPage();
                        break A;
                    }
                }
            } else if (ask1.equals("NO")) {
                boolean b = register.startRegisterProgram();
                if(b){
                    System.out.println("注册完成！赶快登录吧...");
                    System.out.println("登录系统>");
                    for(;;){
                        boolean A = login.startLoginProgram();
                        if(A){
                            MainPage.mainPage();
                            break A;
                        }
                    }
                }
            } else {
                System.out.println("对不起，您输入的命令有误！请根据自身实际情况选填[“YES”或“NO”]作答...");
            }
        }
    }
}

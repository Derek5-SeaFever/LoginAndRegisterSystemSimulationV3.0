import java.util.Scanner;

public class Register {

    public boolean startRegisterProgram(){
        Scanner input = new Scanner(System.in);
        DataBaseConsole dataBaseConsole = new DataBaseConsole();
        String[] nameBox = dataBaseConsole.dataOfNameReader("D:\\SeaFe\\Documents\\Java Program Files\\JavaBasicLearning\\src\\loginsystemv3\\NameData.txt");

        System.out.println("欢迎来到注册系统：");
        System.out.println("Tips:注册的密码必须为5~8位数的纯数字！");

        String tempName;
        judge:for(;;) {
            System.out.println("请输入注册账户名：");
            tempName = input.nextLine();
            for (int i = 0; i < nameBox.length; i++) {
                if (tempName.equals(nameBox[i])) {
                    System.out.println("对不起，您输入的用户名已存在，请重新输入...");
                }else if(!tempName.equals(nameBox[i])&&(i==nameBox.length-1)){
                    break judge;
                }
            }
        }

        int tempPassword;
        for(;;) {
            System.out.println("请输入注册密码：");
            int firstPassword = input.nextInt();
            input.nextLine();
            if(firstPassword<10000||firstPassword>99999999){
                System.out.println("对不起您输入的密码不符合要求，请重新输入...");
                continue;
            }
            System.out.println("请再次输入密码：");
            int verifyPassword = input.nextInt();
            input.nextLine();
            if (firstPassword == verifyPassword) {
                tempPassword = verifyPassword;
                break;
            }else{
                System.out.println("对不起，您两次输入的密码不一致，请重新输入...");
            }
        }

        ErgonomicsTest ergonomicsTest = new ErgonomicsTest();
        for(;;) {
            boolean a = ergonomicsTest.ergonomicsTest();
            if (a) {
                break;
            }else {
                System.out.println("对不起，您输入的验证码不正确，请重新输入...");
            }
        }

        dataBaseConsole.writeInName(tempName);
        dataBaseConsole.writeInPassword(tempPassword);

        return true;
    }

}

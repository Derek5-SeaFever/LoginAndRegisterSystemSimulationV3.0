import java.util.Scanner;

public class Login {
    private boolean successOrFailure = false;

    public boolean startLoginProgram(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String tempName = input.nextLine();
        System.out.println("请输入密码：");
        int tempPassword = input.nextInt();
        input.nextLine();

        DataBaseConsole dataBaseConsole = new DataBaseConsole();
        String[] nameBox = dataBaseConsole.dataOfNameReader("D:\\SeaFe\\Documents\\Java Program Files\\JavaBasicLearning\\src\\loginsystemv3\\NameData.txt");
        int[] passwordBox = dataBaseConsole.dataOfPasswordReader("D:\\SeaFe\\Documents\\Java Program Files\\JavaBasicLearning\\src\\loginsystemv3\\PasswordData.txt");
        for(int i=0;i<nameBox.length;i++){
            if(tempName.equals(nameBox[i])){
                if(tempPassword==passwordBox[i]){
                    System.out.println("登录成功！");
                    successOrFailure = true;
                    break;
                }else{
                    System.out.println("密码错误，请重新登录...");
                }
            }else if(!tempName.equals(nameBox[i])&&(i==nameBox.length-1)){
                System.out.println("对不起，您输入的用户名不存在，请重新输入...");
                break;
            }
        }
        return successOrFailure;
    }
}

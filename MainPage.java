import java.util.Scanner;

public class MainPage {
    public static final void mainPage(){
        System.out.println("欢迎来到主界面>");
        System.out.println("功能："+"\n"+"将一张图片转化成Ascll码");
        System.out.println("请输入需要转化的图片地址：");
        Scanner input = new Scanner(System.in);
        String pathname = input.nextLine();
        ImgByAscII.createAsciiPic(pathname);
    }
}

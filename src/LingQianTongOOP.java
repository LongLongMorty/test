import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LingQianTongOOP {
    boolean loop = true;
    String details = "";
    double money = 0;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E HH-mm-ss");
    double m;
    String s;
    Scanner input = new Scanner(System.in);
    public void MainMenu(){
        do {
            System.out.println("==========零钱通菜单==========");
            System.out.println("请选择您的操作：");
            System.out.println("\t\t1.零钱通明细");
            System.out.println("\t\t2.收入");
            System.out.println("\t\t3.消费");
            System.out.println("\t\t4.退   出");
            int key = input.nextInt();
            switch (key) {
                case 1:
                    ShowDetails();
                    break;
                case 2:
                    Income();
                    break;
                case 3:
                     Consume();
                    break;
                case 4:
                     Quit();
                default:
                    break;
            }
        } while (loop);
    }
    public void ShowDetails(){
        System.out.println("==========零钱明细==========");
        System.out.print(details);
    }
    public void Income(){
        System.out.print("请输入您的收入金额：");
        m = input.nextDouble();
        money += m;
        details += "收入  +" + m + "  " + dateFormat.format(date) + "  余额:" + money + "\n";
    }
    public void Consume(){
        System.out.print("消费明细：");
        s = input.next();
        System.out.print("消费金额：");
        m = input.nextInt();
        while (m > money) {
            System.out.println("输入金额有误！请重新操作！");
            System.out.print("消费明细：");
            s = input.next();
            System.out.print("消费金额：");
            m = input.nextInt();
        }
        money -= m;
        details += s + "  -" + m + "  " + dateFormat.format(date) + "  余额：" + money + "\n";
    }
    public void Quit(){
        while (true) {
            System.out.println("请输入y/n来确定退出！");
            s = input.next();
            if ("y".equals(s) || "n".equals(s)) {
                break;
            }
        }
        if ("y".equals(s)) {
            loop = false;
        }
    }
}

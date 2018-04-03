package 象棋登录;

import Chess.runBoard;
import 战绩榜.Scores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener{
    public static Register register=new Register();
    public static DataBase dataBase=new DataBase();
    public static Music music=new Music();
    public static String winnername;
    public static String user1,user2;
    public static int grade1,grade2;

    JTextField name_in = new JTextField(20);//输入用户名
    JPasswordField passwordField = new JPasswordField(20);//输入用户密码

    public static void main(String[] args) {
        Login login = new Login();
        login.paint();
        music.play();
    }


    public static DataBase getDataBase() {
        return dataBase;
    }

    public static Register getRegister() {
        return register;
    }

    //窗口的大小
    public static final int WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/3;
    public static final int HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height/2;
    //窗口出现的位置
    public static final int X=Toolkit.getDefaultToolkit().getScreenSize().width/4;
    public static final int Y=Toolkit.getDefaultToolkit().getScreenSize().height/4;

    public static int user_num=1;//记录有登陆玩家的人数

    MyPanel panel=new MyPanel();

    public void paint() {
        this.setTitle("登录界面");
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X,Y);
        this.setResizable(false);

        Container container = getContentPane();

        //欢迎登录
        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("宋体", Font.BOLD, 40));
        panel.add(title);
        title.setSize(200,30);
        title.setLocation(WIDTH/2-80,10);


        Font font=new Font("宋体",1,20);

        //记录第几个用户登录
        JLabel user=new JLabel("第"+user_num+"个用户登录");
        user.setFont(font);
        panel.add(user);
        user.setSize(300,30);
        user.setLocation(WIDTH/2-80,80);



        //用户名输入
        JLabel name = new JLabel("用户名：");
        name.setFont(font);
        name.setSize(150,20);
        name.setLocation(WIDTH/5+50,HEIGHT/5+50);
        panel.add(name);

        //用户名输入框
        name_in.setSize(200,20);
        name_in.setLocation(WIDTH/3+50,HEIGHT/5+50);
        panel.add(name_in);


        //密码输入
        JLabel psd = new JLabel("密码：");
        psd.setFont(font);
        psd.setSize(150,20);
        psd.setLocation(WIDTH/5+50,HEIGHT/3+50);
        panel.add(psd);

        //密码输入框
        passwordField.setFont(font);
        passwordField.setSize(200,20);
        passwordField.setLocation(WIDTH/3+50,HEIGHT/3+50);
        panel.add(passwordField);


        /*
         *登录、退出按钮以及重新注册按钮
         */
        JButton login_in_button = new JButton("登录");
        login_in_button.addActionListener(this);
        login_in_button.setActionCommand("login_in_button");
        login_in_button.setFont(font);
        login_in_button.setSize(90,20);
        login_in_button.setLocation(WIDTH/10-10,HEIGHT/2+80);
        panel.add(login_in_button);

        JButton login_out_button = new JButton("退出");
        login_out_button.addActionListener(this);
        login_out_button.setActionCommand("login_out_button");
        login_out_button.setFont(font);
        login_out_button.setSize(90,20);
        login_out_button.setLocation(WIDTH/3,HEIGHT/2+80);
        panel.add(login_out_button);


        JButton register_button = new JButton("注册");
        register_button.addActionListener(this);
        register_button.setActionCommand("register_button");
        register_button.setFont(font);
        register_button.setSize(90,20);
        register_button.setLocation(2*WIDTH/3-80,HEIGHT/2+80);
        panel.add(register_button);

        JButton zhanji=new JButton("排行榜");
        zhanji.addActionListener(this);
        zhanji.setActionCommand("zhanji");
        zhanji.setFont(font);
        zhanji.setLocation(2*WIDTH/3+50,HEIGHT/2+80);
        zhanji.setSize(100,20);
        panel.add(zhanji);

        panel.setLayout(null);
        container.add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getActionCommand();
        if (source == "login_in_button") {
            String name = name_in.getText();
            String psd = new String(passwordField.getPassword());
            System.out.println("姓名： " + name + "密码： " + psd);
            if (name.isEmpty() || psd.isEmpty()) {
                JOptionPane.showMessageDialog(null, "用户名和密码不能为空", "提示信息", JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
            } else {
                if (dataBase.check(name,psd)) {
                    System.out.println("调用登录方法");
                    if(user_num==1){//此时只有一个玩家成功登录
                        winnername=name;
                        user1=name;
                        grade1=dataBase.getGrade(user1);
                        user_num++;
                        this.dispose();
                        new Login().paint();
                    }
                    else if(user_num==2){//此时有两个玩家登陆
                        user2=name;
                        grade2=dataBase.getGrade(user2);
//                        this.setVisible(false);
                        this.dispose();
                        System.out.println("恭喜您，登录成功！祝您游戏愉快！");
                        System.out.println("用户名是：" + name + "\n密码是：" + psd);
                        music.play();
                        new runBoard().show();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入","提示信息",JOptionPane.WARNING_MESSAGE);
                    name_in.setText("");
                    passwordField.setText("");
                }
            }
        } else if (source == "login_out_button") {
            System.out.println("已经成功退出！");
            System.exit(0);
        }
        else if(source=="zhanji"){
            this.dispose();
            new Scores().paint();
        } else {
            System.out.println("调用注册方法");
            System.out.println("欢迎来到注册页面！");
            this.dispose();
            register.paint();
        }
    }
}
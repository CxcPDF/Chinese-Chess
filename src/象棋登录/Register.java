package 象棋登录;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {

    JButton back_button, login_button;//返回按钮和注册按钮
    JTextField name_in;
    JPasswordField password_in, password_check;
    DataBase dataBase= Login.getDataBase();

    String name, password, password_second;
    public static int flag=0;

    //窗口的大小
    public static final int WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/3;
    public static final int HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height/2;
    //窗口出现的位置
    public static final int X=Toolkit.getDefaultToolkit().getScreenSize().width/4;
    public static final int Y=Toolkit.getDefaultToolkit().getScreenSize().height/4;

    MyPanel panel=new MyPanel();
    public void paint(){
        this.setTitle("登录界面");
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X,Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        Container container = getContentPane();

        //标题
        JLabel title = new JLabel("REGISTER");
        title.setFont(new Font("宋体", Font.BOLD, 30));
        panel.add(title);
        title.setSize(200,30);
        title.setLocation(WIDTH/2-80,10);

        Font font=new Font("宋体",1,20);

        //输入用户名
        JLabel name = new JLabel("请输入用户名：");
        name.setFont(font);
        name.setSize(150,20);
        name.setLocation(WIDTH/5,HEIGHT/6);
        panel.add(name);

        name_in = new JTextField(20);
        name_in.setSize(200,20);
        name_in.setLocation(WIDTH/2,HEIGHT/6);
        panel.add(name_in);

        //密码输入
        JLabel psd = new JLabel("请输入密码：");
        psd.setFont(font);
        psd.setSize(200,20);
        psd.setLocation(WIDTH/5,HEIGHT/3);
        panel.add(psd);

        password_in = new JPasswordField(20);
        password_in.setFont(font);
        password_in.setSize(200,20);
        password_in.setLocation(WIDTH/2,HEIGHT/3);
        panel.add(password_in);

        //密码确认
        JLabel psd_check = new JLabel("请再次输入密码：");
        psd_check.setFont(font);
        psd_check.setSize(200,20);
        psd_check.setLocation(WIDTH/5,HEIGHT/2);
        panel.add(psd_check);

        password_check = new JPasswordField(20);
        password_check.setFont(font);
        password_check.setSize(200,20);
        password_check.setLocation(WIDTH/2,HEIGHT/2);
        panel.add(password_check);

        //返回按钮和注册按钮
        login_button = new JButton("注册");
        login_button.addActionListener(this);
        login_button.setActionCommand("login_button");
        login_button.setSize(80,30);
        login_button.setLocation(WIDTH/8+100,2*HEIGHT/3);
        panel.add(login_button);

        back_button = new JButton("返回");
        back_button.addActionListener(this);
        back_button.setActionCommand("back_button");
        back_button.setSize(80,30);
        back_button.setLocation(2*WIDTH/3-50,2*HEIGHT/3);
        panel.add(back_button);

        panel.setLayout(null);
        container.add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getActionCommand();
        if (source == "back_button") {
            System.out.println("返回登录界面");
            this.dispose();
            new Login().paint();
        }
        if (source == "login_button") {
            name = name_in.getText();
            password = new String(password_in.getPassword());
            password_second = new String(password_check.getPassword());
            System.out.println(password + " " + password_second);
            if (password_second.equals(password)) {
                flag=1;//如果有人注册flag就变为1



                if(dataBase==null){
                    dataBase=Login.getDataBase();
                    System.out.println("     404");
                }




                boolean b=dataBase.checkname(name);
                if (b==false) {//如果没有相同的名称就进行储存
                    if(name.equals("")||password.equals("")||password_check.equals("")){
                        JOptionPane.showMessageDialog(null, "请输入完整信息",
                                "提示信息", JOptionPane.WARNING_MESSAGE);
                    }else {
                        dataBase.Store();
                        System.out.println("注册成功：\n姓名是：" + name + " 密码是:" + password);
                        this.dispose();
                        new Login().paint();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "此用户名已经被占用，请重新输入",
                            "提示信息", JOptionPane.WARNING_MESSAGE);
                    name_in.setText("");
                    password_in.setText("");
                    password_check.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "前后两次的密码输入不一致，请重新输入", "提示信息", JOptionPane.WARNING_MESSAGE);
                password_in.setText("");
                password_check.setText("");
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
}


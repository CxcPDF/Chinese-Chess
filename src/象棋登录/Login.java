package �����¼;

import Chess.runBoard;
import ս����.Scores;

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

    JTextField name_in = new JTextField(20);//�����û���
    JPasswordField passwordField = new JPasswordField(20);//�����û�����

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

    //���ڵĴ�С
    public static final int WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/3;
    public static final int HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height/2;
    //���ڳ��ֵ�λ��
    public static final int X=Toolkit.getDefaultToolkit().getScreenSize().width/4;
    public static final int Y=Toolkit.getDefaultToolkit().getScreenSize().height/4;

    public static int user_num=1;//��¼�е�½��ҵ�����

    MyPanel panel=new MyPanel();

    public void paint() {
        this.setTitle("��¼����");
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X,Y);
        this.setResizable(false);

        Container container = getContentPane();

        //��ӭ��¼
        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("����", Font.BOLD, 40));
        panel.add(title);
        title.setSize(200,30);
        title.setLocation(WIDTH/2-80,10);


        Font font=new Font("����",1,20);

        //��¼�ڼ����û���¼
        JLabel user=new JLabel("��"+user_num+"���û���¼");
        user.setFont(font);
        panel.add(user);
        user.setSize(300,30);
        user.setLocation(WIDTH/2-80,80);



        //�û�������
        JLabel name = new JLabel("�û�����");
        name.setFont(font);
        name.setSize(150,20);
        name.setLocation(WIDTH/5+50,HEIGHT/5+50);
        panel.add(name);

        //�û��������
        name_in.setSize(200,20);
        name_in.setLocation(WIDTH/3+50,HEIGHT/5+50);
        panel.add(name_in);


        //��������
        JLabel psd = new JLabel("���룺");
        psd.setFont(font);
        psd.setSize(150,20);
        psd.setLocation(WIDTH/5+50,HEIGHT/3+50);
        panel.add(psd);

        //���������
        passwordField.setFont(font);
        passwordField.setSize(200,20);
        passwordField.setLocation(WIDTH/3+50,HEIGHT/3+50);
        panel.add(passwordField);


        /*
         *��¼���˳���ť�Լ�����ע�ᰴť
         */
        JButton login_in_button = new JButton("��¼");
        login_in_button.addActionListener(this);
        login_in_button.setActionCommand("login_in_button");
        login_in_button.setFont(font);
        login_in_button.setSize(90,20);
        login_in_button.setLocation(WIDTH/10-10,HEIGHT/2+80);
        panel.add(login_in_button);

        JButton login_out_button = new JButton("�˳�");
        login_out_button.addActionListener(this);
        login_out_button.setActionCommand("login_out_button");
        login_out_button.setFont(font);
        login_out_button.setSize(90,20);
        login_out_button.setLocation(WIDTH/3,HEIGHT/2+80);
        panel.add(login_out_button);


        JButton register_button = new JButton("ע��");
        register_button.addActionListener(this);
        register_button.setActionCommand("register_button");
        register_button.setFont(font);
        register_button.setSize(90,20);
        register_button.setLocation(2*WIDTH/3-80,HEIGHT/2+80);
        panel.add(register_button);

        JButton zhanji=new JButton("���а�");
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
            System.out.println("������ " + name + "���룺 " + psd);
            if (name.isEmpty() || psd.isEmpty()) {
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
            } else {
                if (dataBase.check(name,psd)) {
                    System.out.println("���õ�¼����");
                    if(user_num==1){//��ʱֻ��һ����ҳɹ���¼
                        winnername=name;
                        user1=name;
                        grade1=dataBase.getGrade(user1);
                        user_num++;
                        this.dispose();
                        new Login().paint();
                    }
                    else if(user_num==2){//��ʱ��������ҵ�½
                        user2=name;
                        grade2=dataBase.getGrade(user2);
//                        this.setVisible(false);
                        this.dispose();
                        System.out.println("��ϲ������¼�ɹ���ף����Ϸ��죡");
                        System.out.println("�û����ǣ�" + name + "\n�����ǣ�" + psd);
                        music.play();
                        new runBoard().show();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "�û������������������������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                    name_in.setText("");
                    passwordField.setText("");
                }
            }
        } else if (source == "login_out_button") {
            System.out.println("�Ѿ��ɹ��˳���");
            System.exit(0);
        }
        else if(source=="zhanji"){
            this.dispose();
            new Scores().paint();
        } else {
            System.out.println("����ע�᷽��");
            System.out.println("��ӭ����ע��ҳ�棡");
            this.dispose();
            register.paint();
        }
    }
}
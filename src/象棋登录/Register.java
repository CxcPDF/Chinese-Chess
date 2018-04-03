package �����¼;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {

    JButton back_button, login_button;//���ذ�ť��ע�ᰴť
    JTextField name_in;
    JPasswordField password_in, password_check;
    DataBase dataBase= Login.getDataBase();

    String name, password, password_second;
    public static int flag=0;

    //���ڵĴ�С
    public static final int WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/3;
    public static final int HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height/2;
    //���ڳ��ֵ�λ��
    public static final int X=Toolkit.getDefaultToolkit().getScreenSize().width/4;
    public static final int Y=Toolkit.getDefaultToolkit().getScreenSize().height/4;

    MyPanel panel=new MyPanel();
    public void paint(){
        this.setTitle("��¼����");
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X,Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        Container container = getContentPane();

        //����
        JLabel title = new JLabel("REGISTER");
        title.setFont(new Font("����", Font.BOLD, 30));
        panel.add(title);
        title.setSize(200,30);
        title.setLocation(WIDTH/2-80,10);

        Font font=new Font("����",1,20);

        //�����û���
        JLabel name = new JLabel("�������û�����");
        name.setFont(font);
        name.setSize(150,20);
        name.setLocation(WIDTH/5,HEIGHT/6);
        panel.add(name);

        name_in = new JTextField(20);
        name_in.setSize(200,20);
        name_in.setLocation(WIDTH/2,HEIGHT/6);
        panel.add(name_in);

        //��������
        JLabel psd = new JLabel("���������룺");
        psd.setFont(font);
        psd.setSize(200,20);
        psd.setLocation(WIDTH/5,HEIGHT/3);
        panel.add(psd);

        password_in = new JPasswordField(20);
        password_in.setFont(font);
        password_in.setSize(200,20);
        password_in.setLocation(WIDTH/2,HEIGHT/3);
        panel.add(password_in);

        //����ȷ��
        JLabel psd_check = new JLabel("���ٴ��������룺");
        psd_check.setFont(font);
        psd_check.setSize(200,20);
        psd_check.setLocation(WIDTH/5,HEIGHT/2);
        panel.add(psd_check);

        password_check = new JPasswordField(20);
        password_check.setFont(font);
        password_check.setSize(200,20);
        password_check.setLocation(WIDTH/2,HEIGHT/2);
        panel.add(password_check);

        //���ذ�ť��ע�ᰴť
        login_button = new JButton("ע��");
        login_button.addActionListener(this);
        login_button.setActionCommand("login_button");
        login_button.setSize(80,30);
        login_button.setLocation(WIDTH/8+100,2*HEIGHT/3);
        panel.add(login_button);

        back_button = new JButton("����");
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
            System.out.println("���ص�¼����");
            this.dispose();
            new Login().paint();
        }
        if (source == "login_button") {
            name = name_in.getText();
            password = new String(password_in.getPassword());
            password_second = new String(password_check.getPassword());
            System.out.println(password + " " + password_second);
            if (password_second.equals(password)) {
                flag=1;//�������ע��flag�ͱ�Ϊ1



                if(dataBase==null){
                    dataBase=Login.getDataBase();
                    System.out.println("     404");
                }




                boolean b=dataBase.checkname(name);
                if (b==false) {//���û����ͬ�����ƾͽ��д���
                    if(name.equals("")||password.equals("")||password_check.equals("")){
                        JOptionPane.showMessageDialog(null, "������������Ϣ",
                                "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
                    }else {
                        dataBase.Store();
                        System.out.println("ע��ɹ���\n�����ǣ�" + name + " ������:" + password);
                        this.dispose();
                        new Login().paint();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "���û����Ѿ���ռ�ã�����������",
                            "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
                    name_in.setText("");
                    password_in.setText("");
                    password_check.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ǰ�����ε��������벻һ�£�����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
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


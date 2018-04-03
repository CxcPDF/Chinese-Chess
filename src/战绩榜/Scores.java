package ’Ωº®∞Ò;
import œÛ∆Âµ«¬º.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Scores extends JFrame implements ActionListener {
    public static Vector v= œÛ∆Âµ«¬º.DataBase.vector;
    public static final int WIDTH=510;
    public static final int HEIGHT=800;
    background myPanel=new background("src/img/71.jpg");
    Font font=new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,28);



//    public static void main(String[] args){
//        new Scores().paint();
//    }


    public Scores(){
        this.setTitle("’Ωº®∞Ò");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLocation(400,200);

        Container container=this.getContentPane();
        container.add(myPanel);


        myPanel.setOpaque(true);
        myPanel.setLayout(null);
        this.setVisible(true);
    }

    public void paint(){//ªÊ÷∆≈≈––∞Ò
        JLabel title=new JLabel("≈≈––∞Ò");
        title.setSize(200,50);
        title.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.BOLD,45));
        title.setLocation(180,20);
        myPanel.add(title);

//        String[] path={"src/img/first.jpg","src/img/second.jpg","src/img/third.jpg"};
//        for(int i=0;i<3;i++){
//            JLabel img=new JLabel();
//        Icon icon=new ImageIcon(path[i]);
//        img.setIcon(icon);
//        img.setBounds(71,125+i*45,80,45);
//        myPanel.add(img,new Integer(Integer.MIN_VALUE));
//        }


        for(int i=1;i<14;i++){
            JLabel label=new JLabel(String.valueOf(i));
            label.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
            label.setSize(60,30);
            label.setLocation(100, 85 + i * 45);
            myPanel.add(label);
        }

        JLabel paiming=new JLabel("≈≈√˚");
        paiming.setFont(font);
        paiming.setLocation(82,90);
        paiming.setSize(100,35);
        myPanel.add(paiming);

        JLabel name=new JLabel("’À∫≈");
        name.setSize(100,35);
        name.setLocation(210,90);
        name.setFont(font);
        myPanel.add(name);

        JLabel num=new JLabel("◊‹æ÷ ˝");
        num.setFont(font);
        num.setLocation(330,90);
        num.setSize(185,35);
        myPanel.add(num);

//        JLabel rate=new JLabel(" §¬ ");
//        rate.setLocation(450,90);
//        rate.setSize(80,35);
//        rate.setFont(font);
//        myPanel.add(rate);

        for(int i=1;i<=13;i++){
            String str= (String) v.get(i-1);
            String[] tmp=str.split("-");
            System.out.println(tmp[0]);
            JLabel label=new JLabel(tmp[0]);
            label.setFont(font);
            label.setLocation(158, 85 + i * 45);
            label.setSize(200,45);
            myPanel.add(label);

            JLabel label1=new JLabel(tmp[2]);
            label1.setSize(100,45);
            label1.setFont(font);
            label1.setLocation(328,85 + i * 45);
            myPanel.add(label1);
        }

        JButton back_button=new JButton("∑µªÿµ«¬ºΩÁ√Ê");
        back_button.setSize(200,20);
        back_button.setLocation(140,735);
        back_button.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
        back_button.addActionListener(this);
        myPanel.add(back_button);

        myPanel.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new Login().paint();
    }
}

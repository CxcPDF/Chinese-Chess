package ս����;

import javax.swing.*;
import java.awt.*;

public class background extends JPanel{
    String path="src/img/71.jpg";
    Image image=new ImageIcon(path).getImage();

    public background(String path){
        this.path=path;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //���а���panel��ʼ��ʾ�����Ͻǵ�λ��
        int x=100;
        int y=80;
        int end_y=750;
        int[] vLine={-30,50,220,320,400};//ˮƽ������һ��Ŀ��




        g.drawImage(image,0,0,600,800,this);


        //����ֱ��
        for(int i=0;i<4;i++){
                g.drawLine(x + vLine[i], y,x + vLine[i],end_y-40);
        }


        //��ˮƽ��
        for(int i=0;i<15;i++){
            g.drawLine(x-30,y+i*45,x+vLine[3],y+i*45);
        }


    }
}

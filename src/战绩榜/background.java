package 战绩榜;

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

        //排行榜在panel开始显示的左上角的位置
        int x=100;
        int y=80;
        int end_y=750;
        int[] vLine={-30,50,220,320,400};//水平方向上一格的宽度




        g.drawImage(image,0,0,600,800,this);


        //画竖直线
        for(int i=0;i<4;i++){
                g.drawLine(x + vLine[i], y,x + vLine[i],end_y-40);
        }


        //画水平线
        for(int i=0;i<15;i++){
            g.drawLine(x-30,y+i*45,x+vLine[3],y+i*45);
        }


    }
}

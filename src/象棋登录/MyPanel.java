package 象棋登录;
//登录界面背景
import javax.swing.*;
import java.awt.*;


//自定义一个面板类
class MyPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //绘制一张背景图片  2.jpg是图片的路径  自己设定为自己想要添加的图片
        Image image = new ImageIcon("src/img/bg2.jpg").getImage();
        g.drawImage(image,0,0,Login.WIDTH,Login.HEIGHT,this);
    }
}

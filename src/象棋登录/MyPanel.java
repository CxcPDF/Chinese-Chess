package �����¼;
//��¼���汳��
import javax.swing.*;
import java.awt.*;


//�Զ���һ�������
class MyPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //����һ�ű���ͼƬ  2.jpg��ͼƬ��·��  �Լ��趨Ϊ�Լ���Ҫ��ӵ�ͼƬ
        Image image = new ImageIcon("src/img/bg2.jpg").getImage();
        g.drawImage(image,0,0,Login.WIDTH,Login.HEIGHT,this);
    }
}

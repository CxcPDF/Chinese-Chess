package ��ʱ��;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class time extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static int passtime = -1;
    public static int totalTime = 10;
    JLabel timeLabel = new JLabel();
    Font font = new Font("����", 1, 40);

    Timer timer;

    public static void main(String[] args) {

        time test = new time();
        test.time_start();
    }

    public time() {
        this.setTitle("��ʱ��");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 400);

        Container container = this.getContentPane();
        background panel = new background();

        JLabel label = new JLabel("ʣ��ʱ��");
        label.setSize(300, 40);
        label.setFont(font);
        label.setLocation(WIDTH / 2 - 80, HEIGHT / 20);
        panel.add(label);

        timeLabel.setLocation(WIDTH / 2 - 50, HEIGHT / 3);
        timeLabel.setSize(300, 40);
        timeLabel.setFont(font);
        panel.add(timeLabel);

        panel.setLayout(null);
        container.add(panel);
        this.setVisible(true);

    }

    public void time_start() {
        timer = new Timer();
        timer.schedule(new ScheduleRunTask(), 0, 1000);//����ָ���������ָ�����ӳٺ�ʼ�����ظ��Ĺ̶��ӳ�ִ��
    }

    class ScheduleRunTask extends TimerTask {

        @Override
        public void run() {
            passtime++;
            System.out.println("" + passtime);
            timeLabel.setText("" + (totalTime - passtime) + "��");
            if (passtime == totalTime) {
                timer.cancel();
                System.out.println("ֹͣ��ʱ");
            }
        }
    }
}

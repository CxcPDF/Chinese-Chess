package �����¼;

import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

public class Music extends Frame{
    public Music(){}

    public void play(){
        try {
            URL cb;
            File f = new File("D:\\������Ŀ\\src\\music\\��ɽ��ˮ.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.loop();
            //ѭ������
            // aau.play() ����
            // aau.stop()ֹͣ����

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
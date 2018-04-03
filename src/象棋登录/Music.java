package 象棋登录;

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
            File f = new File("D:\\象棋项目\\src\\music\\高山流水.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.loop();
            //循环播放
            // aau.play() 单曲
            // aau.stop()停止播放

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
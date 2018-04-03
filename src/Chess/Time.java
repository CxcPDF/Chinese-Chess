package Chess;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class Time {
	public int passtime=0;
    public int totalTime=30;
    JLabel timeLabel=new JLabel();
    Font font1=new Font("������κ",1,40);
    Font font2 = new Font("������κ", 1, 20);
    Timer timer;
    
    ChineseChessBoard board;
    
    public Time(ChineseChessBoard board)
    {
    	this.board = board;
    	JLabel label=new JLabel("ʣ��ʱ��");
        label.setSize(300,40);
        label.setFont(font1);
        label.setLocation(160,570);
        label.setForeground(Color.BLACK);
        this.board.add(label);
        
        timeLabel.setLocation(230,620);
        timeLabel.setSize(200,20);
        timeLabel.setFont(font2);
        timeLabel.setForeground(Color.BLACK);
        this.board.add(timeLabel);
    }
    
    public void time_start(){
        timer=new Timer();
        timer.schedule(new ScheduleRunTask(this.board),0,1000);//����ָ���������ָ�����ӳٺ�ʼ�����ظ��Ĺ̶��ӳ�ִ��
    }
    
 
    
    class ScheduleRunTask extends TimerTask{
    	public ChineseChessBoard board;
    	
        
        public ScheduleRunTask(ChineseChessBoard board)
        {
        	this.board = board;
        }
        
        @Override
        public void run() {
            passtime++;
            
            timeLabel.setText(""+(totalTime-passtime)+"��");
            if(passtime==totalTime || this.board.ifCancelTime == true){
                timer.cancel();
                this.board.ifCancelTime = false;
                
                if(passtime == totalTime)
                {
                	if(this.board.redMove == true)
                    {
                		this.board.redMove = false;
                		this.board.blackMove = true;
                    }
                	else if(this.board.blackMove == true)
                	{
                		this.board.redMove = true;
                		this.board.blackMove = false;
                	}
                }
                
               
                passtime = 0;
            	totalTime = 30;
            	this.board.changeChance();	
            }
        }
    }
    
    
}



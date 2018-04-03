package Chess;

import java.util.Timer;
import java.util.TimerTask;

public class OperationTime
{
	public int passTime;
	ChessPiece rePiece;
	Timer timer;
    
    ChineseChessBoard board;
    
    public OperationTime(ChineseChessBoard board)
    {
    	passTime = 0;
    	this.board = board;
    	timer=new Timer();
        timer.schedule(new ScheduleRunTask(this.board),0,1500);//安排指定的任务从指定的延迟后开始进行重复的固定延迟执行
    }
    
    class ScheduleRunTask extends TimerTask{
    	public ChineseChessBoard board;
    	
        public ScheduleRunTask(ChineseChessBoard board)
        {
        	this.board = board;
        }
        
        @Override
        public void run() {
        	
            if(passTime != 0)
            {
            	if(this.board.count != 0)
            	{
            		rePiece = this.board.flagPiece[0];
            	
            		point p = rePiece.vector.elementAt(0);
            	
            		this.board.flagPiece[0].vector.removeElementAt(0);
       
            		for(int i = 0; i < this.board.count - 1; i++)
            		{
            			this.board.flagPiece[i] = this.board.flagPiece[i + 1];
            		}
            	
            		this.board.count--;
            	
            		int startX = rePiece.getBounds().x;  
            		int startY = rePiece.getBounds().y;  
            		int sX = startX + rePiece.width / 2;
            		int sY = startY + rePiece.height / 2;
  
            		int startI = 0;
            		int startJ = 0;
                
            		for (int i = 1; i <= this.board.c; i++) {  
            			for (int j = 1; j <= this.board.r; j++) {  
            				int x = this.board.chessPoint[i][j].getX();  
            				int y = this.board.chessPoint[i][j].getY();  
            				if (sX > x - rePiece.width / 2 && sX < x + rePiece.width / 2 && sY > y - rePiece.width / 2 && sY < y + rePiece.width / 2) {  
            					startI = i;  
            					startJ = j;  
            					break;  
            				}  
            			}  
            		} 
            		this.board.chessPoint[startI][startJ].setIsChessPiece(false);
            		rePiece.setLocation(p.x - rePiece.width / 2, p.y - rePiece.height / 2);
            	
            	
            		int endI = 0;
            		int endJ = 0;
            	
            		for (int i = 1; i <= this.board.c; i++) {  
            			for (int j = 1; j <= this.board.r; j++) {  
                         
                            if(p.x == this.board.chessPoint[i][j].x && p.y == this.board.chessPoint[i][j].y)
                            {
                            	endI = i;
                            	endJ = j;
                            	break;
                            }
                         }  
            		} 
            	
            		if(this.board.chessPoint[endI][endJ].isChessPiece == true)
            		{
            			this.board.chessPoint[endI][endJ].reMovePiece(this.board.chessPoint[endI][endJ].piece, this.board);
            			this.board.chessPoint[endI][endJ].setIsChessPiece(false);
            		}
            	
            		this.board.chessPoint[endI][endJ].setIsChessPiece(true);
            		this.board.chessPoint[endI][endJ].piece = this.board.chessPoint[startI][startJ].piece;
            		}
            
            	else if(this.board.count == 0)
            	{
            		timer.cancel();
            	}
            }
            passTime++;
        }
    }
}
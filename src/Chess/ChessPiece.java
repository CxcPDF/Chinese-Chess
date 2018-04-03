package Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
  
public class ChessPiece extends JPanel {
	
	public Image pieceImg;
    String name; 
    Color color;
    ChineseChessBoard board = null;  
    
    public int a, b, d, e;
    
    int width, height;
    ImageIcon image = null;
    Vector<point> vector = new Vector<point>(100000);
  
    public ChessPiece(String name, Color c, int width, int height,  
            ChineseChessBoard board) {
    	
    	this.setOpaque(false);
        this.name = name;  
        this.board = board;  
        this.width = width;  
        this.height = height;  
        if(this.name.equals("��܇"))
        {
        	
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-ju.png");
        }
        
        else if(this.name.equals("���R"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-ma.png");
        }
        
        else if(this.name.equals("��"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-xiang.png");
        }
        
        else if(this.name.equals("��"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-shi.png");
        }
        
        else if(this.name.equals("˧"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-shuai.png");
        }
        
        else if(this.name.equals("����"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-pao.png");
        }
        
        else if(this.name.equals("��"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-bing.png");
        }
        
        else if(this.name.equals("��܇"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-ju.png");
        }
        
        else if(this.name.equals("���R"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-ma.png");
        }
        
        else if(this.name.equals("��"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-xiang.png");
        }
        
        else if(this.name.equals("ʿ"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-shi.png");
        }
        
        else if(this.name.equals("��"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-jiang.png");
        }
        
        else if(this.name.equals("����"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-pao.png");
        }
        
        else if(this.name.equals("��"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-zu.png");
        }
        
        this.color = c;  
        setSize(width, height);  
        addMouseMotionListener((MouseMotionListener) board);  
        addMouseListener((MouseListener) board);  
    }  
  

    public void paint(Graphics g) {  
    	super.paint(g);
    	g.drawImage(pieceImg, 0, 0, this.width, this.height, this);
    }  
  
    public int getWidth() {  
        return width;  
    }  
  
    public int getHeight() {  
        return height;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public Color getColor() {  
        return color;  
    }  
  
    public void setColor(Color c) {  
        color = c;  
    }  
  
    public Color colorOfChessPiece() {  
        return color;  
    }  
}  
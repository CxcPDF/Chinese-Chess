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
        if(this.name.equals("ºìÜ‡"))
        {
        	
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-ju.png");
        }
        
        else if(this.name.equals("ºìñR"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-ma.png");
        }
        
        else if(this.name.equals("Ïà"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-xiang.png");
        }
        
        else if(this.name.equals("ÊË"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-shi.png");
        }
        
        else if(this.name.equals("Ë§"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-shuai.png");
        }
        
        else if(this.name.equals("ºìÅÚ"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-pao.png");
        }
        
        else if(this.name.equals("±ø"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/red-bing.png");
        }
        
        else if(this.name.equals("ºÚÜ‡"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-ju.png");
        }
        
        else if(this.name.equals("ºÚñR"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-ma.png");
        }
        
        else if(this.name.equals("Ïó"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-xiang.png");
        }
        
        else if(this.name.equals("Ê¿"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-shi.png");
        }
        
        else if(this.name.equals("½«"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-jiang.png");
        }
        
        else if(this.name.equals("ºÚÅÚ"))
        {
        	pieceImg = Toolkit.getDefaultToolkit().getImage("src/img/black-pao.png");
        }
        
        else if(this.name.equals("×ä"))
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
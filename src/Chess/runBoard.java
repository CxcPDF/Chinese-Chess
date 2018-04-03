package Chess;

import 象棋登录.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class runBoard extends JFrame implements ActionListener{

	public static runBoard run;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;
	JMenuBar menuBar;
	JMenu menu;
	ChineseChessBoard board;
	
	
	public runBoard() 
	{
		setSize(1366, 730);

	    setTitle("中国象棋");
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);

		Login.music.play();
	    
	    menuBar = new JMenuBar();
		this.setJMenuBar(menuBar); 
		menu = new JMenu("选项");
		menuBar.add(menu);
		menuItem1 = new JMenuItem("悔棋");
		menu.add(menuItem1);
		menuItem1.addActionListener(this);
		menuItem2 = new JMenuItem("重新开始");
		menu.add(menuItem2);
		menuItem2.addActionListener(this);
		menuItem3 = new JMenuItem("战局回放");
		menu.add(menuItem3);
		menuItem3.addActionListener(this);
	    
	    Container contentPane = getContentPane();
	 
	    board = new ChineseChessBoard(50, 50 , 9, 10, getGraphics());
	    contentPane.add(board);

	}
	
	
	
	public void actionPerformed(ActionEvent evt){
		
		
		
		if(evt.getSource() == menuItem1)
		{
			Undo.operation(board, board.flagPiece[board.count - 1], board.flagBeEated, board.chessPoint, board.startI, board.startJ, board.endI, board.endJ);
			
			this.board.ifCancelTime = true;
		}
		else if(evt.getSource() == menuItem2)
		{
			this.board.ifCancelTime = true;
			board.reStart();
		}
		else if(evt.getSource() == menuItem3)
		{
			board.redMove = false;
			board.blackMove = false;
			board.rw.setVisible(false);
			board.bw.setVisible(false);
			board.redPiece.setVisible(true);
			board.blackPiece.setVisible(true);
			
			
			for(int i = 1; i <= board.c; i++)
			{
				for(int j = 1; j <= board.r; j++)
					board.chessPoint[i][j].isChessPiece = false;
			}
			
			
			board.chessPoint[1][10].setPiece(board.pieceRJL, board);  
			board.pieceRJL.setBounds(board.chessPoint[1][10].x - board.w / 2 + 2, board.chessPoint[1][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRJL.setVisible(true);
			board.pieceRJL.vector.removeElementAt(0);
	        
			board.chessPoint[2][10].setPiece(board.pieceRML, board);  
			board.pieceRML.setBounds(board.chessPoint[2][10].x - board.w / 2 + 2, board.chessPoint[2][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRML.setVisible(true);
			board.pieceRML.vector.removeElementAt(0);
	        
			board.chessPoint[3][10].setPiece(board.pieceRXL, board); 
			board.pieceRXL.setBounds(board.chessPoint[3][10].x - board.w / 2 + 2, board.chessPoint[3][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRXL.setVisible(true);
			board.pieceRXL.vector.removeElementAt(0);
	        
			board.chessPoint[4][10].setPiece(board.pieceRSL, board);  
			board.pieceRSL.setBounds(board.chessPoint[4][10].x - board.w / 2 + 2, board.chessPoint[4][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRSL.setVisible(true);
			board.pieceRSL.vector.removeElementAt(0);;
	        
			board.chessPoint[5][10].setPiece(board.pieceRS, board);  
			board.pieceRS.setBounds(board.chessPoint[5][10].x - board.w / 2 + 2, board.chessPoint[5][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRS.setVisible(true);
			board.pieceRS.vector.removeElementAt(0);
	        
			board.chessPoint[6][10].setPiece(board.pieceRSR, board);  
			board.pieceRSR.setBounds(board.chessPoint[6][10].x - board.w / 2 + 2, board.chessPoint[6][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRSR.setVisible(true);
			board.pieceRSR.vector.removeElementAt(0);
	        
			board.chessPoint[7][10].setPiece(board.pieceRXR, board);  
			board.pieceRXR.setBounds(board.chessPoint[7][10].x - board.w / 2 + 2, board.chessPoint[7][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRXR.setVisible(true);
			board.pieceRXR.vector.removeElementAt(0);
	        
			board.chessPoint[8][10].setPiece(board.pieceRMR, board);
			board.pieceRMR.setBounds(board.chessPoint[8][10].x - board.w / 2 + 2, board.chessPoint[8][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRMR.setVisible(true);
			board.pieceRMR.vector.removeElementAt(0);
	        
			board.chessPoint[9][10].setPiece(board.pieceRJR, board);  
			board.pieceRJR.setBounds(board.chessPoint[9][10].x - board.w / 2 + 2, board.chessPoint[9][10].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRJR.setVisible(true);
			board.pieceRJR.vector.removeElementAt(0);
	        
			board.chessPoint[2][8].setPiece(board.pieceRPL, board);
			board.pieceRPL.setBounds(board.chessPoint[2][8].x - board.w / 2 + 2, board.chessPoint[2][8].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRPL.setVisible(true);
			board.pieceRPL.vector.removeElementAt(0);
	        
			board.chessPoint[8][8].setPiece(board.pieceRPR, board);  
			board.pieceRPR.setBounds(board.chessPoint[8][8].x - board.w / 2 + 2, board.chessPoint[8][8].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRPR.setVisible(true);
			board.pieceRPR.vector.removeElementAt(0);
	        
			board.chessPoint[1][7].setPiece(board.pieceRB1, board);  
			board.pieceRB1.setBounds(board.chessPoint[1][7].x - board.w / 2 + 2, board.chessPoint[1][7].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRB1.setVisible(true);
			board.pieceRB1.vector.removeElementAt(0);
	        
			board.chessPoint[3][7].setPiece(board.pieceRB2, board);  
			board.pieceRB2.setBounds(board.chessPoint[3][7].x - board.w / 2 + 2, board.chessPoint[3][7].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRB2.setVisible(true);
			board.pieceRB2.vector.removeElementAt(0);
	        
			board.chessPoint[5][7].setPiece(board.pieceRB3, board); 
			board.pieceRB3.setBounds(board.chessPoint[5][7].x - board.w / 2 + 2, board.chessPoint[5][7].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRB3.setVisible(true);
			board.pieceRB3.vector.removeElementAt(0);
	        
			board.chessPoint[7][7].setPiece(board.pieceRB4, board); 
			board.pieceRB4.setBounds(board.chessPoint[7][7].x - board.w / 2 + 2, board.chessPoint[7][7].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRB4.setVisible(true);
			board.pieceRB4.vector.removeElementAt(0);
	        
			board.chessPoint[9][7].setPiece(board.pieceRB5, board);
			board.pieceRB5.setBounds(board.chessPoint[9][7].x - board.w / 2 + 2, board.chessPoint[9][7].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceRB5.setVisible(true);
			board.pieceRB5.vector.removeElementAt(0);
	  
			board.chessPoint[1][1].setPiece(board.pieceBJL, board); 
			board.pieceBJL.setBounds(board.chessPoint[1][1].x - board.w / 2 + 2, board.chessPoint[1][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBJL.setVisible(true);
			board.pieceBJL.vector.removeElementAt(0);
	        
			board.chessPoint[2][1].setPiece(board.pieceBML, board);
			board.pieceBML.setBounds(board.chessPoint[2][1].x - board.w / 2 + 2, board.chessPoint[2][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBML.setVisible(true);
			board.pieceBML.vector.removeElementAt(0);
	        
			board.chessPoint[3][1].setPiece(board.pieceBXL, board);  
			board.pieceBXL.setBounds(board.chessPoint[3][1].x - board.w / 2 + 2, board.chessPoint[3][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBXL.setVisible(true);
			board.pieceBXL.vector.removeElementAt(0);
	        
			board.chessPoint[4][1].setPiece(board.pieceBSL, board);  
			board.pieceBSL.setBounds(board.chessPoint[4][1].x - board.w / 2 + 2, board.chessPoint[4][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBSL.setVisible(true);
			board.pieceBSL.vector.removeElementAt(0);
	        
			board.chessPoint[5][1].setPiece(board.pieceBJ, board);  
			board.pieceBJ.setBounds(board.chessPoint[5][1].x - board.w / 2 + 2, board.chessPoint[5][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBJ.setVisible(true);
			board.pieceBJ.vector.removeElementAt(0);
	        
			board.chessPoint[6][1].setPiece(board.pieceBSR, board);  
			board.pieceBSR.setBounds(board.chessPoint[6][1].x - board.w / 2 + 2, board.chessPoint[6][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBSR.setVisible(true);
			board.pieceBSR.vector.removeElementAt(0);
	        
			board.chessPoint[7][1].setPiece(board.pieceBXR, board);  
			board.pieceBXR.setBounds(board.chessPoint[7][1].x - board.w / 2 + 2, board.chessPoint[7][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBXR.setVisible(true);
			board.pieceBXR.vector.removeElementAt(0);
	        
			board.chessPoint[8][1].setPiece(board.pieceBMR, board);
			board.pieceBMR.setBounds(board.chessPoint[8][1].x - board.w / 2 + 2, board.chessPoint[8][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBMR.setVisible(true);
			board.pieceBMR.vector.removeElementAt(0);
	        
			board.chessPoint[9][1].setPiece(board.pieceBJR, board); 
			board.pieceBJR.setBounds(board.chessPoint[9][1].x - board.w / 2 + 2, board.chessPoint[9][1].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBJR.setVisible(true);
			board.pieceBJR.vector.removeElementAt(0);
	        
			board.chessPoint[2][3].setPiece(board.pieceBPL, board);
			board.pieceBPL.setBounds(board.chessPoint[2][3].x - board.w / 2 + 2, board.chessPoint[2][3].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBPL.setVisible(true);
			board.pieceBPL.vector.removeElementAt(0);
	        
			board.chessPoint[8][3].setPiece(board.pieceBPR, board);
			board.pieceBPR.setBounds(board.chessPoint[8][3].x - board.w / 2 + 2, board.chessPoint[8][3].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBPR.setVisible(true);
			board.pieceBPR.vector.removeElementAt(0);
	        
			board.chessPoint[1][4].setPiece(board.pieceBZ1, board);  
			board.pieceBZ1.setBounds(board.chessPoint[1][4].x - board.w / 2 + 2, board.chessPoint[1][4].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBZ1.setVisible(true);
			board.pieceBZ1.vector.removeElementAt(0);
	        
			board.chessPoint[3][4].setPiece(board.pieceBZ2, board);  
			board.pieceBZ2.setBounds(board.chessPoint[3][4].x - board.w / 2 + 2, board.chessPoint[3][4].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBZ2.setVisible(true);
			board.pieceBZ2.vector.removeElementAt(0);
	        
			board.chessPoint[5][4].setPiece(board.pieceBZ3, board); 
			board.pieceBZ3.setBounds(board.chessPoint[5][4].x - board.w / 2 + 2, board.chessPoint[5][4].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBZ3.setVisible(true);
			board.pieceBZ3.vector.removeElementAt(0);
	        
			board.chessPoint[7][4].setPiece(board.pieceBZ4, board);
			board.pieceBZ4.setBounds(board.chessPoint[7][4].x - board.w / 2 + 2, board.chessPoint[7][4].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBZ4.setVisible(true);
			board.pieceBZ4.vector.removeElementAt(0);
	        
			board.chessPoint[9][4].setPiece(board.pieceBZ5, board);
			board.pieceBZ5.setBounds(board.chessPoint[9][4].x - board.w / 2 + 2, board.chessPoint[9][4].y - board.h / 2, board.w, board.h);// 棋子位置，宽度，高度  
			board.pieceBZ5.setVisible(true);
			board.pieceBZ5.vector.removeElementAt(0);
			
			this.board.t = new OperationTime(this.board);
		}
			
	}
	
//    public static void main(String[] args) {
//    	run = new runBoard();
//    	run.show();
//	}

//	public void start(){
//		run=new runBoard();
//		run.show();
//
//	}
}
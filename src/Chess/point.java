package Chess;

public class point {
	public int x, y;  
    public boolean isChessPiece;  
    ChessPiece piece = null;  
    ChineseChessBoard board = null;  
  
    public point(int x, int y, boolean b) {  
        this.x = x;  
        this.y = y;  
        isChessPiece = b;  
    }  
  
    public boolean isPiece() {  
        return isChessPiece;  
    }  
  
    public void setIsChessPiece(boolean b) {  
        isChessPiece = b;  
    }  
  
    public int getX() {  
        return x;  
    }  
  
    public int getY() {  
        return y;  
    }  
   
    public void setPiece(ChessPiece piece, ChineseChessBoard board) {  
    	
        this.board = board;  
        this.piece = piece;  
        
        this.board.add(this.piece);  
        
        isChessPiece = true;  
        this.board.validate(); 
    }  
  
    public ChessPiece getPiece() {  
        return piece;  
    }  
  
    public void reMovePiece(ChessPiece piece, ChineseChessBoard board) {  
        this.board = board;  
        this.piece = piece;  
        board.remove(piece);  
        board.validate();  
        isChessPiece = false;  
    }  
}

package Chess;

import java.awt.*;

public class Undo {
	public static void operation(ChineseChessBoard board, ChessPiece flag, ChessPiece flagBeEated, point ChessPoint[][], int startI, int startJ, int endI, int endJ)
	{
		int size = flag.vector.size();
		flag.vector.remove(size - 1);
		size--;
		
		point p = (point)flag.vector.elementAt(size - 1);
		
		
		flag.setLocation(p.x - flag.width / 2, p.y - flag.height / 2);
		ChessPoint[startI][startJ].setIsChessPiece(true);
		ChessPoint[startI][startJ].piece = flag;
		board.count--;
		
		if(flag.color == Color.red)
		{
			board.redMove = true;
			board.blackMove = false;
		}
		else if(flag.color == Color.black)
		{
			board.redMove = false;
			board.blackMove = true;
		}
		
		if(board.ifEat == true)
		{
			int s = board.beEated[board.cnt - 1].vector.size(); 
			board.add(flagBeEated);
			flagBeEated.setLocation(board.beEated[board.cnt - 1].vector.elementAt(s - 1).x - flagBeEated.width / 2, 
					board.beEated[board.cnt - 1].vector.elementAt(s - 1).y - flagBeEated.height / 2);
			board.cnt--;
			ChessPoint[endI][endJ].setIsChessPiece(true);
			ChessPoint[endI][endJ].piece = flagBeEated;
		}
		else
		{
			ChessPoint[endI][endJ].setIsChessPiece(false);
		}
	}
}

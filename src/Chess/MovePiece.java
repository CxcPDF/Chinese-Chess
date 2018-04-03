package Chess;

import ÏóÆåµÇÂ¼.DataBase;

import java.awt.*;

public class MovePiece {
    ChineseChessBoard board = null;
    ChessPiece piece = null;
    point chessPoint[][];
    int startI, startJ, endI, endJ;

    public MovePiece(ChineseChessBoard board, point chessPoint[][]) {
        this.board = board;
        this.chessPoint = chessPoint;
    }

    public void isWine(ChessPiece piece) {
        this.piece = piece;
        if (piece.getName() == "½«" || piece.getName() == "Ë§") {
            if (piece.color == Color.red) {

                this.board.redMove = false;
                this.board.blackMove = false;
                this.board.redPiece.setVisible(false);
                this.board.blackPiece.setVisible(false);

                this.board.ifBlackWin = true;
                this.board.addWinPanel();
                this.board.blackWin++;
                new DataBase().update(ChineseChessBoard.name1);
            } else {
                this.board.redMove = false;
                this.board.blackMove = false;
                this.board.redPiece.setVisible(false);
                this.board.blackPiece.setVisible(false);

                this.board.ifRedWin = true;
                this.board.addWinPanel();
                this.board.redWin++;
                new DataBase().update(ChineseChessBoard.name2);
            }
        }
    }

    public boolean movePieceRule(ChessPiece piece, int startI, int startJ,
                                 int endI, int endJ) {
        this.piece = piece;
        this.startI = startI;
        this.startJ = startJ;
        this.endI = endI;
        this.endJ = endJ;
        int minI = Math.min(startI, endI);
        int maxI = Math.max(startI, endI);
        int minJ = Math.min(startJ, endJ);
        int maxJ = Math.max(startJ, endJ);
        boolean canMove = false;
        if (piece.getName().equals("ºÚÜ‡")) {
            if (this.board.blackMove == false)
                canMove = false;

            else {
                if (startI == endI) {
                    int j = 0;
                    for (j = minJ + 1; j <= maxJ - 1; j++) {
                        if (chessPoint[startI][j].isPiece()) {
                            canMove = false;
                            break;
                        }
                    }
                    if (j == maxJ) {
                        canMove = true;
                    }
                } else if (startJ == endJ) {
                    int i = 0;
                    for (i = minI + 1; i <= maxI - 1; i++) {
                        if (chessPoint[i][startJ].isPiece()) {
                            canMove = false;
                            break;
                        }
                    }
                    if (i == maxI) {
                        canMove = true;
                    }
                } else {
                    canMove = false;
                }
            }

        } else if (piece.getName().equals("ºìÜ‡")) {
            if (this.board.redMove == false)
                canMove = false;

            else {
                if (startI == endI) {
                    int j = 0;
                    for (j = minJ + 1; j <= maxJ - 1; j++) {
                        if (chessPoint[startI][j].isPiece()) {
                            canMove = false;
                            break;
                        }
                    }
                    if (j == maxJ) {
                        canMove = true;
                    }
                } else if (startJ == endJ) {
                    int i = 0;
                    for (i = minI + 1; i <= maxI - 1; i++) {
                        if (chessPoint[i][startJ].isPiece()) {
                            canMove = false;
                            break;
                        }
                    }
                    if (i == maxI) {
                        canMove = true;
                    }
                } else {
                    canMove = false;
                }
            }

        } else if (piece.getName().equals("ºÚñR")) {
            if (this.board.blackMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);

                if (xAxle == 2 && yAxle == 1) {
                    if (endI > startI) {
                        if (chessPoint[startI + 1][startJ].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }
                    if (endI < startI) {
                        if (chessPoint[startI - 1][startJ].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }

                } else if (xAxle == 1 && yAxle == 2) {
                    if (endJ > startJ) {
                        if (chessPoint[startI][startJ + 1].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }
                    if (endJ < startJ) {
                        if (chessPoint[startI][startJ - 1].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }

                } else {
                    canMove = false;
                }
            }
        } else if (piece.getName().equals("ºìñR")) {
            if (this.board.redMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);

                if (xAxle == 2 && yAxle == 1) {
                    if (endI > startI) {
                        if (chessPoint[startI + 1][startJ].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }
                    if (endI < startI) {
                        if (chessPoint[startI - 1][startJ].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }

                } else if (xAxle == 1 && yAxle == 2) {
                    if (endJ > startJ) {
                        if (chessPoint[startI][startJ + 1].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }
                    if (endJ < startJ) {
                        if (chessPoint[startI][startJ - 1].isPiece()) {
                            canMove = false;
                        } else {
                            canMove = true;
                        }
                    }

                } else {
                    canMove = false;
                }
            }
        } else if (piece.getName().equals("Ïó")) {
            if (this.board.blackMove == false)
                canMove = false;

            else {
                int centerI = (startI + endI) / 2;
                int centerJ = (startJ + endJ) / 2;
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);
                if (xAxle == 2 && yAxle == 2 && endJ <= 5) {
                    if (chessPoint[centerI][centerJ].isPiece()) {
                        canMove = false;
                    } else {
                        canMove = true;
                    }
                } else {
                    canMove = false;
                }
            }
        } else if (piece.getName().equals("Ïà")) {
            if (this.board.redMove == false)
                canMove = false;

            else {
                int centerI = (startI + endI) / 2;
                int centerJ = (startJ + endJ) / 2;
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);
                if (xAxle == 2 && yAxle == 2 && endJ >= 6) {
                    if (chessPoint[centerI][centerJ].isPiece()) {
                        canMove = false;
                    } else {
                        canMove = true;
                    }
                } else {
                    canMove = false;
                }
            }
        } else if (piece.getName().equals("ºìÅÚ") || piece.getName().equals("ºÚÅÚ")) {
            if (piece.getName().equals("ºìÅÚ") && this.board.redMove == false)
                canMove = false;
            else if (piece.getName().equals("ºÚÅÚ") && this.board.blackMove == false)
                canMove = false;

            else {
                int number = 0;
                if (startI == endI) {
                    int j = 0;
                    for (j = minJ + 1; j <= maxJ - 1; j++) {
                        if (chessPoint[startI][j].isPiece()) {
                            number++;
                        }
                    }
                    if (number > 1) {
                        canMove = false;
                    } else if (number == 1) {
                        if (chessPoint[endI][endJ].isPiece()) {
                            canMove = true;
                        }
                    } else if (number == 0 && !chessPoint[endI][endJ].isPiece()) {
                        canMove = true;
                    }
                } else if (startJ == endJ) {
                    int i = 0;
                    for (i = minI + 1; i <= maxI - 1; i++) {
                        if (chessPoint[i][startJ].isPiece()) {
                            number++;
                        }
                    }
                    if (number > 1) {
                        canMove = false;
                    } else if (number == 1) {
                        if (chessPoint[endI][endJ].isPiece()) {
                            canMove = true;
                        }
                    } else if (number == 0 && !chessPoint[endI][endJ].isPiece()) {
                        canMove = true;
                    }
                } else {
                    canMove = false;
                }
            }
        } else if (piece.getName().equals("±ø")) {
            if (this.board.redMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);

                if (endJ >= 6) {

                    if (startJ - endJ == 1 && xAxle == 0) {
                        canMove = true;
                    } else {
                        canMove = false;
                    }
                } else if (endJ <= 5) {
                    if ((startJ - endJ == 1) && (xAxle == 0)) {
                        canMove = true;
                    } else if ((endJ - startJ == 0) && (xAxle == 1)) {
                        canMove = true;
                    } else {
                        canMove = false;
                    }
                }
            }
        } else if (piece.getName().equals("×ä")) {
            if (this.board.blackMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);

                if (endJ <= 5) {
                    if (endJ - startJ == 1 && xAxle == 0) {
                        canMove = true;
                    } else {
                        canMove = false;
                    }
                } else if (endJ >= 6) {
                    if ((endJ - startJ == 1) && (xAxle == 0)) {
                        canMove = true;
                    } else if ((endJ - startJ == 0) && (xAxle == 1)) {
                        canMove = true;
                    } else {
                        canMove = false;
                    }
                }
            }
        } else if (piece.getName().equals("Ê¿")) {
            if (this.board.blackMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);
                if (endI <= 6 && endI >= 4 && xAxle == 1 && yAxle == 1) {
                    canMove = true;
                } else {
                    canMove = false;
                }
            }
        } else if (piece.getName().equals("ÊË")) {
            if (this.board.redMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);
                int yAxle = Math.abs(startJ - endJ);
                if (endI <= 6 && endI >= 4 && xAxle == 1 && yAxle == 1) {
                    canMove = true;
                } else {
                    canMove = false;
                }
            }
        } else if ((piece.getName().equals("Ë§"))
                || (piece.getName().equals("½«"))) {
            if (piece.getName().equals("Ë§") && this.board.redMove == false)
                canMove = false;
            else if (piece.getName().equals("½«") && this.board.blackMove == false)
                canMove = false;

            else {
                int xAxle = Math.abs(startI - endI);

                int yAxle = Math.abs(startJ - endJ);
                if (endI <= 6 && endI >= 4) {
                    if ((xAxle == 1 && yAxle == 0) || (xAxle == 0 && yAxle == 1)) {
                        canMove = true;
                    } else if (xAxle == 0) {
                        if (startJ < endJ) {
                            int j;
                            for (j = startJ + 1; j < endJ; j++) {
                                if (this.board.chessPoint[startI][j].isPiece() == true)
                                    break;
                            }

                            if (j == endJ && (this.board.chessPoint[startI][j].piece.getName().equals("Ë§") ||
                                    this.board.chessPoint[startI][j].piece.getName().equals("½«")))
                                canMove = true;

                        } else {
                            int j;
                            for (j = endJ + 1; j < startJ; j++) {
                                if (this.board.chessPoint[startI][j].isPiece() == true)
                                    break;
                            }

                            if (j == startJ && (this.board.chessPoint[startI][j].piece.getName().equals("Ë§") ||
                                    this.board.chessPoint[startI][j].piece.getName().equals("½«")))
                                canMove = true;
                        }
                    } else {
                        canMove = false;
                    }
                } else {
                    canMove = false;
                }
            }

        }

        return canMove;
    }
}

package Chess;

import 象棋登录.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class ChineseChessBoard extends JPanel implements MouseListener,
        MouseMotionListener {
    public ChessPiece[] flagPiece = new ChessPiece[10000];
    public int count = 0;
    public point flagPoint;
    public ChessPiece flagBeEated;
    public ChessPiece[] beEated = new ChessPiece[32];
    public point[] eated = new point[32];
    public int cnt = 0;
    public boolean ifEat = false;
    public boolean ifCancelTime = false;
    public boolean ifRedWin = false;
    public boolean ifBlackWin = false;
    public int totalGames = 0;
    public int redWin = 0;
    public int blackWin = 0;
    public redWinPanel rw = new redWinPanel();
    public blackWinPanel bw = new blackWinPanel();

    //用户姓名与场数
    public static String name1 = Login.user1;
    public static String name2 = Login.user2;
    public static int count1 = Login.grade1;
    public static int count2 = Login.grade2;

    public JLabel redPiece;
    public JLabel blackPiece;

    int w, h;// 宽和高，用像素为单位。
    int c, r;// //列和行，列的线条和行的线条数用正整数表示。

    public int unitWidth, unitHeight;
    public boolean move = false;

    public Image Img;
    public Image frameImg;
    public Image image1;
    public Image image2;
    public Image image0;

    public int x, y;
    public int startX, startY;
    public int startI, startJ;
    public int endI, endJ;
    public boolean redMove = true, blackMove = false;
    MovePiece moveRule = null;
    Time time;
    OperationTime t;


    public point chessPoint[][];


    public ChessPiece pieceRJL;
    public ChessPiece pieceRML;
    public ChessPiece pieceRXL;
    public ChessPiece pieceRSL;
    public ChessPiece pieceRS;
    public ChessPiece pieceRSR;
    public ChessPiece pieceRXR;
    public ChessPiece pieceRMR;
    public ChessPiece pieceRJR;
    public ChessPiece pieceRPL;
    public ChessPiece pieceRPR;
    public ChessPiece pieceRB1;
    public ChessPiece pieceRB2;
    public ChessPiece pieceRB3;
    public ChessPiece pieceRB4;
    public ChessPiece pieceRB5;

    public ChessPiece pieceBJL;
    public ChessPiece pieceBML;
    public ChessPiece pieceBXL;
    public ChessPiece pieceBSL;
    public ChessPiece pieceBJ;
    public ChessPiece pieceBSR;
    public ChessPiece pieceBXR;
    public ChessPiece pieceBMR;
    public ChessPiece pieceBJR;
    public ChessPiece pieceBPL;
    public ChessPiece pieceBPR;
    public ChessPiece pieceBZ1;
    public ChessPiece pieceBZ2;
    public ChessPiece pieceBZ3;
    public ChessPiece pieceBZ4;
    public ChessPiece pieceBZ5;
    Font font = new Font("华文新魏", 1, 30);


    public ChineseChessBoard(int w, int h, int c, int r, Graphics g) {// 有宽、高、列和行的构造函数
        this.setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.validate();

        redPiece = new JLabel("红方执棋");
        redPiece.setSize(280, 60);
        redPiece.setFont(font);
        redPiece.setLocation(520, 390);
        redPiece.setForeground(Color.red);
        this.add(redPiece);
        redPiece.setVisible(false);

        blackPiece = new JLabel("黑方执棋");
        blackPiece.setSize(280, 60);
        blackPiece.setFont(font);
        blackPiece.setLocation(520, 90);
        blackPiece.setForeground(Color.black);
        this.add(blackPiece);
        blackPiece.setVisible(false);

        time = new Time(this);

        unitWidth = w;
        unitHeight = h;

        this.w = w;
        this.h = h;
        this.c = c;
        this.r = r;

        chessPoint = new point[c + 1][r + 1];
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= r; j++) {
                chessPoint[i][j] = new point(i * unitWidth, j * unitHeight,
                        false);
            }
        }

        Img = Toolkit.getDefaultToolkit().getImage("src/img/chessboardafter.png");
        frameImg = Toolkit.getDefaultToolkit().getImage("src/img/background.png");
        //------------------------------------------------------------
        //获取用户显示panel背景图
        String path0 = "src/img/HeadPictures/a1.jpg";
        image0 = Toolkit.getDefaultToolkit().getImage(path0);

        //获取头像图像1
        int x1 = (int) (Math.random() * 11);
        String path1 = "src/img/HeadPictures/" + x1 + ".jpg";
        //System.out.println(path1);
        image1 = Toolkit.getDefaultToolkit().getImage(path1);
        // this.setOpaque(false);
        //获取头像图像2
        int x2 = (int) (Math.random() * 11);
        while (x1 == x2) ;
        {
            x2 = (int) (Math.random() * 11);
        }
        String path2 = "src/img/HeadPictures/" + x2 + ".jpg";
        //System.out.println(path2);
        image2 = Toolkit.getDefaultToolkit().getImage(path2);
        //  this.setOpaque(false);
//---------------------------------------------------------------		


        unitWidth = w;
        unitHeight = h;


        pieceRJL = new ChessPiece("红車", Color.red, w, h, this);
        pieceRML = new ChessPiece("红馬", Color.red, w, h, this);
        pieceRXL = new ChessPiece("相", Color.red, w, h, this);
        pieceRSL = new ChessPiece("仕", Color.red, w, h, this);
        pieceRS = new ChessPiece("帅", Color.red, w, h, this);
        pieceRSR = new ChessPiece("仕", Color.red, w, h, this);
        pieceRXR = new ChessPiece("相", Color.red, w, h, this);
        pieceRMR = new ChessPiece("红馬", Color.red, w, h, this);
        pieceRJR = new ChessPiece("红車", Color.red, w, h, this);
        pieceRPL = new ChessPiece("红炮", Color.red, w, h, this);
        pieceRPR = new ChessPiece("红炮", Color.red, w, h, this);
        pieceRB1 = new ChessPiece("兵", Color.red, w, h, this);
        pieceRB2 = new ChessPiece("兵", Color.red, w, h, this);
        pieceRB3 = new ChessPiece("兵", Color.red, w, h, this);
        pieceRB4 = new ChessPiece("兵", Color.red, w, h, this);
        pieceRB5 = new ChessPiece("兵", Color.red, w, h, this);

        pieceBJL = new ChessPiece("黑車", Color.black, w, h, this);
        pieceBML = new ChessPiece("黑馬", Color.black, w, h, this);
        pieceBXL = new ChessPiece("象", Color.black, w, h, this);
        pieceBSL = new ChessPiece("士", Color.black, w, h, this);
        pieceBJ = new ChessPiece("将", Color.black, w, h, this);
        pieceBSR = new ChessPiece("士", Color.black, w, h, this);
        pieceBXR = new ChessPiece("象", Color.black, w, h, this);
        pieceBMR = new ChessPiece("黑馬", Color.black, w, h, this);
        pieceBJR = new ChessPiece("黑車", Color.black, w, h, this);
        pieceBPL = new ChessPiece("黑炮", Color.black, w, h, this);
        pieceBPR = new ChessPiece("黑炮", Color.black, w, h, this);
        pieceBZ1 = new ChessPiece("卒", Color.black, w, h, this);
        pieceBZ2 = new ChessPiece("卒", Color.black, w, h, this);
        pieceBZ3 = new ChessPiece("卒", Color.black, w, h, this);
        pieceBZ4 = new ChessPiece("卒", Color.black, w, h, this);
        pieceBZ5 = new ChessPiece("卒", Color.black, w, h, this);


        moveRule = new MovePiece(this, chessPoint);
        this.reStart();
    }

    public void addWinPanel() {

        if (ifRedWin == true)
            rw.setVisible(true);
        else if (ifBlackWin == true)
            bw.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frameImg, 0, 0, 1366, 730, this);
        g.drawImage(Img, 0, 0, 530, 600, this);
        //画上用户信息

        g.setColor(Color.gray);
        g.drawRect(800, 110, 400, 400);//大矩形
        g.drawImage(image0, 800, 110, 400, 400, this); //添加背景图
        //玩家一的信息
        g.drawRect(850, 160, 100, 100); //画上玩家一的头像
        g.drawImage(image1, 850, 160, 100, 100, this);


        g.drawRect(850, 360, 100, 100); //玩家二的头像
        g.drawImage(image2, 850, 360, 100, 100, this);

        //中间加上VS
        g.setColor(Color.red);
        Font f = new Font("Times New Roman", Font.ITALIC, 35);
        g.setFont(f);
        g.drawString("V   S", 980, 320);

        //设置颜色和字体
        g.setColor(Color.YELLOW);
        f = new Font("宋体", Font.BOLD, 20);
        g.setFont(f);

        //玩家一的信息
        g.drawString("Name: " + name1, 990, 195);
        g.drawString("Play Times:  " + count1, 990, 235);

        //玩家二的信息
        g.drawString("Name: " + name2, 990, 395);
        g.drawString("Play Times:  " + count2, 990, 435);
        //-------------------------------------------------------------------
        if (redMove == true) {
            redPiece.setVisible(true);
        } else if (redMove == false) {
            redPiece.setVisible(false);
        }

        if (blackMove == true) {
            blackPiece.setVisible(true);
        } else if (blackMove == false) {
            blackPiece.setVisible(false);
        }
    }


    public void reStart() {
        ifRedWin = false;
        ifBlackWin = false;
        totalGames++;
        pieceRJL.vector.clear();
        pieceRML.vector.clear();
        pieceRXL.vector.clear();
        pieceRSL.vector.clear();
        pieceRS.vector.clear();
        pieceRSR.vector.clear();
        pieceRXR.vector.clear();
        pieceRMR.vector.clear();
        pieceRJR.vector.clear();
        pieceRPL.vector.clear();
        pieceRPR.vector.clear();
        pieceRB1.vector.clear();
        pieceRB2.vector.clear();
        pieceRB3.vector.clear();
        pieceRB4.vector.clear();
        pieceRB5.vector.clear();
        pieceBJL.vector.clear();
        pieceBML.vector.clear();
        pieceBXL.vector.clear();
        pieceBSL.vector.clear();
        pieceBJ.vector.clear();
        pieceBSR.vector.clear();
        pieceBXR.vector.clear();
        pieceBMR.vector.clear();
        pieceBJR.vector.clear();
        pieceBPL.vector.clear();
        pieceBPR.vector.clear();
        pieceBZ1.vector.clear();
        pieceBZ2.vector.clear();
        pieceBZ3.vector.clear();
        pieceBZ4.vector.clear();
        pieceBZ5.vector.clear();

        flagPoint = null;
        flagBeEated = null;
        count = 0;
        cnt = 0;
        ifEat = false;
        redMove = true;
        blackMove = false;

        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= r; j++)
                chessPoint[i][j].isChessPiece = false;
        }


        chessPoint[1][10].setPiece(pieceRJL, this);
        pieceRJL.setBounds(chessPoint[1][10].x - this.w / 2 + 2, chessPoint[1][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRJL.setVisible(true);
        pieceRJL.vector.add(chessPoint[1][10]);

        chessPoint[2][10].setPiece(pieceRML, this);
        pieceRML.setBounds(chessPoint[2][10].x - this.w / 2 + 2, chessPoint[2][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRML.setVisible(true);
        pieceRML.vector.add(chessPoint[2][10]);

        chessPoint[3][10].setPiece(pieceRXL, this);
        pieceRXL.setBounds(chessPoint[3][10].x - this.w / 2 + 2, chessPoint[3][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRXL.setVisible(true);
        pieceRXL.vector.add(chessPoint[3][10]);

        chessPoint[4][10].setPiece(pieceRSL, this);
        pieceRSL.setBounds(chessPoint[4][10].x - this.w / 2 + 2, chessPoint[4][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRSL.setVisible(true);
        pieceRSL.vector.add(chessPoint[4][10]);

        chessPoint[5][10].setPiece(pieceRS, this);
        pieceRS.setBounds(chessPoint[5][10].x - this.w / 2 + 2, chessPoint[5][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRS.setVisible(true);
        pieceRS.vector.add(chessPoint[5][10]);

        chessPoint[6][10].setPiece(pieceRSR, this);
        pieceRSR.setBounds(chessPoint[6][10].x - this.w / 2 + 2, chessPoint[6][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRSR.setVisible(true);
        pieceRSR.vector.add(chessPoint[6][10]);

        chessPoint[7][10].setPiece(pieceRXR, this);
        pieceRXR.setBounds(chessPoint[7][10].x - this.w / 2 + 2, chessPoint[7][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRXR.setVisible(true);
        pieceRXR.vector.add(chessPoint[7][10]);

        chessPoint[8][10].setPiece(pieceRMR, this);
        pieceRMR.setBounds(chessPoint[8][10].x - this.w / 2 + 2, chessPoint[8][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRMR.setVisible(true);
        pieceRMR.vector.add(chessPoint[8][10]);

        chessPoint[9][10].setPiece(pieceRJR, this);
        pieceRJR.setBounds(chessPoint[9][10].x - this.w / 2 + 2, chessPoint[9][10].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRJR.setVisible(true);
        pieceRJR.vector.add(chessPoint[9][10]);

        chessPoint[2][8].setPiece(pieceRPL, this);
        pieceRPL.setBounds(chessPoint[2][8].x - this.w / 2 + 2, chessPoint[2][8].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRPL.setVisible(true);
        pieceRPL.vector.add(chessPoint[2][8]);

        chessPoint[8][8].setPiece(pieceRPR, this);
        pieceRPR.setBounds(chessPoint[8][8].x - this.w / 2 + 2, chessPoint[8][8].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRPR.setVisible(true);
        pieceRPR.vector.add(chessPoint[8][8]);

        chessPoint[1][7].setPiece(pieceRB1, this);
        pieceRB1.setBounds(chessPoint[1][7].x - this.w / 2 + 2, chessPoint[1][7].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRB1.setVisible(true);
        pieceRB1.vector.add(chessPoint[1][7]);

        chessPoint[3][7].setPiece(pieceRB2, this);
        pieceRB2.setBounds(chessPoint[3][7].x - this.w / 2 + 2, chessPoint[3][7].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRB2.setVisible(true);
        pieceRB2.vector.add(chessPoint[3][7]);

        chessPoint[5][7].setPiece(pieceRB3, this);
        pieceRB3.setBounds(chessPoint[5][7].x - this.w / 2 + 2, chessPoint[5][7].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRB3.setVisible(true);
        pieceRB3.vector.add(chessPoint[5][7]);

        chessPoint[7][7].setPiece(pieceRB4, this);
        pieceRB4.setBounds(chessPoint[7][7].x - this.w / 2 + 2, chessPoint[7][7].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRB4.setVisible(true);
        pieceRB4.vector.add(chessPoint[7][7]);

        chessPoint[9][7].setPiece(pieceRB5, this);
        pieceRB5.setBounds(chessPoint[9][7].x - this.w / 2 + 2, chessPoint[9][7].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceRB5.setVisible(true);
        pieceRB5.vector.add(chessPoint[9][7]);

        chessPoint[1][1].setPiece(pieceBJL, this);
        pieceBJL.setBounds(chessPoint[1][1].x - this.w / 2 + 2, chessPoint[1][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBJL.setVisible(true);
        pieceBJL.vector.add(chessPoint[1][1]);

        chessPoint[2][1].setPiece(pieceBML, this);
        pieceBML.setBounds(chessPoint[2][1].x - this.w / 2 + 2, chessPoint[2][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBML.setVisible(true);
        pieceBML.vector.add(chessPoint[2][1]);

        chessPoint[3][1].setPiece(pieceBXL, this);
        pieceBXL.setBounds(chessPoint[3][1].x - this.w / 2 + 2, chessPoint[3][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBXL.setVisible(true);
        pieceBXL.vector.add(chessPoint[3][1]);

        chessPoint[4][1].setPiece(pieceBSL, this);
        pieceBSL.setBounds(chessPoint[4][1].x - this.w / 2 + 2, chessPoint[4][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBSL.setVisible(true);
        pieceBSL.vector.add(chessPoint[4][1]);

        chessPoint[5][1].setPiece(pieceBJ, this);
        pieceBJ.setBounds(chessPoint[5][1].x - this.w / 2 + 2, chessPoint[5][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBJ.setVisible(true);
        pieceBJ.vector.add(chessPoint[5][1]);

        chessPoint[6][1].setPiece(pieceBSR, this);
        pieceBSR.setBounds(chessPoint[6][1].x - this.w / 2 + 2, chessPoint[6][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBSR.setVisible(true);
        pieceBSR.vector.add(chessPoint[6][1]);

        chessPoint[7][1].setPiece(pieceBXR, this);
        pieceBXR.setBounds(chessPoint[7][1].x - this.w / 2 + 2, chessPoint[7][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBXR.setVisible(true);
        pieceBXR.vector.add(chessPoint[7][1]);

        chessPoint[8][1].setPiece(pieceBMR, this);
        pieceBMR.setBounds(chessPoint[8][1].x - this.w / 2 + 2, chessPoint[8][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBMR.setVisible(true);
        pieceBMR.vector.add(chessPoint[8][1]);

        chessPoint[9][1].setPiece(pieceBJR, this);
        pieceBJR.setBounds(chessPoint[9][1].x - this.w / 2 + 2, chessPoint[9][1].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBJR.setVisible(true);
        pieceBJR.vector.add(chessPoint[9][1]);

        chessPoint[2][3].setPiece(pieceBPL, this);
        pieceBPL.setBounds(chessPoint[2][3].x - this.w / 2 + 2, chessPoint[2][3].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBPL.setVisible(true);
        pieceBPL.vector.add(chessPoint[2][3]);

        chessPoint[8][3].setPiece(pieceBPR, this);
        pieceBPR.setBounds(chessPoint[8][3].x - this.w / 2 + 2, chessPoint[8][3].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBPR.setVisible(true);
        pieceBPR.vector.add(chessPoint[8][3]);

        chessPoint[1][4].setPiece(pieceBZ1, this);
        pieceBZ1.setBounds(chessPoint[1][4].x - this.w / 2 + 2, chessPoint[1][4].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBZ1.setVisible(true);
        pieceBZ1.vector.add(chessPoint[1][4]);

        chessPoint[3][4].setPiece(pieceBZ2, this);
        pieceBZ2.setBounds(chessPoint[3][4].x - this.w / 2 + 2, chessPoint[3][4].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBZ2.setVisible(true);
        pieceBZ2.vector.add(chessPoint[3][4]);

        chessPoint[5][4].setPiece(pieceBZ3, this);
        pieceBZ3.setBounds(chessPoint[5][4].x - this.w / 2 + 2, chessPoint[5][4].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBZ3.setVisible(true);
        pieceBZ3.vector.add(chessPoint[5][4]);

        chessPoint[7][4].setPiece(pieceBZ4, this);
        pieceBZ4.setBounds(chessPoint[7][4].x - this.w / 2 + 2, chessPoint[7][4].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBZ4.setVisible(true);
        pieceBZ4.vector.add(chessPoint[7][4]);

        chessPoint[9][4].setPiece(pieceBZ5, this);
        pieceBZ5.setBounds(chessPoint[9][4].x - this.w / 2 + 2, chessPoint[9][4].y - this.h / 2, this.w, this.h);// 棋子位置，宽度，高度  
        pieceBZ5.setVisible(true);
        pieceBZ5.vector.add(chessPoint[9][4]);

        this.add(rw);
        rw.setBounds(40, 230, 450, 330);
        rw.setVisible(false);

        this.add(bw);
        bw.setBounds(40, 230, 450, 330);
        bw.setVisible(false);

        if (totalGames == 1)
            changeChance();
    }

    public void changeChance() {
        time.time_start();
    }

    public void mousePressed(MouseEvent e) {

        ChessPiece piece = null;
        if (e.getSource() == this)
            move = false;
        if (move == false)
            if (e.getSource() instanceof ChessPiece) {

                piece = (ChessPiece) e.getSource();

                startX = piece.getBounds().x;
                startY = piece.getBounds().y;
                int sX = startX + piece.width / 2;
                int sY = startY + piece.height / 2;

                for (int i = 1; i <= c; i++) {
                    for (int j = 1; j <= r; j++) {
                        int x = chessPoint[i][j].getX();
                        int y = chessPoint[i][j].getY();
                        if (sX > x - piece.width / 2 && sX < x + piece.width / 2 && sY > y - piece.width / 2 && sY < y + piece.width / 2) {
                            startI = i;
                            startJ = j;
                            break;
                        }

                    }
                }
            }
    }

    public void mouseMoved(MouseEvent e) {
    }

    /**
     * 鼠标拖动事件
     */
    public void mouseDragged(MouseEvent e) {

        ChessPiece piece = null;
        if (e.getSource() instanceof ChessPiece) {
            piece = (ChessPiece) e.getSource();
            move = true;

            e = SwingUtilities.convertMouseEvent(piece, e, this);
        }

        if (e.getSource() == this) {
            if (move && piece != null) {
                x = e.getX();
                y = e.getY();
                if (redMove && piece.color == Color.red) {
                    piece.setLocation(x - piece.getWidth() / 2,
                            y - piece.getHeight() / 2);
                }
                if (blackMove && piece.color == Color.black) {
                    piece.setLocation(x - piece.getWidth() / 2,
                            y - piece.getHeight() / 2);
                }
            }
        }
    }

    /**
     * 松开鼠标事件
     */
    public void mouseReleased(MouseEvent e) {

        ChessPiece piece = null;
        move = false;
        if (e.getSource() instanceof ChessPiece) {
            piece = (ChessPiece) e.getSource();

            e = SwingUtilities.convertMouseEvent(piece, e, this);
        }
        if (e.getSource() == this) {

            boolean containChessPoint = false;
            int endX = e.getX();
            int endY = e.getY();

            int x = 0, y = 0;

            if (piece != null) {

                for (int i = 1; i <= c; i++) {
                    for (int j = 1; j <= r; j++) {
                        x = chessPoint[i][j].getX();
                        y = chessPoint[i][j].getY();
                        if (endX > x - piece.width / 2 && endX < x + piece.width / 2 && endY > y - piece.width / 2 && endY < y + piece.width / 2) {
                            containChessPoint = true;
                            endI = i;
                            endJ = j;
                            break;
                        }

                    }
                }
            }


            if (piece != null && containChessPoint) {

                Color pieceColor = piece.getColor();
                if (chessPoint[endI][endJ].isPiece()) {

                    Color c = (chessPoint[endI][endJ].getPiece()).getColor();
                    if (pieceColor.getRGB() == c.getRGB()) {
                        piece.setLocation(startX, startY);

                        (chessPoint[startI][startJ]).setIsChessPiece(true);

                    } else {


                        boolean ok = moveRule.movePieceRule(piece, startI, startJ,
                                endI, endJ);
                        if (ok) {

                            ChessPiece pieceRemoved = chessPoint[endI][endJ].getPiece();
                            chessPoint[endI][endJ].reMovePiece(pieceRemoved, this);
                            chessPoint[endI][endJ].setPiece(piece, this);
                            (chessPoint[startI][startJ]).setIsChessPiece(false);
                            piece.vector.add(chessPoint[endI][endJ]);
                            flagPiece[count] = piece;
                            count++;
                            beEated[cnt] = pieceRemoved;
                            flagBeEated = pieceRemoved;
                            cnt++;
                            ifEat = true;
                            piece.setLocation(chessPoint[endI][endJ].getX() - piece.getWidth() / 2,
                                    chessPoint[endI][endJ].getY() - piece.getHeight() / 2);

                            if (piece.color == Color.red) {
                                redMove = false;
                                blackMove = true;
                            }
                            if (piece.color == Color.black) {
                                blackMove = false;
                                redMove = true;
                            }

                            moveRule.isWine(pieceRemoved);

                            validate();
                            repaint();

                            ifCancelTime = true;
                        } else {
                            piece.setLocation(startX, startY);
                            (chessPoint[startI][startJ]).setIsChessPiece(true);
                        }
                    }

                } else {

                    boolean ok = moveRule
                            .movePieceRule(piece, startI, startJ, endI, endJ);

                    if (ok) {

                        chessPoint[endI][endJ].setPiece(piece, this);
                        (chessPoint[startI][startJ]).setIsChessPiece(false);
                        piece.vector.add(chessPoint[endI][endJ]);
                        flagPiece[count] = piece;
                        count++;
                        ifEat = false;
                        piece.setLocation(chessPoint[endI][endJ].getX() - piece.getWidth() / 2,
                                chessPoint[endI][endJ].getY() - piece.getHeight() / 2);

                        if (piece.color == Color.red) {
                            redMove = false;
                            blackMove = true;
                        }
                        if (piece.color == Color.black) {
                            blackMove = false;
                            redMove = true;
                        }

                        ifCancelTime = true;
                    } else {
                        piece.setLocation(startX, startY);
                        (chessPoint[startI][startJ]).setIsChessPiece(true);
                    }
                }
            }

            if (piece != null && !containChessPoint) {
                piece.setLocation(startX, startY);
                (chessPoint[startI][startJ]).setIsChessPiece(true);
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }
}

class redWinPanel extends JPanel {
    public Image redWinImg;

    public redWinPanel() {
        redWinImg = Toolkit.getDefaultToolkit().getImage("src/img/red-win.png");

        this.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(redWinImg, 0, 0, 450, 100, this);
    }
}

class blackWinPanel extends JPanel {

    public Image blackWinImg;

    public blackWinPanel() {

        blackWinImg = Toolkit.getDefaultToolkit().getImage("src/img/black-win.png");
        this.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(blackWinImg, 0, 0, 450, 100, this);
    }
}
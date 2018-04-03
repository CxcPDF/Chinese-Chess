package 象棋登录;

import java.sql.*;
import java.util.Vector;

public class DataBase {
    Register register=Login.getRegister();
    Connection connection = null;
    public static Vector vector=new Vector();

    public DataBase(){
        this.getConnection();
        this.show();
    }
    /*
    连接数据库
    */
    public void getConnection(){
        String url = "jdbc:mysql://localhost:3306/chess";
        String user = "root";
        String psd = "450642604";
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url, user, psd);
                System.out.println("连接到数据库...");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /*
   显示和获取数据库中的内容
    */
    public void show() {
        Statement st= null;
        try {
            st=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            st = connection.createStatement();
            String str1="select * from chess_user order by grade desc";
            ResultSet rs1=st.executeQuery(str1);
            while (rs1.next()){
                String name=rs1.getString("name");
                String password=rs1.getString("password");
                int grade=rs1.getInt("grade");
                System.out.println("姓名是：" + name + " 密码是" + password + " 赢的局数为：" + grade);
                vector.add(name + "-" +password+ "-"+grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    将姓名和密码储存
     */
    public void Store() {
        if(register.flag==1) {//如果有人注册才执行这个方法
            String name =register.getName();
            String psd = register.getPassword();

            String sql = "insert into chess_user(name,password,grade) values(?,?,?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, psd);
                preparedStatement.setInt(3, 0);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    用户注册的时候检查是否重名
     */
    public boolean checkname(String name) {
        for(int i=0;i<vector.size();i++){
            System.out.println((String)vector.get(i));
        }
        for (int i = 0; i < vector.size(); i++) {
            String str = (String) vector.get(i);
            String[] tmp = str.split("-");
            if (tmp[0].equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*
    用户登录的时候检查用户名密码是否正确
     */
    public boolean check(String name,String password){
        for (int i = 0; i < vector.size(); i++) {
            String str = (String) vector.get(i);
            String[] tmp = str.split("-");
//            System.out.println("姓名："+tmp[0]+" 密码"+tmp[1]);
            if (tmp[0].equals(name)&&tmp[1].equals(password)) {
//                System.out.println("姓名："+tmp[0]+" 密码"+tmp[1]);
                return true;
            }
        }
        return false;
    }


    /**
     * 更新数据
     * @param winnerName
     */
    public void update(String winnerName){
        Statement st= null;
        try {
            st=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        int grade = 0;
        try {
            st = connection.createStatement();
            String str1="select grade from chess_user where name=\""+winnerName+"\"";
            ResultSet rs1=st.executeQuery(str1);
            while (rs1.next()){
                grade=rs1.getInt("grade");
                grade++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="update chess_user set grade="+grade+" where name=\""+winnerName+"\";";
        System.out.println(sql);
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取获胜的局数
     */
    public int getGrade(String name){
        int grade = 0;
        String sql="select grade from chess_user where name=\""+name+"\";";
        Statement st = null;
        try {
            st=connection.createStatement();
            ResultSet set=st.executeQuery(sql);
            while (set.next()){
                grade=set.getInt("grade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    /*
    关闭资源
     */
    protected void Close(Connection conn,PreparedStatement pre,ResultSet set){
        try {
            if (set!=null) {
                set.close();
                set=null;
            }
            if (pre!=null) {
                pre.close();
                pre=null;
            }
            if (conn!=null) {
                conn.close();
                conn=null;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
package �����¼;

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
    �������ݿ�
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
                System.out.println("���ӵ����ݿ�...");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /*
   ��ʾ�ͻ�ȡ���ݿ��е�����
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
                System.out.println("�����ǣ�" + name + " ������" + password + " Ӯ�ľ���Ϊ��" + grade);
                vector.add(name + "-" +password+ "-"+grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    �����������봢��
     */
    public void Store() {
        if(register.flag==1) {//�������ע���ִ���������
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
    �û�ע���ʱ�����Ƿ�����
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
    �û���¼��ʱ�����û��������Ƿ���ȷ
     */
    public boolean check(String name,String password){
        for (int i = 0; i < vector.size(); i++) {
            String str = (String) vector.get(i);
            String[] tmp = str.split("-");
//            System.out.println("������"+tmp[0]+" ����"+tmp[1]);
            if (tmp[0].equals(name)&&tmp[1].equals(password)) {
//                System.out.println("������"+tmp[0]+" ����"+tmp[1]);
                return true;
            }
        }
        return false;
    }


    /**
     * ��������
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
     * ��ȡ��ʤ�ľ���
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
    �ر���Դ
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
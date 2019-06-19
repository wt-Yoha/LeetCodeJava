package JDBC_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC_Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.print("Connect PostgreSQL: \n\n");
        try {
//            Class.forName("org.postgresql.Driver").newInstance();

            //数据库： GTR
            String url = "jdbc:postgresql://localhost:5432/spj";

            //用户名：postgres   密码： root
            Connection con = DriverManager.getConnection(url, "postgres","996895");
            Statement st = con.createStatement();

            //检索表： user_info
            String sql = " select * from j ";
            ResultSet rs = st.executeQuery(sql);


            while (rs.next()) {
                //列出第1，2,3列的值
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\n");
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

}

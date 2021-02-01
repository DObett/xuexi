package dao;
import java.sql.*;

public class rec {
    String senten;
    int id;

    public int getId() {
        return id;
    }

    public String getSenten() {
        return senten;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSenten(String senten) {
        this.senten = senten;
    }

    public void updateRecord(int id, String text, int char_count, Timestamp date ) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int num = 0;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "INSERT INTO `daili`.`sentences`(`id`, `sentence`, `char_count`,`time`) VALUES ("+id+",\""+text+"\","+char_count+",\""+date+"\");";

            // 执行更新，返回受影响行数
            num = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }

    }

    public String selectRecord(String sentence) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        rec record = new rec();

        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "SELECT id ,sentence  FROM sentences WHERE    sentence=" + "\'" + sentence + "\'" + ";";

            // 执行更新，返回受影响行数
            rs = stmt.executeQuery(sql);
// 循环结果
            while (rs.next()) {
                record.setId(rs.getInt(1));
                record.setSenten(rs.getString(2));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return   record.getSenten();
 
    }

    

    


    


















}

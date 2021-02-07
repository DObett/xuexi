package dao;

import java.sql.*;
import java.util.*;

public class rec {
    String baofu;
    String id;

    public String getId() {
        return id;
    }

    public String getSenten() {
        return baofu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSenten(String senten) {
        this.baofu = senten;
    }

    public void updateRecord(int id, int count, Set<String> red,  Set<String> blue ) {
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
            String sql = "INSERT INTO `daili`.`baofu`(`id`, `count`, `red`,`blue`) VALUES ("+id+","+count+",\""+red+"\",\""+blue+"\");";

            // 执行更新，返回受影响行数
            num = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }

    }

    public Map<String, List<String>> selectRecord() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        rec record = new rec();
       // JSONObject object = new JSONObject();
        Map<String, List<String>> map = new HashMap<>();
        List<String> groupNameList = new ArrayList<String>();//
        List<String> orderid = new ArrayList<String>();
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "SELECT * from `daili`.`0205`;";

            // 执行更新，返回受影响行数
          //  rs = stmt.executeQuery(sql);

            rs = stmt.executeQuery(sql);



            int rowCount = 0;

// 循环结果
                while (rs.next()) {
                 record.setId(rs.getString(1));
               record.setSenten(rs.getString(2));


              // for (int x=0;x<rowCount;x++){


               if (rowCount==0){
                   orderid.add(record.getId());
                   groupNameList.add(record.getSenten());
                   map.put(orderid.get(rowCount), groupNameList);

            }else if (  orderid.get(rowCount-rowCount).equals(record.getId())) {
                   groupNameList.add(record.getSenten());
                  map.put(orderid.get(rowCount-rowCount), groupNameList);
                   System.out.println(map);
               } else {
                   List<String>  String.value.of(orderid.size)  = new ArrayList<String>();
                   orderid.clear();
                   groupNameList.clear();
                   orderid.add(record.getId());
                   groupNameList.add(record.getSenten());
                   map.put(record.getId(), groupNameList);
               }
                    rowCount++;
           }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
          return map;
 
    }

    

    


    


















}

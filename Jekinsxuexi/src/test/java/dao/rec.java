package dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class rec {
    String baofu;
    String id;
    String  orderId;
    String oiExt;
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

    public  void setoiExt(String oiExt) {
        this.oiExt=oiExt;
    }
    public  void setorderId(String orderId) {
        this.orderId=orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOiExt() {
        return oiExt;
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

    public void updatefhoi(String orderId,  String stage2,  String stage1 ) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int num = 0;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnections();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "INSERT INTO `daili`.`fhoi`(`orderId`, `stage1`, `stage2`) VALUES (\""+orderId+"\",\""+stage1+"\",\""+stage2+"\");";

            // 执行更新，返回受影响行数
            num = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }

    }

    public Map<String, String> selectRecord() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        rec record = new rec();
       // JSONObject object = new JSONObject();
        Map<String, List<String>> map = new HashMap<>();

        List<String> groupNameList = new ArrayList<String>();//
        List<String> orderid = new ArrayList<String>();
        Map<String, String> mapp = new HashMap<>();

        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "SELECT * from daili.0206;";

            // 执行更新，返回受影响行数
          //  rs = stmt.executeQuery(sql);

            rs = stmt.executeQuery(sql);




            int rowCount = 0;

// 循环结果
            List<String> orderids = new ArrayList<String>();
            orderids.add("2020-11-12 00:00:00");
            orderids.add("2019-01-21 11:35:03");
            orderids.add("2019-02-22 18:00:55");
            orderids.add("2019-01-12 18:00:55");
            orderids.add("2019-05-22 18:00:55");
            orderids.add("2019-06-22 18:00:55");
            orderids.add("2019-01-12 18:00:55");



             record.compareriqi(orderids);
            System.out.println(record.compareriqi(orderids));



            for (int x = 0; x <= rowCount; x++) {

                while (rs.next()) {
                    record.setId(rs.getString(1));
                    record.setSenten(rs.getString(2));




                        if (rowCount == 0) {
                            orderid.add(record.getId());
                            groupNameList.add(record.getSenten());
                            mapp.put(orderid.get(rowCount), record.listToString(groupNameList,groupNameList));

                        } else if (orderid.get(rowCount - rowCount).equals(record.getId())) {
                            groupNameList.add(record.getSenten());
                            record.compareriqi(groupNameList);
                           mapp.put(orderid.get(rowCount - rowCount),   record.compareriqi(groupNameList));
                           // mapp.put(orderid.get(rowCount - rowCount),  record.compareriqi(groupNameList));
                          //  record.listToString(groupNameList,groupNameList);

                        } else {


                            //  String[] strings = groupNameList.toArray(new String[groupNameList.size()]);
                            // map.put(orderid.get(rowCount-rowCount), Arrays.asList(strings));


                            //mapp.put(orderid.get(rowCount - rowCount), record.listToString(groupNameList,groupNameList));
                            mapp.put(orderid.get(rowCount - rowCount),  record.compareriqi(groupNameList));
                            orderid.clear();
                            groupNameList.clear();
                            orderid.add(record.getId());
                            groupNameList.add(record.getSenten());

//                            continue;



                        }

                    rowCount++;

                    }

                }
           // System.out.println(mapp.size());
            System.out.println(rowCount);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
          return mapp;

 
    }

    public Map<String, String>   selectoiExt(){

       Connection conn = null;
       Statement stmt = null;
       ResultSet rs = null;
       rec record = new rec();
        List<String> orderidlist = new ArrayList<String>();//
        List<String> oiExtlist = new ArrayList<String>();
        Map<String, String> mapp = new HashMap<>();
       try {
           //获得数据的连接
           conn = JDBCUtils.getConnection();
           //获得Statement对象
           stmt = conn.createStatement();
           //发送SQL语句
           String sql = "SELECT orderId,oiExt from fh20210226v1.FhOi    ; ";




           // 执行更新，返回受影响行数
           rs = stmt.executeQuery(sql);
           wait(132000);
           while (rs.next()) {
               record.setorderId(rs.getString(1));
               record.setoiExt(rs.getString(2));
                orderidlist.add(record.getOrderId());
                oiExtlist.add(record.getOiExt());
                mapp.put(record.getOrderId(),record.getOiExt());
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           JDBCUtils.release(rs, stmt, conn);
       }

         return  mapp ;


    }













    public String listToString(List list ,List<String> separator) {
        StringBuilder sb = new StringBuilder();
 for (int i = 0; i < list.size(); i++) {
     if (i == list.size() - 1) {
         sb.append(list.get(i));
     } else {
         sb.append(list.get(i)+" ");
//sb.append(separator);

     }
 }
   return sb.toString();
    }


    public   String  compareriqi (List<String> separator) throws ParseException {
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (int x=0;x<=separator.size();x++){//冒泡排序记住这2个循环 很重要的 
                for (int y=0;y<separator.size()-1;y++) {
                    String date = separator.get(y);Date dateD = sdf.parse(date);

                    String date1 = separator.get(y + 1);  Date datee = sdf.parse(date1);



                    if (dateD.getTime() >= datee.getTime()) {


                        separator.set(y,date1);
                        separator.set(y+1,date);

                    }
                }

            }


        return separator.get(0)  ;
    }















}



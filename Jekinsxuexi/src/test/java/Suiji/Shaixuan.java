package Suiji;
import java.sql.SQLException;
import java.util.*;
import dao.rec;
public class Shaixuan {
    public static void main(String[] args) throws SQLException {
         rec recoder =new rec();

        System.out.println(recoder.selectRecord());

    }

}

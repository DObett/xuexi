package Suiji;
import java.sql.SQLException;
import java.util.*;
import dao.rec;
public class Shaixuan {
    public static void main(String[] args) throws SQLException {
        rec recoder = new rec();
        Map<String, String> mapp = new HashMap<>();
        mapp=recoder.selectRecord();
        Set set = mapp.keySet();
        System.out.println(mapp.size());
        for(Iterator iter = set.iterator(); iter.hasNext();)
        {
            String key = (String)iter.next();
            String value = (String)mapp.get(key);
           System.out.println(key+"===="+value);
           // System.out.println(value);


        }


        HashMap map = new HashMap();

        map.put("a","aaaa");
        map.put("b","bbbb");
        map.put("c","cccc");
        map.put("d","dddd");
        //System.out.println(map.size());

    }



    }


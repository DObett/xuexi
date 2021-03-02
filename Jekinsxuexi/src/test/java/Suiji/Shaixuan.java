package Suiji;
import java.sql.SQLException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import dao.rec;
public class Shaixuan {
    public static void main(String[] args) throws SQLException {
        rec recoder = new rec();
        Map<String, String> mapp = new HashMap<>();
        //mapp=recoder.selectRecord();
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
          String  str ="{\"stage1\":\"2019-01-20 23:59:59\",\"stage2\":\"2019-01-20 23:59:59\"}";


        Map<String, String> mas = new HashMap<>();
        mas=recoder.selectoiExt();
        for (Object mapss : mas.entrySet()){
            System.out.print(((Map.Entry)mapss).getKey()+"  ");
            List<String> stage = new ArrayList<String>();
            String aa= (String) ((Map.Entry)mapss).getKey();
            str= (String) ((Map.Entry)mapss).getValue();
            Map maps = (Map) JSON.parse(str);
            for (Object ma : maps.entrySet()) {
                System.out.print(" "+((Map.Entry) ma).getKey() + " " + ((Map.Entry) ma).getValue());
                 stage.add((String) ((Map.Entry) ma).getValue());

            }
            recoder.updatefhoi(aa,stage.get(1),stage.get(0));
            stage.clear();
            System.out.println();

        }






        //System.out.println(recoder.selectoiExt());




    }



    }


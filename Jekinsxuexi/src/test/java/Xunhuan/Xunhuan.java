package Xunhuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Xunhuan {
    public static void main(String[] args){

        Map<String,List<String>> levelmap=new HashMap<String,List<String>>();
        List<String> putlist=new ArrayList<>();
        putlist.add("2018-01-04 11:57:03");
        putlist.add("2018-02-02 11:55:46");
        putlist.add("2018-02-06 11:57:25");

        levelmap.put("723748973331875290", putlist);
        for (Entry<String, List<String>> in: levelmap.entrySet()){
            System.out.println("key===  "+in.getKey()+"     values=  "+in.getValue());
        }
    }


}

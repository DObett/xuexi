package jsonxuexi;

import com.alibaba.fastjson.JSONObject;

public class ConsJson {
    public ConsJson() {
        // TODO Auto-generated constructor stub
    }

    public String Object2Json(Object obj){
        //String str = JSONObject.toJSONString(obj);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);//将java对象转换为json对象
       // JSONObject json = JSONObject.parseObject((String) obj);//将java对象转换为json对象
       String str = jsonObject.toString();//将json对象转换为字符串

        return str;
    }
}


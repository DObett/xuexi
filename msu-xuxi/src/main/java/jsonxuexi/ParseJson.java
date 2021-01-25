package jsonxuexi;


import com.alibaba.fastjson.JSONObject;

public class ParseJson {
    private String jsonStr;

    public ParseJson() {

    }

    public ParseJson(String str){
        this.jsonStr = str;
    }
    /**
     * 解析json字符串
     */
    public void parse(){
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String name = jsonObject.getString("name");
        int num = jsonObject.getInteger("num");
        String sex = jsonObject.getString("sex");
        int age = jsonObject.getInteger("age");

        System.out.println(name + " " + num + " " + sex + " " + age);
    }
    //将json字符串转换为java对象
    public Person JSON2Object(){
        //接收{}对象，此处接收数组对象会有异常
        if(jsonStr.contains("[")){
            jsonStr = jsonStr.replace("[", "");
        }
        if(jsonStr.contains("]")){
            jsonStr = jsonStr.replace("]", "");
        }
        JSONObject obj = JSONObject.parseObject(jsonStr);//将json字符串转换为json对象
        Person jb = JSONObject.toJavaObject(obj,Person.class);//将建json对象转换为Person对象
        return jb;//返回一个Person对象
    }


}

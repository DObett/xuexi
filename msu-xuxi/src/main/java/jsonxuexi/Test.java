package jsonxuexi;

import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {

        //将字符串转换为json对象，然后根据建得到相应的值
        ParseJson pj = new ParseJson("{\"name\":\"gu\",\"num\":123456,\"sex\":\"male\",\"age\":24}");
        pj.parse();

        //将一个json字符串转换为java对象
        Person p = pj.JSON2Object();
        System.out.println("Name:" + p.getName());
        System.out.println("Num:" + p.getNum());
        System.out.println("Sex:" + p.getSex());
        System.out.println("age:" + p.getAge());

        //将一个java对象转换为Json字符串
        Person p1 = new Person("gu1",123,"male",23);
        ConsJson cj = new ConsJson();
        String str1 = cj.Object2Json(p1);
        System.out.println(cj.Object2Json(p1));

        User user = new User("张三", "男", 18);

        //Java对象转化为JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        System.out.println("Java对象转化为JSON对象\n" + jsonObject);//{"name":"张三","age":18,"sex":"男"}

        //Java对象转换成JSON字符串
        String userStr = JSONObject.toJSONString(user);
        System.out.println("Java对象转换成JSON字符串\n" + userStr);//{"age":18,"name":"张三","sex":"男"}
/*

JSON对象-->JSON字符串
 */

        //先转成JSON对象
        JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(user);

        //JSON对象转换为JSON字符串
        String jsonString = jsonObject1.toJSONString();
        System.out.println("JSON对象转换为JSON字符串\n" + jsonString);//{"name":"张三","age":18,"sex":"男"}
/*

JSON对象-->Java对象
 */
        User user1 = new User("张三", "男", 18);
        //先转成JSON对象
        JSONObject jsonObject2 = (JSONObject) JSONObject.toJSON(user1);

        //JSON对象转换成Java对象
        User user2 = JSONObject.toJavaObject(jsonObject2, User.class);
        System.out.println("JSON对象转换成Java对象\n" + user2);//User{name='张三', sex='男', age=18}

/*

JSON字符串-->JSON对象
 */

        String userStrr = "{\"age\":18,\"name\":\"张三\",\"sex\":\"男\"}";

        //JSON字符串转换成JSON对象
        JSONObject jsonObject3 = JSONObject.parseObject(userStrr);
        System.out.println("JSON字符串转换成JSON对象\n" + jsonObject3.toString());//{"sex":"男","name":"张三","age":18}


      /*

JSON字符串-->Java对象
 */
        String userStre = "{\"age\":18,\"name\":\"张三\",\"sex\":\"男\"}";

        //JSON字符串转换成Java对象
      //  JSONObject obj = JSONObject.parseObject(userStre);
      //  User user3 = JSONObject.toJavaObject(obj, User.class);
       // JSONObject obj = JSONObject.parseObject(jsonStr);//将json字符串转换为json对象
       // Person jb = JSONObject.toJavaObject(obj,Person.class);//将建json对象转换为Person对象


        User user3 = JSONObject.parseObject(userStre, User.class);
        //必须覆写toString 方法 要不然返回的就是hascode值
        System.out.println("JSON字符串转换成Java对象\n" + user3.toString());//user {name='张三', sex='男', age=18}

    }
}

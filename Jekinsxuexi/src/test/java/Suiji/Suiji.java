package Suiji;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
public class Suiji {
    public static void main(String[] args) {

        //1.创建对象

        Random random = new Random();
        ArrayList<String> numbers = new ArrayList<String>();
        //Set<String> numbers = new TreeSet<String>();
        for(int i = 0;i < 6;i++){

            int number = random.nextInt(34)+1;
            //int[] suiji = new int[6];  int 不行存不了02  会自动把0去掉

             if (number<10){
                String number1 = "0"+number;
                numbers.add(number1);
             }else{
             numbers.add(String.valueOf(number));}

        }
        Collections.sort(numbers);
        System.out.print(numbers+" ");
        for (String i : numbers) {
            //System.out.print(i+",");
        }

        Set<String> set = new TreeSet<String>();
        while(true){
            int sui = (int) (Math.random() * 33) + 1;// 获取33以内的数字
            set.add(sui<10?"0"+sui:""+sui);//将元素存入集合中
            if (set.size() == 6) {//存满六个红色球，则结束循环
                break;
            }
        }
        Set<String> set2 = new TreeSet<String>();
        int sui2 = (int) (Math.random() * 16) + 1;// 获取16以内的数字
        set2.add(sui2<10?"0"+sui2:""+sui2);
        System.out.println("红球：" + set + " 蓝球：" + set2);


    }

}

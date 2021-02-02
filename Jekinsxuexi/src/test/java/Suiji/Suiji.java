package Suiji;
import java.util.*;

public class Suiji {
    public static void main(String[] args) {

        //1.创建对象
        for (int q = 0; q < 9999999; q++) {

            Set<String> set = new TreeSet<String>();
            while (true) {
                int sui = (int) (Math.random() * 33) + 1;// 获取33以内的数字
                set.add(sui < 10 ? "0" + sui : "" + sui);//将元素存入集合中
                if (set.size() == 6) {//存满六个红色球，则结束循环
                    break;
                }
            }
            Set<String> set2 = new TreeSet<String>();
            int sui2 = (int) (Math.random() * 16) + 1;// 获取16以内的数字
            set2.add(sui2 < 10 ? "0" + sui2 : "" + sui2);
           // System.out.println("红球：" + set + " 蓝球：" + set2);
            List<String> lst = new ArrayList<String>(set);
            //
            Random random = new Random();
            ArrayList<String> numbers = new ArrayList<String>();
            //Set<String> numbers = new TreeSet<String>();
            int count = 0;
            for (int i = 0; i < 6; i++) {

                int number = random.nextInt(33) + 1;
                //int[] suiji = new int[6];  int 不行存不了02  会自动把0去掉

                if (number < 10) {
                    String number1 = "0" + number;
                    numbers.add(number1);
                } else {
                    numbers.add(String.valueOf(number));
                }

//            //去除重复数据
//            for (int y=1;y<numbers.size();y++){
//                if (numbers.get(i).equals(numbers.get(y-1))) {
//                    numbers.remove(y-1);
//                    i = i - 1;
//                    System.out.print("重服");
//                }
//            }

                if (!numbers.get(i).equals(lst.get(i))) {
                    numbers.remove(i);


                    if (i == 0) {
                        i = -1;
                    } else {
                        i = i - 1;
                    }
                    count++;


                }

            }
          //  System.out.println(count + "次跑出一样结果");


            //Collections.sort(numbers);

            //System.out.println(numbers + " ");
            //冒泡排序
            for (int y = 0; y <= 5; y++) {
                for (int z = 0; z <= 4; z++)
                    if (Integer.parseInt(numbers.get(z + 1)) < Integer.parseInt(numbers.get(z))) {
                        String a = numbers.get(z);
                        String c = numbers.get(z + 1);
                        numbers.set(z, c);
                        numbers.set(z + 1, a);

                    }
            }


           // System.out.println(numbers + " ");

            // System.out.println(numbers+" ");
            for (String i : numbers) {
                //System.out.print(i+",");
            }

            if (count == 999) {
                System.out.println(numbers + " ");
                System.out.println("红球：" + set + " 蓝球：" + set2);
                System.out.println(count + "次跑出一样结果");
            }
        }
    }
}

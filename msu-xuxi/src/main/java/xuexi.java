import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class xuexi {

    public static void main(String[] args) {

        String html = "<div class=\"divRow\">\n" +
                "                                 <div class=\"width25per\">王XX</div>\n" +
                "                                 <div class=\"width25per\">配偶</div>\n" +
                "\t\t\t\t\t\t\t\t <div class=\"mobileOnly\">受益顺序</div>\n" +
                "                                 <div class=\"width29per\">1</div>\n" +
                "\t\t\t\t\t\t\t\t <div class=\"mobileOnly\">百分比</div>\n" +
                "                                 <div class=\"\">100</div>\n" +
                "                              </div>";

        Document document = Jsoup.parse(html);
        Elements elements = document.select("div[class=divRow]");
        //将class属性为“mobileOnly”的元素去掉，把剩下的拿出来
        Elements  a1 = elements.first().children().select("div[class=mobileOnly]").remove();
        Elements  bb= document.select("div[class=divRow]");


        String a =bb.text();

         //  String a =elements.text();

        System.out.println(a);
        for (Element element : bb) {
            System.out.println(element.html());
        }

    }



}



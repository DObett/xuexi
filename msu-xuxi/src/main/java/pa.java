import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import dao.rec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pa {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        String url="https://tool.lu/timestamp/";
//        String params="9A55DF41FC1544699AD2AE9DE9786234";
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.addHeader("Content-Type", "application/json");
//        httpPost.setEntity(new StringEntity(params));
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//        System.out.println(response.getStatusLine().getStatusCode() + "\n");
//        HttpEntity entity = response.getEntity();
//        String responseContent = EntityUtils.toString(entity, "UTF-8");
//        System.out.println(responseContent);



//        response.close();
//        httpClient.close();

        for (int x = 2242; x < 20000; x++) {

                // int x1=0; x1++;
                Thread.sleep(5000);
                Content aa = Request.get(url).addHeader("User-Agent", "Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0").execute().returnContent();
                //System.out.println(aa.asString());
                String srr = aa.asString();
                Document doc = Jsoup.parse(srr);
            String C = doc.select(" .note-container").text();


            //String c="I don't know why, but all I want right now is sex.";
            String B=C.replace("\'","\\'");

            int du = B.length();
            rec re = new rec();

            Date date = new Date();
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

            Timestamp goodsC_date = Timestamp.valueOf(nowTime);

            //System.out.println(re.selectRecord(B));
            if (re.selectRecord(B)==null){
                re.updateRecord(x, B, du, goodsC_date);
                for (int y=0;y<x;) {

                    System.out.println(x+B);
                    break;
                }
            } else {
                System.out.println("已存在:  "+B);
                   x= x-1;
            }









        }




        //org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
//        Content aa = Request.get(url).addHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0").execute().returnContent();
//        System.out.println(aa.asString());
//          String srr=aa.asString();
//        Document doc = Jsoup.parse(srr);
        //搜什么文字出什么内容
       // String A =doc.getElementsMatchingOwnText("网页").text();
        //根据元素查找 文字
      //  String B =doc.attr("a").concat("关于百度").toString();
        //第二种获取文本的方式 通过cssQuERY 方式 类似xpath  一级一级找
        //String B =doc.select( "a:contains(设为首页)").text();
         //通过class="cur-tab"   即.cur-tab   获取文本
       // String B =doc.select( " .cur-tab").text();
        //通过cssSELECT 选择 F12查找复制然后获取文本
        //String B =doc.select( " #bottom_layer > div.s-bottom-layer-left > p:nth-child(1) > a").text();
        //  getElementsByAttributeValueMatching  只能用来匹配元素 获取文本不会  必须target="_blank"  这样等式   单独的p  b 标签没用
        //String B =doc.getElementsByAttributeValueMatching("target","_blank").text();
        //还是要key=value 选顶才能获取文本
        //String B =doc.getElementsByAttributeValueMatching("href","//home.baidu.com").text();
        //这个getElementsByAttribute  是获取的target="_blank"等式中 等号左边的值 为key  对于 单独的 p  b  div 没用
       // Elements B =doc.getElementsByAttribute("src");
        //这个也是根据 元素这样href="http://ir.baidu.com"  对于 单独的 p  b  div 没用
       // String  B =doc.getElementsByAttributeValue("href","//home.baidu.com").text();
        //这哥是 把关于文字的元素都展示出来查找当前元素包含的文本String  ContainingText   与MatchingText 一样都是匹配包含文本的所有元素
        //Elements  B =doc.getElementsContainingText("关于百度");
       // String  B =doc.getElementsMatchingText("关于百度").text();
       // 查找当前元素直接包含的文本内容的元素   ownText() 获取到当前元素的文本 , 而不是子孩子的文本
        //String B =doc.getElementsMatchingOwnText("关于百度").text();
       // String B =doc.getElementsContainingOwnText("关于百度").text();
        //String B =doc.title();

      //  String B =doc.select( " .note-container").text();

        //百度一下，你就知道
       // System.out.println(A);
       // System.out.println(B);
//        Elements links = doc.select("a[href]");
//        System.out.println(links.size());
//        for (org.jsoup.nodes.Element link : links) {
//            System.out.println(link.attr("abs:href") + " " + link.text());
//        }
    }

    /**
     * stream读取内容，可以传入字符格式
     * @param resEntity
     * @param charset
     * @return
     */
    private static String readResponse(HttpEntity resEntity, String charset) {
        StringBuffer res = new StringBuffer();
        BufferedReader reader = null;
        try {
            if (resEntity == null) {
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(
                    resEntity.getContent(), charset));
            String line = null;

            while ((line = reader.readLine()) != null) {
                res.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return res.toString();
    }}


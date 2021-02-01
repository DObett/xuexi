import demo.TransApi;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20210109000667145";
    private static final String SECURITY_KEY = "gLcrRLqHHhzqLoIKbn3W";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "target";
        System.out.println(api.getTransResult(query, "auto", "z"));
    }

}

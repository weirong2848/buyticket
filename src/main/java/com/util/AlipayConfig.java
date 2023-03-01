package com.util;


import java.io.FileWriter;
import java.io.IOException;

//支付宝沙箱配置
public class AlipayConfig {


    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600699493";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDZd2WVaF00C3VkseBUiaqypiLsdEHW79HAZ8uh5f/1IMLOsHCDingbGyMZfUiW1tQCaieRYrEgwIxsNJGmK4uPrP0bZCRnFIE1NWKSzLOrDkL+jh1RaSMdOhw1PK5mReaLRNvPQHH2NUTZ5lrcH/H2HET8yjUNLS/Cfi37BvPKZXL+6aEuErSkmxYKoBwGLXAUYxI47OZyLz3tVyJh+JMVKJds6whbEARHJYSzA4zpS0YQXT1Tupta9QWVmG7cDaJt588NSGTHXVHrt4m5SAihix+iivC4qdB2Xpwr1uXyIJv4lUCLahWclgh2W7robNU5UpSWN3fMFRoOLt9VbZ27AgMBAAECggEAMUhBmS5hkN3X6M32zLG2IW5NE9D06sTGgBgFqdb5vo+CFl0d4nGK7nmj5q7huG1O9o0gEm6PPaDlMdBoAYR0yEanxYFYTpPzBB/pCuOhA+7jd9S1CDIPZxw4MEhkLYFB0eX0+m7cZLOFuuvdQ21p5CBb8f3RL/9Bh44Y1X6p2P/hgVie5HklFDt39LcAQAHhwnnSntNau0DMxdRXqf/KBXcL/Pn01X4EHQT+5P8U8mZSVIDUEfEnXOAm8TQo8TWQEnnVsVqDDuazXpfmSWG/XokGx5sCbH/u1DZh6DDSJH3Z31Fo612tCoDPNnYU7kC+7TvETvwnyzb9eftpj/2aAQKBgQD6fiZ429lQwpqtsU+UXpaYUHH4qVIUIhzRw8cN2+67rXm9nFGwFdvC+cDheY0NInOxyf8VxfUWPXgN9+al8b+L4TvvKOBqeyDDh4VTYkvFwm/jTIFP34w0xdCS3WwvkA5WyY5VUh7SAD80zeUwM5oDpRhn2c8u9XFRrBYDrERS+wKBgQDeP10uTPvLNeaMnJ/wrY0Fm+QMy2qrc2GBE6/6E5iPrbb2JtFvuMdt29GBnOtUqMs5oUEeMr2Rj0JL6iwPSVb1zI1lqcw4MBNsuRUZ+wJ0GEGvd3Ivk6U9BePoX9A7JvvkBG4g2eVI2PsHYX6M1oJ5ozYUjp5cJ4kWnwfnqvfkQQKBgHRfjSITCVgSwOe2+4CznQUwQnLCvyYpXvg5G04eAkBg7LEhYXYMAagIfgqCfPxAKD3N2VtVN3LYpeDfbeFkeZfT0RNgCzqM74DHgjJl9Uvv9ClGTsE72xhdWnQQuIU0SOUbCKws1bK8eKDgkvyczI2q8ra0oyNu1fGaoDOeobNnAoGAVdj+AluES4uHgbsiYNJ5DbiYz4RnsNCB0l0rdZrKLH26lbyK2+/xQPNPKxTVJj+JOLqcL7ED3s0Km85ZtJHswEeCOsnq861GY5Hen8mAuh2AienGtq/+fOLglSslgSPe2sYHUDM6yPffh4tWWcqmXZv40NoCO7Cd2JoXcJpu5MECgYBeYTaZbr1y1XjNTAAt7TiF21ksrNxgBz4YLgsRHraxPYDLBFOHut/6R4aE8yQFAdNkl6ZPOH4pWoJYB4M9KQn2TblFUtvWCIfpBmfcIJC5CIQTXQt530phn4x/9P1jISD/L9PIjug25g7YW/6L40RsUPlkEVAhH2ejsSCxXkqDGw==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.html 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2XdllWhdNAt1ZLHgVImqsqYi7HRB1u/RwGfLoeX/9SDCzrBwg4p4GxsjGX1IltbUAmonkWKxIMCMbDSRpiuLj6z9G2QkZxSBNTViksyzqw5C/o4dUWkjHTocNTyuZkXmi0Tbz0Bx9jVE2eZa3B/x9hxE/Mo1DS0vwn4t+wbzymVy/umhLhK0pJsWCqAcBi1wFGMSOOzmci897VciYfiTFSiXbOsIWxAERyWEswOM6UtGEF09U7qbWvUFlZhu3A2ibefPDUhkx11R67eJuUgIoYsfoorwuKnQdl6cK9bl8iCb+JVAi2oVnJYIdlu66GzVOVKUljd3zBUaDi7fVW2duwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/pay/inIndex";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

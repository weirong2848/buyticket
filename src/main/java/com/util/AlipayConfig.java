package com.util;


import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {


    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600699493";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCilWL/P7eLb0SLOM/nO1Gnur/h3JsG6t9ZMaj424IEgJNZm/zPeB5CM63ITjd4TGrIej88X/ubAZuLzxo+6094VFZY6sQszWKzSUIAycCiIoz4fqXWPnf/FmE6xT6N9PZWAu7ashsleU7SBRUuw/w/zd7p+Q5MMiACImS6f/aN1TnLyAC9yS1e/Dz7PCbRSHSSvyiKxi5Ut/nWyyQ9U76+ApONgU8+jyMfpYtht2u3gbuIXkCy7jCecaQOd4Pq93vTtKL284/dOVoUaekc6QFWMmi2Btv9wrM19nCeUy9WDiEFn1paNfaDmQTABHo+Qx9azUp2u8aE8TfaIEDoGnERAgMBAAECggEAab8ETsSgmv5Z9LuU7e71I0Uh/MPByXQGpTrZjlMnc8o1DLmaa07TT3fRdlD5XzNE2PQ6IQjE24LmKr8fcQEYBUnFh7vasNE9eyMQ3PZcZphWXGHzdy/WWIGz58fW8fn8JuFtfa0OXwdRruRDbNFoRg+fB0tIc2K+0uSP44XLVV/nBt5XPbi2JrlJuWOrOq64BNatTTwBQiZrzox3+JC5e5e5c9Eh4oMQ9yz2zfIYurWQCBbiN7N0YMmUuZN0O/Uy/kLOt1EeJgw0bMXrbELOKV4XCydM/QlPr8ujPJgE47wPDLOIStuTcsrEt+OJ6wVjANBt+zlxdlCFbx43V9It4QKBgQDydd1GZ+TzRzPLfcul6rsheGxaT5Q2gJPVbM79YDHsbF1zE5KPtoCp0kJ8EYQJdMTP4t6kyrK9dHX24VI+AeB94QsdjJDOp72rx5OjDdLOfdalpZkj5NQFewe+zST8BkIQmyv9EsFVKnjeFLxCHwu36DphL0tIg1TPUfDni/u6TQKBgQCrqaDkkUCblMocN3bj0BEiUKKSoYZenBXu1k10RXitEcwDftRrveLZ9Putah2y+QiyPvBxVcdSnIxt6sgBXV0xdMugt4MkC0v7Bf3NWtRcf/PibjxmNpxfMVVTg4r98kIetHMeQLGlhqK6/peLQwbXdxHOsyZIBz6TjyRFkJOr1QKBgQC/x5bU38zq2QERDlmMzVRjLxuVe6iiS6WjhUNci0Ax360zHuIoppSyvssz0676w9ABF1RASMyEqp+8PZGN1nI5X04pe0v3ChsuytfuezqpdkPYFlpBV/iUtTH1K9L7Pf/3nqV2seUWdlfQYdpe+quMNjYnNP95RdhJfGju3XypaQKBgQCqV6xBw+VxvacFcwB2Nf0aqRt6F/Dnp0mYdG3tqBaE3zksasnNlGMs1457WebYt4iqoAwm2vDtCE3NsQIBYK1eq0B5XkEzHkaqdRqSkcRTeeEAW1VyNFTdnW3HbqwZLTHxmCz340ilMcH/fy3QUpXSb+Rq0Zl2NkIhWRSsNzhidQKBgCE8LrWidga6LRFrHCTZlXAfqEuI3f+k2zJYFHb+WFiufQxU9ixEyARWT4FNz+OtUQykGzW+HLp/OgrQaHsT/IjX6kZUzUdpdDw0ZUsfF+OrlRBq3ZsYQmpaHXZYoXBUr0bZyp2UuHwnQYimnA5h29QFywh7/EUsycfXCGtyrwcU";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.html 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmBq9dV+rkibrTrAHbMpolclN0zsQCMmd+slibbkLaSsuEnGh0ehCDCwYkVtiDb00G1jaO5SPkmYuPlqWcsL6fKN67gxkODeHOigrfefoKm8v0zOwbDGI9aETYU+WROesaIkiTc47QnSIJRhFU/9UYvUP2abrpsvoHKISRbbdjFOlOSea5HDJVQUuxAhfQXqqqp392y597DwEWmLv82UqNxl/gz0qEpC6AEMdHh9EaXpRgpVaIw1cqNd5Z9xojDk82HB6E4RgdQK7oBMLp1syCxHLf+QsUCdSLgtlTX5rEt3pIQeg0icq174GButPnDMKGvkQPHsdN3D2BLbZaIixcwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/pay/inIndex";

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

package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092800612573";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJzGvHEGiVY0Jvwlf97Zzod79rRdWHPkjMKqiSAJxwyPTmbW4ZNFWpbk/yxGsWmo73zK0zmLpEle4VIEo/hfE++cIoPNjbVmfAuZytFAhHO5R/aWEs1Qn4o9M0h/rhmbZ7/WpHObeSa0/1TU44+AjDNfB3466XbmxNonRE8ifokKkUaTXwsthgGHPIYTBTwQldJyTChnSaDLs/U5rHKtsbpXN2aJZdHpbo6H8iDO0JUCrpxsUKc5875hHDuz3N5SQhdr+/D23cbe0R17P4fQ4/VpRU+WLUommDeMSesTBLlGOn4K30feUwuVULXEgiOgOK2jSqL3gcaEgPJiCyaUzxAgMBAAECggEAR5EApMlT18pOdea0dnAS3vVaWCdTx8LEYi0BkZp5pWXpM0fAN5zjpHRjV01F5N5uxCnsBnEaxIYtuZEknqs86R0kBmvboMbWadS8l3Ng/UXnUOj1DCi03gqPpae9169ShEDQEp/aRFQxmdAFgTboriH0ev+n7IPwAb4OrsQpj/HWTu+9vQ8BBqstZbTkat0nz4e11SdheT69TRs8KgrQsYdKwgNb0onUzJEJ8iPMoB1Qduz8mOhSIazvJ7yMThCfJdO9TkqG5M2RI/+BQRBqxrvheSeBFk/HYwjEyXyn1cBeUhG+1RM8XujytbDvupZCG9t0iTTpP5qnE2gVirxkBQKBgQDGJT/CKjHS2jkKz5iU8LeLAl3DqhTD8oapLRjLzrA3HyZOx43oqktJ+P0cayeSYpr+D2IhFMBaEhMF4SFcYSeYiTLHv8y+yHanWIMLgysAL+Z38JN2lLbu3YoPPO4Zs7tb45TxJ2HE6/N4XGMvO1B1e3kFBbfYfLkfcr0P5MX5kwKBgQCyCGzj19t+aBRfwGzFmQruvTpiC094pYlYgjd9VUicgfQS2vzmvYQCXHl84SMVJAMF6AiCT4MJR4Z1hAgLLZH3OFz5zzsvEHFIOWmOwQRBrWa85wT63WSM8PKwR9NW1h87oT8WaRO4s0PM4lSkehxAElTLsgZSAiNIAQ7qpkHh6wKBgQC0zyrGKDC84oso1VS7nIkwHSGouZwnTjkZSWCWIe5k7lTLkIdrJ3J6du2pMBK1HqumaC04WLJJvrKDK/OAU9uI8rFW2yufcFftzvQN3kyv6AXbrrkxfPUNNTWVQBlZdMvkRuETyccKpfDPBScw42RBQEGnlpczwmQ/UTk6tpz9ZwKBgBji1p3Oya7Uy6xK0KmaaA3RQ7z6ycQal6VYpnsNldXS0JRmKh3y9eYCmTTcn7PP0eBce/wDM1Tzu5bnutwdJZ9CMLT2w9YjXUJ0TA4ZawfnPko/nNGYavrMn5AGqkMkMT97nb77NzeFT3/vT1eifhpytYm3u+xwwg/JnhUs4l67AoGAWoKTThj2+I9LsAAaSkB3S2xxe+5W38EphoZvQ4weeJE2D+T9gsIuxbX4PqIrT4AkaGMdIiyrvvzUSeCUnQELuM5GZdphEXf+hpYazE5TcO1PTdjGoEmOwFRb0mSNOthIR3QctNbfZPHGJR86HIJYA4YYFXrg0MZNG/zqxZ17qW4=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoJ5wOnv9TvgPwti5ElkGivI6tiI7yoJ+MUtgOfmxuWXgBsDPpl4tz4KxKurZtDUMI/tIktIq2pq6s/zguVfq7e6dhgwP08VFIkRDYrzhwiJ4uPQow9gX/iWV+JgXp0NDH3ecz4KPedTsiol+8uRbytUTw9wCKEjyCaDPZPD9SQA3scBBJeX0U0tEKyWdykElWSHpZpQFs8/WcDcc6VyBmY0uVIAwhiB0qmkwkpNKhinYwBOcNqQhk7LrGaeBlO7+/zwc+wscYpyGFH7xJe0JAHit+QRKL0828/4FqYl/b87E1eo20YV9Kfw8mCTmA4Q7natOnHcijK5uxBF+gt/N2QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/demo_1_war/chenggong";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    //public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:/logs/";


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


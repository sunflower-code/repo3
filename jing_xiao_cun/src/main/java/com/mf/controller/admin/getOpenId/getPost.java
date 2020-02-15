package com.mf.controller.admin.getOpenId;

import com.mf.controller.testOpenId3.HttpRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/httpRequest")
public class getPost {

    @Value("${weixin.app_id}") // spring配置文件配置了appID
    private String appid;

    @Value("${weixin.app_secret}") // spring配置文件配置了secret
    private String secret;

    @RequestMapping("/openId")
    @ResponseBody
    public Map<String, Object> openId(String code) { // 小程序端获取的CODE
    Map<String, Object> result = new HashMap<>();
    result.put("code", code);
    try {
    boolean check = (StringUtils.isEmpty(code)) ? true : false;
    if (check) {
    throw new Exception("参数异常");
    }

     StringBuilder urlPath = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session"); // 微信提供的API，这里最好也放在配置文件
     urlPath.append(String.format("?appid=%s", appid));
     urlPath.append(String.format("&secret=%s", secret));
     urlPath.append(String.format("&js_code=%s", code));
     urlPath.append(String.format("&grant_type=%s", "authorization_code")); // 固定值
     String url = urlPath.toString();

     String data = HttpRequest.sendGet(url,""); // java的网络请求，这里是我自己封装的一个工具包，返回字符串
        try{
            // 解析相应内容（转换成json对象）
            JSONObject json = new JSONObject(data);
            // 获取会话密钥（session_key）
            String session_key = (String) json.get("session_key").toString();
            // 用户的唯一标识（openid）
            String openid = (String) json.get("openid").toString();
            result.put( "session_key",session_key);
            result.put( "openId",openid );
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
    result.put("code", 1);
    result.put("remark", e.getMessage());
    e.printStackTrace();
}
    return result;

}

}

package com.mf.controller.testOpenId3;



import com.alibaba.fastjson.JSONObject;
import com.mf.entity.User;
import com.mf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin/WxUserLog")
@PropertySource(value= {"classpath:weixin.properties"})
@ConfigurationProperties( prefix ="prop")

public class WxUserLog {

    @Autowired
    private UserService userService;

    @Value("${wx.url}")
    String url;
    @Value("${wx.appId}")
    String appId;
    @Value("${wx.appSecret}")
    String appSecret;
    @Value("${wx.grant_type}")
    String grantType;

    @RequestMapping("/a")
    //private Map<String,Object> myMap;
    private String getUserWXLoginInfo(String code) {
       /* prop.myMap.url=https://api.weixin.qq.com/sns/jscode2session
        prop.myMap.appId=wxdeded2ca6fc5eb48
        prop.myMap.appSecret=5965ff22b53ae30dac8b6607cc6e78f
        prop.myMap.grant_type=authorization_code*/
//      String url = MapUtils.getString(myMap, "url");//请求的地址
//      String appId = MapUtils.getString(myMap, "appId");//开发者对应的AppID
//      String appSecret = MapUtils.getString(myMap, "appSecret");//开发者对应的AppSecret
//      String grant_type = MapUtils.getString(myMap, "grant_type");

        Map<String, Object> map = new HashMap<>();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", grantType);
        String s = UrlUtil.sendPost(url, map);
        return s;
    }

    @PostMapping("/login")
//    @ResponseBody
        public String login(String wxCode, String username, String password) throws ParseException, IOException {
        System.out.println(wxCode+""+username+""+password);
        //请求微信api获取用户的openid和sessionKey

        String str = getUserWXLoginInfo(wxCode);
        Map<String, Object> tempMap = JsonUtils.convertJson2Object(str, Map.class);

        String openid = tempMap.get("openid").toString();
        String sessionkey = tempMap.get("session_key").toString();
        String sign = MD5.stringMD5("openid");

        User user = userService.findByUserName(username);

        if (user.getPassword() != password || !tempMap.containsKey("errcode")) {
            return "登入失败";
        }


       // List<User> wxUserList = userService.findByUserSign(sign);
        //先查询sign存在不存在，存在和当前sign对比是否是相等，不存在就入库显示登入成功
        if ( user.getSign() == null ) {
            User newUser = new User();
            String userid = UUID.randomUUID().toString().replaceAll("-", "");//用户id
            newUser.setUserid(userid);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setOpenid(openid);
            newUser.setSessionkey(sessionkey);
            userService.save(newUser);
            System.out.println(newUser);
            return "登入成功";
        } else {
            if(user.getSign()==sign) {
                System.out.println(user);
                return "登入成功";
            }
            else
                return "账号已经绑定，请联系管理员解绑";
            }
           /*
           Salt salt = new Salt();
           JSONObject jsonObject = salt.getUserInfo(encryptedData,sessionkey,iv);
           String nickName = (String)jsonObject.get("nickName");
           String password = (String)jsonObject.get("password");
           String avatarUrl = (String)jsonObject.get("avatarUrl");
           String gender = (String)jsonObject.get("gender");
           String province = (String)jsonObject.get("province");
           String city = (String)jsonObject.get("city");
           newUser.setopenId(sign);
           newUser.setnickName(nickName);
           newUser.setavatarUrl(avatarUrl);
           newUser.setgender(gender);
           newUser.setprovince(province);
           newUser.setcity(city);
           newUser.setcountry(country);*/
        }
}

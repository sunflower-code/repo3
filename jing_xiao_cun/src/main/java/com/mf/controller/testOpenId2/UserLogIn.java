/*
package com.mf.controller.testOpenId2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mf.controller.admin.UserAdminController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UserLogIn")
public class UserLogIn {

    private JSONObject getUserWXLoginInfo(String wxCode) {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String> requestUrlParam = new HashMap<String,String>();
        requestUrlParam.put("appid", "wxdeded2ca6fc5eb48");	//开发者设置中的appId
        requestUrlParam.put("secret","5965ff22b53ae30dac8b6607cc6e78fd");	//开发者设置中的appSecret
        requestUrlParam.put("js_code", wxCode);	//小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", "authorization_code");	//默认参数
        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(UrlUtil.sendPost(requestUrl, requestUrlParam));
        return jsonObject;
    }

    @RequestMapping("/user")
    @ResponseBody
    public JSONObject login(String wxCode) throws ParseException {
        //请求微信api获取用户的openid和sessionKey
        JSONObject jsonObject = getUserWXLoginInfo(wxCode);
        if (jsonObject != null && !jsonObject.containsKey("sign")) {
            */
/*return (JSONObject) JSON.parse("该用户此前授权登入过");*//*

            System.out.println("此前已授权登入过");
            return jsonObject;
        }

        String openid = (String) jsonObject.get("openid");
        String sessionKey = (String) jsonObject.get("session_key");
        String sign = MD5.stringMD5(openid);

        System.out.println(openid);
        System.out.println(sessionKey);
        System.out.println(sign);

        //通过openid查询数据库是否有此用户 ？？？？？？
        UserAdminController userAdminController = new UserAdminController();
        List<User> userList = userAdminController.getUserByOpenId(openid);

        if (userList != null && userList.size() != 0) {//用户已存在
           */
/* if(userList.get(0).getUserName()==null) {
                jsonObject.put("userName", "");
            }else {
                jsonObject.put("userName", userList.get(0).getUserName());
            }*//*

            if (userList.get(0).getSign() == null || userList.get(0).getSign() != sign) {
                return (JSONObject) JSON.parse("登入失败,请联系管理员解绑");
            } else {
                jsonObject.put("userName", userList.get(0).getUserName());
                jsonObject.put("userId", userList.get(0).getId());
                jsonObject.put("sign", userList.get(0).getSign());
                jsonObject.put("dateTime", new Date());
                return jsonObject;
            }
        }

        User user = new User();
        user.setOpenId(openid);
        user.setSessionKey(sessionKey);
        user.setSign(sign);

       */
/* List<User> newUser = userService.getUserByOpenId(openid);
        if(userList.get(0).getUserName()==null) {
            jsonObject.put("username", "");
        }else {
            jsonObject.put("username", newUser.get(0).getUserName());
        }
        jsonObject.put("userId", newUser.get(0).getId());
        jsonObject.put("dateTime",new Date());*//*

        jsonObject.put("userName", userList.get(0).getUserName());
        jsonObject.put("userId", userList.get(0).getId());
        jsonObject.put("sign", userList.get(0).getSign());
        jsonObject.put("dateTime", new Date());
        return jsonObject;
    }
}

*/

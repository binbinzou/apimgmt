package com.wifishared.apimgmt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.wifishared.apimgmt.client.UserClient;
import com.wifishared.apimgmt.service.UserService;
import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.user.UserRspMsg;
import com.wifishared.common.framework.contant.CommonConstant;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.contant.CommonResultMessageConstant;
import com.wifishared.common.framework.jwt.JwtManager;
import com.wifishared.common.framework.redis.RedisStringManager;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserClient userClient;
	@Autowired
	RedisStringManager redisManager;
	
	@Override
	public GeneralContentResult<String> login(LoginReqBody reqbody) {
		return userClient.login(reqbody);
	}

	@Override
	public GeneralContentResult<UserRspMsg> queryUsersMsg() {
		return userClient.queryUsersMsg();
	}

	@Override
	public GeneralContentResult<String> tokenCheck(String authorization) {
		GeneralContentResult<String> result = new GeneralContentResult<>();
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage(CommonResultMessageConstant.OPERATE_SUCCESS);
		if (authorization == null || !authorization.startsWith("Bearer ")) {
			result.setContent(null);
            return result;
        }
        String token = authorization.substring(7);
        try {
        	//取出token中相应的信息
            Claims claims = JwtManager.parseJWT(token);
            String subject = claims.getSubject();
            LoginReqBody reqBody = JSONObject.parseObject(subject, LoginReqBody.class);
            String key = reqBody.getUserId() + CommonConstant.TOKEN_SPILTE_DEVICEID_USERID + reqBody.getDeviceId();
            if(!redisManager.exists(key)) {
            	result.setContent(null);
                return result;
            }
        } catch (final SignatureException e) {
        	e.printStackTrace();
        	result.setContent(null);
            return result;
        } catch (Exception e) {
        	e.printStackTrace();
        	result.setContent(null);
            return result;
		}
        result.setContent("success");
        return result;
	}

}

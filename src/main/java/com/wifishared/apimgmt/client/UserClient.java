package com.wifishared.apimgmt.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.user.UserRspMsg;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

@FeignClient(url = "http://127.0.0.1:9991",name = "usermgmt")
public interface UserClient {

	@RequestMapping(value = "/auth/v1/users", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<UserRspMsg> queryUsersMsg() ;

	@RequestMapping(value = "/noauth/v1/login", method = RequestMethod.POST	,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<String> login(@RequestBody LoginReqBody reqbody) ;
	
}

package com.wifishared.apimgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wifishared.apimgmt.service.UserService;
import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.user.UserRspMsg;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.contant.CommonResultMessageConstant;
import com.wifishared.common.framework.jwt.JwtManager;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import com.wifishared.common.framework.resultobj.GeneralResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/auth/v1/users", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "Bearer ", required = true) })
	public GeneralContentResult<UserRspMsg> queryUsersMsg() {
		return userService.queryUsersMsg();
	}

	@RequestMapping(value = "/noauth/v1/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<String> login(@RequestBody LoginReqBody reqbody) {
		return userService.login(reqbody);
	}
	
	@RequestMapping(value = "/auth/vc/tokencheck", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "Bearer ", required = true) })
	public GeneralContentResult<String> checkTokenAuth(@RequestHeader("Authorization") String authorization) {
		GeneralContentResult<String> result = new GeneralContentResult<>();
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("鉴权通过");
		result.setContent(authorization);
		return result;
	}
	
	@RequestMapping(value = "/noauth/vc/tokencheck", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "Bearer ", required = true) })
	public GeneralContentResult<String> checkTokenNoAuth(@RequestHeader("Authorization") String authorization) {
		return userService.tokenCheck(authorization);
	}

}

package com.wifishared.apimgmt.service;

import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.user.UserRspMsg;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

public interface UserService {

	GeneralContentResult<String> login(LoginReqBody reqbody);

	GeneralContentResult<UserRspMsg> queryUsersMsg();

	GeneralContentResult<String> tokenCheck(String authorization);

}

package com.wifishared.apimgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifishared.apimgmt.client.UserDeviceClient;
import com.wifishared.apimgmt.service.UserDeviceService;
import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.contant.CommonResultMessageConstant;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

@Service
public class UserDeviceServiceImpl implements  UserDeviceService {
	
	@Autowired
	UserDeviceClient userDeviceClient;
	
	@Override
	public GeneralContentResult<List<UserDeviceRsp>> queryDevices(String userId) {
		return userDeviceClient.queryDevices(userId);
	}

}

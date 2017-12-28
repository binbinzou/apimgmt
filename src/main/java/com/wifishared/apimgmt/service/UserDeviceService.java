package com.wifishared.apimgmt.service;

import java.util.List;

import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

public interface UserDeviceService {

	GeneralContentResult<List<UserDeviceRsp>> queryDevices(String userId);

}

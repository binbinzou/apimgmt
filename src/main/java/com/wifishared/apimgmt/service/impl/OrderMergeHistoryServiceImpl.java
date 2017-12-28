package com.wifishared.apimgmt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifishared.apimgmt.client.OrderMergeHistoryClient;
import com.wifishared.apimgmt.service.OrderMergeHistoryService;
import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.contant.CommonResultMessageConstant;
import com.wifishared.common.framework.jwt.JwtManager;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

@Service
public class OrderMergeHistoryServiceImpl implements OrderMergeHistoryService {

	@Autowired
	OrderMergeHistoryClient orderMergeHistoryClient;

	@Override
	public GeneralContentResult<List<OrdersRspItem>> queryOrders() {
		return orderMergeHistoryClient.queryOrders();
	}

	@Override
	public GeneralContentResult<OrdersRspItem> queryOrderByOrderId(String orderId) {
		return orderMergeHistoryClient.queryOrderByOrderId(orderId);
	}

}

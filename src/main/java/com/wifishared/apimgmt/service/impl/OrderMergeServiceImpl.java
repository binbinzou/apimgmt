package com.wifishared.apimgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifishared.apimgmt.client.OrderMergeClient;
import com.wifishared.apimgmt.service.OrderMergeService;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

@Service
public class OrderMergeServiceImpl implements OrderMergeService{

	@Autowired
	OrderMergeClient orderMergeClient;
	
	@Override
	public GeneralContentResult<OrdersRspItem> queryNoMergenceOrders() {
		return orderMergeClient.queryNoMergenceOrders();
	}

}

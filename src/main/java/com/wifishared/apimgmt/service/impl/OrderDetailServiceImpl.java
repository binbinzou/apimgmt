package com.wifishared.apimgmt.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wifishared.apimgmt.client.OrderDetailClient;
import com.wifishared.apimgmt.service.OrderDetailService;
import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.mq.Producer;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailClient orderDetailClient;
	
	@Override
	public GeneralContentResult<String> createOrderDetail(OrderDetailReqBody orderDetailReqBody) {
		return orderDetailClient.createOrderDetail(orderDetailReqBody);
	}

	@Override
	public GeneralContentResult<OrdersRspItem> createOrderDetailForResult(OrderDetailReqBody orderDetailReqBody) {
		return orderDetailClient.createOrderDetailForResult(orderDetailReqBody);
	}

}

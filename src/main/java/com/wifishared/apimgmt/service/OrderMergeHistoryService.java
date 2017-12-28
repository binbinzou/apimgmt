package com.wifishared.apimgmt.service;

import java.util.List;

import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

public interface OrderMergeHistoryService {

	GeneralContentResult<List<OrdersRspItem>> queryOrders();

	GeneralContentResult<OrdersRspItem> queryOrderByOrderId(String orderId);

}

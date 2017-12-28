package com.wifishared.apimgmt.service;

import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

public interface OrderDetailService {

	GeneralContentResult<String> createOrderDetail(OrderDetailReqBody orderDetailReqBody);

	GeneralContentResult<OrdersRspItem> createOrderDetailForResult(OrderDetailReqBody orderDetailReqBody);

}

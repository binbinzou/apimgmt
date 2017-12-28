package com.wifishared.apimgmt.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@FeignClient(url = "http://127.0.0.1:9992",name = "ordermgmt")
public interface OrderDetailClient {
	
	@ApiOperation(value = "创建订单细节信息")
	@RequestMapping(value = "/auth/v1/orderdetails", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<String> createOrderDetail(
			@RequestBody OrderDetailReqBody orderDetailReqBody) ;

	
	@ApiOperation(value = "创建订单结束细节并Merge主订单")
	@RequestMapping(value = "/auth/v1/orderdetails/mergence", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<OrdersRspItem> createOrderDetailForResult(
			@RequestBody OrderDetailReqBody orderDetailReqBody) ;
}

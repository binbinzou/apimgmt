package com.wifishared.apimgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wifishared.apimgmt.service.OrderDetailService;
import com.wifishared.common.data.dto.hotspot.HotSpotReqBody;
import com.wifishared.common.data.dto.hotspot.HotSpotReqParam;
import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.common.data.otd.hotspot.HotSpotRspBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import com.wifishared.common.framework.resultobj.GeneralResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="订单细节信息")
@RestController
public class OrderDetailController {

	@Autowired
	OrderDetailService orderDetailService;

	@ApiOperation(value = "创建订单细节信息")
	@RequestMapping(value = "/auth/v1/orderdetails", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "Bearer ", required = true) })
	public GeneralContentResult<String> createOrderDetail(
			@RequestBody OrderDetailReqBody orderDetailReqBody) {
		GeneralContentResult<String> result = orderDetailService
				.createOrderDetail(orderDetailReqBody);
		return result;
	}
	
	@ApiOperation(value = "创建订单结束细节并Merge主订单")
	@RequestMapping(value = "/auth/v1/orderdetails/mergence", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "Bearer ", required = true) })
	public GeneralContentResult<OrdersRspItem> createOrderDetailForResult(
			@RequestBody OrderDetailReqBody orderDetailReqBody) {
		GeneralContentResult<OrdersRspItem> result = orderDetailService
				.createOrderDetailForResult(orderDetailReqBody);
		return result;
	}

}

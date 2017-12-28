package com.wifishared.apimgmt.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import io.swagger.annotations.ApiOperation;

@FeignClient(url = "http://127.0.0.1:9992",name = "ordermgmt")
public interface OrderMergeClient {

	@ApiOperation(value = "查询用户未结算的订单")
	@RequestMapping(value = "/auth/v1/orders/nomergence", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<OrdersRspItem> queryNoMergenceOrders() ;

}

package com.wifishared.apimgmt.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wifishared.common.data.dto.hotspot.HotSpotReqBody;
import com.wifishared.common.data.dto.hotspot.HotSpotReqParam;
import com.wifishared.common.data.otd.hotspot.HotSpotRspBody;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import com.wifishared.common.framework.resultobj.GeneralResult;
import io.swagger.annotations.ApiOperation;

@FeignClient(url = "http://127.0.0.1:9993",name = "wifimgmt")
public interface HotSpotClient {

	@ApiOperation(value = "创建热点信息")
	@RequestMapping(value = "/auth/v1/hotspots", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<String> createHotSpot(
			@RequestBody HotSpotReqBody hotSpotReqBody) ;

	@ApiOperation(value = "查询热点信息")
	@RequestMapping(value = "/auth/v1/hotspots/{hotspotId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<HotSpotRspBody> findHotSpot(
			@PathVariable("hotspotId") String hotspotId) ;
	
	@ApiOperation(value = "更新热点信息")
	@RequestMapping(value = "/auth/v1/hotspots/{hotspotId}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResult updateHotSpot(
			@PathVariable("hotspotId") String hotspotId,
			@RequestBody HotSpotReqBody hotSpotReqBody) ;
	
	@ApiOperation(value = "使热点信息失效")
	@RequestMapping(value = "/auth/v1/hotspots/{hotspotId}/disabled", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResult disableHotSpot(
			@PathVariable("hotspotId") String hotspotId) ;
	
	@ApiOperation(value = "删除热点信息")
	@RequestMapping(value = "/auth/v1/hotspots/{hotspotId}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResult deleteHotSpot(
			@PathVariable("hotspotId") String hotspotId) ;
	
	@ApiOperation(value = "根据一些信息查询热点信息")
	@RequestMapping(value = "/noauth/v1/hotspots/location", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralContentResult<List<HotSpotRspBody>> findHotSpotBySomeAttr(
			@RequestBody HotSpotReqParam param) ;
	
}

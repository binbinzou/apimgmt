package com.wifishared.apimgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifishared.apimgmt.client.HotSpotClient;
import com.wifishared.apimgmt.service.HotSpotService;
import com.wifishared.common.data.dto.hotspot.HotSpotReqBody;
import com.wifishared.common.data.dto.hotspot.HotSpotReqParam;
import com.wifishared.common.data.otd.hotspot.HotSpotRspBody;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import com.wifishared.common.framework.resultobj.GeneralResult;

@Service
public class HotSpotServiceImpl implements HotSpotService {

	@Autowired
	HotSpotClient hotSpotClient;
	
	@Override
	public GeneralContentResult<String> createHotSpot(HotSpotReqBody hotSpotReqBody) {
		return hotSpotClient.createHotSpot(hotSpotReqBody);
	}

	@Override
	public GeneralResult updateHotSpot(String hotspotId, HotSpotReqBody hotSpotReqBody) {
		return hotSpotClient.updateHotSpot(hotspotId, hotSpotReqBody);
	}

	@Override
	public GeneralResult disableHotSpot(String hotspotId) {
		return hotSpotClient.disableHotSpot(hotspotId);
	}

	@Override
	public GeneralResult deleteHotSpot(String hotspotId) {
		return hotSpotClient.deleteHotSpot(hotspotId);
	}

	@Override
	public GeneralContentResult<List<HotSpotRspBody>> findHotSpotBySomeAttr(HotSpotReqParam param) {
		return hotSpotClient.findHotSpotBySomeAttr(param);
	}

	@Override
	public GeneralContentResult<HotSpotRspBody> findHotSpot(String hotspotId) {
		return hotSpotClient.findHotSpot(hotspotId);
	}

}

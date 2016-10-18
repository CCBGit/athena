package com.ccb.testcenter.dataprocess.entity;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ccb.testcenter.athena.dataprocess.data.StandardData;
import com.ccb.testcenter.athena.dataprocess.entity.service.ServiceContainer;
import com.ccb.testcenter.athena.dataprocess.mapping.ServiceMapping;

public class Test {
	public static void main(String[] args) throws Exception {
//		ServiceMapping serviceMapping = ContextHelper.getCtx().getBean("SA0213800-A0182S303", ServiceMapping.class);
//		serviceMapping.load("SA0213800-A0182S303.xlsx");
//		ServiceMapping serviceMapping = new ServiceMapping("SA0213800", "A0182S303", "SA0213800-A0182S303.xlsx");
//		String[] requestComs = new String[]{"COM1", "COM3", "COM5", "COM6", "COM7"};
//		String[] responseComs = new String[]{"COMA"};
//		service.setRequestComs(requestComs);
//		service.setResponseComs(responseComs);
		
//		ServiceRequest request = serviceMapping.getRequest();
//		ServiceResponse response = service.getResponse();
		
		String data = "TFT-BUSN-TYPE:2,TFT-FUNC:2,TXL-LL:         1072,TXL-TX-LOG-NO:3106136401010000151,TXL-TX-TYP:0,TXL-TX-ID:SA0213800,TXL-BUSN-CODE:SA0,TXL-APP-TX-CODE:2138,TXL-SUB-TX-CODE:00,TXL-BUSN-DT:20150508,TXL-CPU-DT:20150806,TXL-CPU-TM:135056829,TXL-TERMINAL:310613640A01001,TXL-AUTH-FLG:B,TXL-AUTH-TYP:3,TXL-SPV-A:            ,TXL-SPV-B:310613636301,TXL-EC-FLG:0,TXL-EC-LOG-NO:                   ,TXL-AR-LOG-NO:3106136401012198030,TXL-ACCOUNT-NO:                            ,TXL-OPPO-ACCOUNT-NO:                            ,TXL-TX-TYPE:2,TXL-DOC-TYPE: ,TXL-BOOK-CODE:101,TXL-TX-AMT1:            0.00,TXL-TX-AMT2:            0.00,TXL-TELLER-VER:            ,TXL-24H-EC-FLG:0,TXL-TX-TRIG-STS:0,TXL-TX-TRIG-LOG-NO:                   ,TXL-ORG-BRANCH-STD:310613640,TXL-ORG-TELLER-ID:310613640101,TXL-CSHBX-NO:310613640101,TXL-CHL-TYP-CODE:000,TXL-CHL-APP-CODE:000000,TXL-AGT-TYP-CODE:   ,TXL-AGT-APP-CODE:      ,TXL-PASS-CARD-FLAG: ,TXL-TX-MODE:0,TXL-CALL-ADPL-FLG: ,TXL-DPL-DJR-KEY:                      ,TXL-DPL-1LVL-BRH-ID:   ,TXL-DPL-TX-LOG-NO:                   ,TXL-SOURCE:   ,TXL-EVT-TRACE-ID:                         ,TXL-SND-SERIAL-NO:          ,TXL-TRD-TP-ECD:      ,TXL-ACT-ADJAC-SETNO:                                   ,TXL-DPL-DJR-KEY-S:                      ,INT-SYS-TX-CODE:CCBS,INT-BUS-OP-CODE:    ,INT-LL:          208,INT-TERMINAL:310613640A01001,INT-BRANCH-ID:310613640,INT-TERM-TYP:A,INT-LAN-ID:01,INT-TERM-SRL:001,INT-TX-ID:SA0213800,INT-BUSN-CODE:SA0,INT-APP-TX-CODE:2138,INT-SUB-TX-CODE:00,INT-TX-TYP:0,INT-TX-MODE:0,INT-TELLER-ID:310613640101,INT-MSG-STATUS:   32768,INT-BUSINESS-CTL:01,INT-MAC-OFFSET:   0,INT-MAC-LL:   0,INT-MAC-VALUE:    ,INT-KEY-SYNC-VALUE:    ,INT-RESERVE-AREA1:            ,INT-TX-MEDIA-TYPE: ,INT-TRIG-TX-FLAG: ,INT-PAYPWD-CK-FLG: ,INT-EC-BBN:   ,INT-FEE-MOD: ,INT-EBCDIC-CV-FLG: ,INT-1LVL-FE-ID: ,INT-RESERVE-AREA2:        ,INT-OPTIONAL-FIELD-MAP:   28672,INM-SPV-B:310613636301,INM-LCL-OR-RSN(1):B8148,INM-LCL-OR-RSN(2):     ,INM-LCL-OR-RSN(3):     ,INM-LCL-OR-RSN(4):     ,INM-HST-OR-RSN(1):B8148,INM-HST-OR-RSN(2):     ,INM-HST-OR-RSN(3):     ,INM-HST-OR-RSN(4):     ,TFT-0001:2,TFT-0002:3106136364992780145500600000,TFT-0003:01,TFT-0004:0,TFT-0005:2,TFT-0006:20.00,TFT-0007:,TFT-0008:20150608,TFT-0009:,";
		String[] datas = data.split(",");
		
		Map<String, String> map = new TreeMap<String, String>();
		for(String segment : datas) {
			String key = StringUtils.substringBefore(segment, ":");
			String value = StringUtils.substringAfter(segment, ":");
			map.put(key, value);
		}
			
		String convertId = "SA0213800-A0182S303";
		
		StandardData standardData = new StandardData();
		standardData.setConvertId(convertId);
		standardData.setData(map);
		
		String result = JSON.toJSONString(standardData, true);
		
		StandardData sData = JSON.parseObject(result, StandardData.class);
		
//		System.out.println(sData.getConvertId());
//		
//		for(Map.Entry<String, String> a : sData.getData().entrySet()) {
//			System.out.println(a.getKey());
//			System.out.println(a.getValue());
//		}
		
		ServiceMapping serviceMapping = ServiceContainer.getServiceMapping(convertId);
		
		String xml = serviceMapping.getRequestXML(map);
		System.out.println(xml);
	}
		
}

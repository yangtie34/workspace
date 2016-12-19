package com.forYiYun.recoverymonitoring.entity.queryCondition;

import java.util.LinkedHashMap;
import java.util.Map;

public class PublicQuery {
	protected static Map<String,String> columnOrder_Production=new LinkedHashMap<>();		
	protected static Map<String,String> KeywordsType_Production=new LinkedHashMap<>();		
	protected static Map<String,String> columnOrder_ProductionReport=new LinkedHashMap<>();
	protected static Map<String,String> KeywordsType_ProductionReport=new LinkedHashMap<>();
	protected static Map<String,String> state_ProductionReport=new LinkedHashMap<>();
	
	protected static Map<String,String> orderType=new LinkedHashMap<>();		
	protected static Map<String,String> from=new LinkedHashMap<>();		
	protected static Map<String,String> recycleType=new LinkedHashMap<>();	
	
	static{
		columnOrder_Production.put("0", "明细编号");
		columnOrder_Production.put("1", "生成单号");
		columnOrder_Production.put("2", "生产日期");
		KeywordsType_Production.put("0", "明细编号");
		KeywordsType_Production.put("1", "生成单号");
		
		columnOrder_ProductionReport.put("0", "明细编号");
		columnOrder_ProductionReport.put("1", "上报单号");
		columnOrder_ProductionReport.put("2", "上报日期");
		KeywordsType_ProductionReport.put("0", "明细编号");
		KeywordsType_ProductionReport.put("1", "上报单号");
		state_ProductionReport.put("0", "待审批");
		state_ProductionReport.put("1", "已审批");
		
		orderType.put("0", "升序");
		orderType.put("1", "降序");
		
		from.put("0", "云服务平台");
		from.put("1", "微信平台");
		from.put("2", "APP平台");
		
		recycleType.put("0", "机油");
		recycleType.put("1", "油桶");
		recycleType.put("2", "滤芯");
		
		
	}	
}

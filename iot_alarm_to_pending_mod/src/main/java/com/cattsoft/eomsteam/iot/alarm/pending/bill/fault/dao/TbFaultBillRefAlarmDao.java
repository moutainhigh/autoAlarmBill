package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.entity.TbFaultBillRefAlarmEntity;

public interface TbFaultBillRefAlarmDao {


	/***
	 * ����
	 * @return
	 */
	public Long getID() ;

	/***
	 * ���湤���б�
	 * @param tbFaultBillRefAlarmList
	 */
	public void save(List<TbFaultBillRefAlarmEntity> tbFaultBillRefAlarmList) ;
	
	
	public List<Map<String,Object>> queryBillRefAlarmId(String ids);
}

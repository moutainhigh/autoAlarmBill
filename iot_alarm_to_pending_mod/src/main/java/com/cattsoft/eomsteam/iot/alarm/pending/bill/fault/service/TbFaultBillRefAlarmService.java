package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.entity.TbFaultBillRefAlarmEntity;

public interface TbFaultBillRefAlarmService {

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
	
	public Map<Long,Long> queryBillRefAlarmId(String ids);
}

package com.cattsoft.eomsteam.iot.alarm.record.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.record.entity.TbAlarmRecordEntity;

public interface TbAlarmRecordService {
	

	/***
	 * �澯��¼
	 * @param I_REF_ID  ����ID
	 * @param S_DELIMITED_CYCLE ����
	 * @return
	 */
	public List<TbAlarmRecordEntity> getAlarmRecordListByRefId(Long I_REF_ID,String S_DELIMITED_CYCLE);

	/***
	 * ���ô���
	 * @param setIdList ID�б�
	 */
	public void  updateAlarmRecordSetPendingIdByRecordId(List<Map<String,Object>> setIdList);
	
	public void closedAlarmRecordByPendingId(List<Map<String, Object>> timeOutPendingList) ;
}

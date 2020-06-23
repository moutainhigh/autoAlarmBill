package com.cattsoft.eomsteam.iot.alarm.record.dao;

import java.util.List;
import java.util.Map;

public interface TbAlarmRecordDao {
	
	/***
	 * �澯��¼
	 * @param I_REF_ID  ����ID
	 * @param S_DELIMITED_CYCLE ����
	 * @return
	 */
	public List<Map<String, Object>> getAlarmRecordListByRefId(Long I_REF_ID,String S_DELIMITED_CYCLE);

	/***
	 * ���ô���
	 * @param setIdList ID�б�
	 */
	public void  updateAlarmRecordSetPendingIdByRecordId(List<Map<String,Object>> setIdList);
	
	public void closedAlarmRecordByPendingId(List<Map<String, Object>> timeOutPendingList) ;
}

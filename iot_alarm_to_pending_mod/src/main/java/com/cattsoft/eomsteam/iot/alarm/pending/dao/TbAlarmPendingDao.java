package com.cattsoft.eomsteam.iot.alarm.pending.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.entity.TbAlarmPendingEntity;

public interface TbAlarmPendingDao {
	
	public Long getID();
	
	/***
	 * 
	 * @param alarmPendingEntityList
	 */
	public void save(List<TbAlarmPendingEntity> alarmPendingEntityList);
	
	
	public List<Map<String, Object>> getAlarmPendingListByRefId(Long I_REF_ID,String S_DELIMITED_CYCLE);
	
	public void  updateAlarmZipCntByPendingId(List<Map<String,Object>> setIdList);
	
	/***
	 * ��ѯ��ʱ�޸澯����
	 * @param I_REF_ID
	 * @return
	 */
	public List<Map<String, Object>> getAlarmTimeOutPendingListByRefId(Long I_REF_ID) ;
	
	/***
	 * �رո澯����
	 * @param setIdList
	 */
	public void  updateAlarmPendingClosedByPendingId(List<Map<String,Object>> setIdList);
}

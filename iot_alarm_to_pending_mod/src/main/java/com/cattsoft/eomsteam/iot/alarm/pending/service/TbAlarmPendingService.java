package com.cattsoft.eomsteam.iot.alarm.pending.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.entity.TbAlarmPendingEntity;

public interface TbAlarmPendingService {

	public Long getID();
	
	/***
	 * ��������澯
	 * @param alarmPendingEntityList
	 */
	public void save(List<TbAlarmPendingEntity> alarmPendingEntityList);
	
	/***
	 * ��ѯ�Ƿ��и澯
	 * @param I_REF_ID
	 * @param S_DELIMITED_CYCLE
	 * @return
	 */
	public Map<String, Object> getAlarmPendingDataByRefId(Long I_REF_ID,String S_DELIMITED_CYCLE) ;
	
	/***
	 * �澯��������
	 * @param setIdList
	 */
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

package com.cattsoft.eomsteam.iot.alarm.record.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.record.entity.TbAlarmRecordEntity;

public interface TbAlarmRecordDao {
	
	/***
	 * ����
	 * @return
	 */
	public Long getID();
	
	public List<Map<String, Object>> getAlarmPendingListByRefId(Long I_REF_ID,String S_DELIMITED_CYCLE);

	/***
	 * ͳ��sql
	 * @param sql ִ��SQL
	 * @return
	 */
	public Map<String,Object> getAlarmPendingCount(String sql);
	
	/***
	 * ����sql
	 * @param sql ִ��SQ
	 * @return
	 */
	public List<Map<String,Object>> getAlarmPendingList(String sql);
	
	/***
	 * 
	 * @param delimitedPendingEntityList
	 */
	public void save(List<TbAlarmRecordEntity> delimitedPendingEntityList);
	
	/***
	 * ���¹鵵�������
	 * @param idInStr �ַ���
	 */
	public void  updateRunningAlarmPendingEndById(String idInStr);
	/***
	 * ���¹鵵�������
	 * @param   idInStr �ַ���
	 */
	public void  updateRunningAlarmPendingEndByIds(List<String>  idInStr);
}

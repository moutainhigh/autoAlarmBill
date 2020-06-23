package com.cattsoft.eomsteam.iot.alarm.log.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.log.entity.TbAlarmConfigLogEntity;

public interface TbAlarmConfigLogDao {

	/***
	 * ����������־
	 * @param tbAlarmConfigLogEntity ��־ʵ��
	 */
	public void save(TbAlarmConfigLogEntity tbAlarmConfigLogEntity);
	
	/***
	 * ����
	 * @return
	 */
	public List<Map<String,Object>> getAlarmConfigLogList();
	
	/***
	 * ��ѯ����
	 * @param I_REF_ID   ����ID
	 * @param S_INST_CYCLE ����
	 * @return
	 */
	public List<Map<String,Object>> getAlarmConfigLogByRefId(Long I_REF_ID,String S_INST_CYCLE);
	
	/***
	 * ����������־
	 * @param I_ID ����
	 */
	public void  updateAlarmConfigLogById(Long I_ID);
	
	/***
	 * 
	 * @param I_ID   ����
	 * @param I_PENDING_CNT ��������
	 * @param I_START_TIME  ��ʼʱ��
	 * @param I_END_TIME    ����ʱ��
	 */
	public void  updateRunningAlarmConfigLogById(Long I_ID,Long I_PENDING_CNT,Long I_START_TIME,Long I_END_TIME);
	
	
	/***
	 * �鵵������־
	 * @param I_ID ����
	 */
	public void  updateAlarmConfigLogEndFlagById(Long I_ID);
}

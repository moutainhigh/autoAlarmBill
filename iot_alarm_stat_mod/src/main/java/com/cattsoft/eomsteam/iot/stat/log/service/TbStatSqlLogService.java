package com.cattsoft.eomsteam.iot.stat.log.service;

import java.util.List;

import com.cattsoft.eomsteam.iot.stat.log.entity.TbStatSqlLogEntity;

/***
 * ������־�ӿڷ���
 * @author Administrator
 *
 */
public interface TbStatSqlLogService {

	/***
	 * ����������־
	 * @param tbAlarmConfigLogEntity ��־ʵ��
	 */
	public void save(TbStatSqlLogEntity tbAlarmConfigLogEntity);
	
	/***
	 * ����
	 * @return
	 */
	public List<TbStatSqlLogEntity> getAlarmConfigLogList();
	
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

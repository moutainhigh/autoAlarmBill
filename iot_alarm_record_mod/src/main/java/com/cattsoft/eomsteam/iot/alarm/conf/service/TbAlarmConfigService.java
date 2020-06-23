package com.cattsoft.eomsteam.iot.alarm.conf.service;

import java.util.List;

import com.cattsoft.eomsteam.iot.alarm.conf.entity.TbAlarmConfigEntity;

/***
 * �������
 * @author Administrator
 *
 */
public interface TbAlarmConfigService {

	/***
	 * ���������б�
	 * @return
	 */
	public List<TbAlarmConfigEntity> getAlarmConfigList();
	

	/***
	 * ��������
	 * @param I_ID ����
	 * @return
	 */
	public TbAlarmConfigEntity getAlarmConfigById(Long I_ID);
	
	/***
	 * ��������
	 * @param tbDelimitedConfigEntity ��������
	 * @param S_INST_CYCLE ����������
	 * @return
	 */
	public String getAlarmCountParentSql(TbAlarmConfigEntity tbDelimitedConfigEntity,String S_INST_CYCLE);
	
	/***
	 * ��������
	 * @param tbDelimitedConfigEntity ������
	 * @param S_INST_CYCLE ��������
	 * @return
	 */
	public String getAlarmPendingParentSql(TbAlarmConfigEntity tbDelimitedConfigEntity,String S_INST_CYCLE);
	
}

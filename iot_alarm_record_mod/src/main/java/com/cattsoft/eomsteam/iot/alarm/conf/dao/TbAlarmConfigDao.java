package com.cattsoft.eomsteam.iot.alarm.conf.dao;

import java.util.List;
import java.util.Map;


/***
 * ��������DAO
 * @author Administrator
 *
 */
public interface TbAlarmConfigDao {

	/***
	 * ���������б�
	 * @return
	 */
	public List<Map<String,Object>> getAlarmConfigList();
	
	public Map<String,Object> getAlarmConfigById(Long I_ID);
}

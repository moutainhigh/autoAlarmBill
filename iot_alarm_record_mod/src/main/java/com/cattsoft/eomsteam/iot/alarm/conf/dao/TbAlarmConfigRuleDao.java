package com.cattsoft.eomsteam.iot.alarm.conf.dao;

import java.util.List;
import java.util.Map;

/***
 * �������dao��
 * @author psy
 *
 */
public interface TbAlarmConfigRuleDao {

	/***
	 * ��������б�
	 * @return
	 */
	public List<Map<String,Object>> getAlarmConfigRuleList();
}

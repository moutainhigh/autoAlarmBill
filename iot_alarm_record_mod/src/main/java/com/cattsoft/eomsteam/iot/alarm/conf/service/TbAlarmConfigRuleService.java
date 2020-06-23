package com.cattsoft.eomsteam.iot.alarm.conf.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.conf.entity.TbAlarmConfigRuleEntity;

/***
 * ����������
 * @author Administrator
 *
 */
public interface TbAlarmConfigRuleService {

	/***
	 * ������������б�
	 * @return
	 */
	public Map<Long,List<TbAlarmConfigRuleEntity>> getAlarmConfigRuleData();
	
	/***
	 * ����
	 * @param delimitedConfigRuleEntityList �����б�
	 * @return
	 */
	public String getDelimitedConfigWhereSql(List<TbAlarmConfigRuleEntity> delimitedConfigRuleEntityList);
}

package com.cattsoft.eomsteam.iot.alarm.tbl.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.tbl.entity.TbAlarmTblQueryColEntity;

public interface TbAlarmTblQueryColService {

	/***
	 * ��ѯ���ö�
	 * @param I_OBJ_TYPE
	 * @param I_OBJ_ID
	 * @param I_CYCLE
	 * @param S_OBJ_TBL
	 * @return
	 */
	public  List<TbAlarmTblQueryColEntity> geAlarmTblQueryColList(Integer I_OBJ_TYPE ,Integer I_NE_MODEL,Integer I_LARGE_CLASS,Integer I_SMALL_CLASS ,Integer I_CYCLE,String S_OBJ_TBL);


	/***
	 * ��ѯ����������
	 * @param I_OBJ_TYPE
	 * @param I_OBJ_ID
	 * @param I_CYCLE
	 * @param S_OBJ_TBL
	 * @return
	 */
	public Map<String,String> getAlarmTblQueryColData(Integer I_OBJ_TYPE ,Integer I_NE_MODEL,Integer I_LARGE_CLASS,Integer I_SMALL_CLASS ,Integer I_CYCLE,String S_OBJ_TBL);
}

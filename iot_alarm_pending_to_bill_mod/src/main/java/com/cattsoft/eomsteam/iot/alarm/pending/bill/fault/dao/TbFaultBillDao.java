package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.entity.TbFaultBillEntity;

public interface TbFaultBillDao {

	/***
	 * ����
	 * @return
	 */
	public Long getID() ;

	/***
	 * ���湤���б�
	 * @param faultBillEntityList
	 */
	public void save(List<TbFaultBillEntity> faultBillEntityList) ;
	
	public List<Map<String, Object>> getCityFaultBillByInst(String S_INST_ID,String S_INST_NAME);
	
	public List<Map<String, Object>> getZipFaultBillByInst(String S_INST_ID, String S_INST_NAME,String CITY_CODE, String CITY_NAME);
	
	/***
	 * 
	 * @param S_INST_ID   ά��ID
	 * @param S_INST_NAME ά������
	 * @return
	 */
	public List<Map<String, Object>> getZipFaultBillByInst(String S_INST_ID,String S_INST_NAME);
	
	public void updateZipUpdateTimeById(List<Map<String,Object> > setIdList) ;
	
	public List<Map<String, Object>> getFaultBillByInst(String S_INST_ID, String S_INST_NAME, Integer I_LARGE_CLASS,Integer I_SMALL_CLASS) ;
}

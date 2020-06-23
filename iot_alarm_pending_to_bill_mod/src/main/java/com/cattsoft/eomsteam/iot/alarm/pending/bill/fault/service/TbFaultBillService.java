package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.entity.TbFaultBillEntity;

public interface TbFaultBillService {

	/***
	 * ����
	 * @return
	 */
	public Long getID() ;

	/***
	 * ���湤���б�
	 * @param tbFaultBillEntityList
	 */
	public void save(List<TbFaultBillEntity> tbFaultBillEntityList) ;
	
	public List<TbFaultBillEntity> getCityFaultBillByInst(String S_INST_ID,String S_INST_NAME);
	
	public List<TbFaultBillEntity>  getZipFaultBillByInst(String S_INST_ID, String S_INST_NAME,String CITY_CODE, String CITY_NAME);
	
	/***
	 * ѹ�������б�
	 * @param S_INST_ID
	 * @param S_INST_NAME
	 * @return
	 */
	public List<TbFaultBillEntity>  getZipFaultBillByInst(String S_INST_ID, String S_INST_NAME);
	
	public void updateZipUpdateTimeById(List<Map<String,Object> > setIdList) ;
	
	/***
	 * ��ѯָ���Ƿ�������;����
	 * @param S_INST_ID
	 * @param S_INST_NAME
	 * @param I_LARGE_CLASS
	 * @param I_SMALL_CLASS
	 * @return
	 */
	public List<TbFaultBillEntity>  getFaultBillByInst(String S_INST_ID, String S_INST_NAME,Integer I_LARGE_CLASS, Integer I_SMALL_CLASS);
}

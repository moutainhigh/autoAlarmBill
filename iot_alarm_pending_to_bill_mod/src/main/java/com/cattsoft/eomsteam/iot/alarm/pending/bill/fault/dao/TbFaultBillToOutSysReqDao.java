package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.dao;

import java.util.List;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.entity.TbFaultBillToOutSysReqEntity;

public interface TbFaultBillToOutSysReqDao {


	/***
	 * ����
	 * @return
	 */
	public Long getID() ;

	/***
	 * ���湤���б�
	 * @param tbFaultBillToOutSysReqList
	 */
	public void save(List<TbFaultBillToOutSysReqEntity> tbFaultBillToOutSysReqList) ;
}

package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.abs.AbsCellFaultBillBusiService;
import com.cattsoft.eomsteam.iot.alarm.pending.pending.entity.TbAlarmPendingEntity;
import com.cattsoft.eomsteam.iot.alarm.pending.pending.service.TbAlarmPendingService;

/***
 * һ�����ϲ�����
 * @author Administrator
 *
 */
@Service("com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.OneLevelCellPendingFaultBillBusiService") 
public class OneLevelCellPendingFaultBillBusiService extends AbsCellFaultBillBusiService {
	

    /**
     * ��־����
     */
    private static Logger logger = Logger.getLogger(ZipCellPendingFaultBillBusiService.class);
    
	@Autowired
	private TbAlarmPendingService tbAlarmPendingService;
	
	@Override
	public void doBusi() {
		// TODO Auto-generated method stub
	    List<TbAlarmPendingEntity> alarmPendingEntityList = tbAlarmPendingService.getAlarmPendingByCellOneLevel();
	    logger.info("һ��С���澯:"+alarmPendingEntityList.size());
	    this.doBusiNoZipData(alarmPendingEntityList);
	}
	
	
	/***
	 * �����Ƿ�ѹ��
	 * @return
	 */
	@Override
	protected  Integer  getI_ZIP_FLAG(){
		return 2;
	}
	
	
	/***
	 * 
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected String getMsg(List<TbAlarmPendingEntity> alarmPendingEntityList){
		StringBuffer msg = new StringBuffer();
		for(TbAlarmPendingEntity tbAlarmPendingEntity : alarmPendingEntityList){
			msg.append(tbAlarmPendingEntity.getS_MSG());
			msg.append("<br/>");
		}
		
		return msg.toString();
	}
	

	/***
	 * ͨ������
	 * @return
	 */
	protected String getTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		return tbAlarmPendingEntity.getS_TITLE();
	}
	
}

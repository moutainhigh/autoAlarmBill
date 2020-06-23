package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.impl;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.ZipPendingCommonBusiService;
import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.abs.AbsNotCellFaultBillBusiService;
import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.entity.TbFaultBillEntity;
import com.cattsoft.eomsteam.iot.alarm.pending.pending.entity.TbAlarmPendingEntity;
import com.cattsoft.eomsteam.iot.alarm.pending.pending.service.TbAlarmPendingService;
import com.cattsoft.eomsteam.uc.pub.db.DefaultStringUtil;

/***
 * ��ָ��澯�ϲ�����
 * @author Administrator
 *
 */
@Service("com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.ZipNotCellPendingFaultBillBusiService") 
public class ZipNotCellPendingFaultBillBusiService extends AbsNotCellFaultBillBusiService {
	
	@Autowired
	private ZipPendingCommonBusiService zipPendingCommonBusiService;
	
	 /**
     * ��־����
     */
    private static Logger logger = Logger.getLogger(ZipNotCellPendingFaultBillBusiService.class);

	@Autowired
	private TbAlarmPendingService tbAlarmPendingService;
	
	@Override
	public void doBusi() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> alarmPendingZipCntList = tbAlarmPendingService.getAlarmPendingNotCellZipCntList();
		logger.info("��С��ѹ���澯����:"+alarmPendingZipCntList.size());
		for(Map<String, Object> alarmPendingZipCntData :alarmPendingZipCntList){
			String S_INST_ID   = DefaultStringUtil.toString(alarmPendingZipCntData.get("S_INST_ID"));
			String S_INST_NAME = DefaultStringUtil.toString(alarmPendingZipCntData.get("S_INST_NAME"));
			this.doBusiZipData(S_INST_ID, S_INST_NAME);
		}
	}
	
	/***
	 * ʵ��ת������
	 * @param alarmPendingEntityList
	 * @return
	 */
	@Override
	protected TbFaultBillEntity getTbFaultBillEntity(List<TbAlarmPendingEntity> alarmPendingEntityList){
		TbAlarmPendingEntity tbAlarmPendingEntity = alarmPendingEntityList.get(0);
		TbFaultBillEntity tbFaultBillEntity = this.getFaultBillEntity(tbAlarmPendingEntity);
		tbFaultBillEntity.setI_ZIP_FLAG(this.getI_ZIP_FLAG());
		tbFaultBillEntity.setI_ZIP_CNT(alarmPendingEntityList.size());
		return tbFaultBillEntity;
	}
	
	/***
	 * �����Ƿ�ѹ��
	 * @return
	 */
	protected  Integer  getI_ZIP_FLAG(){
		return 1;
	}
	
	/***
	 * ���ض��켶��
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected  Integer  getI_DISPATCH_LEVEL(TbAlarmPendingEntity tbAlarmPendingEntity){
		return 1;
	}

	@Override
	protected String getMsg(List<TbAlarmPendingEntity> alarmPendingEntityList) {
		// TODO Auto-generated method stub
		return zipPendingCommonBusiService.getMsg(alarmPendingEntityList);
	}

	@Override
	protected String getTitle(TbAlarmPendingEntity tbAlarmPendingEntity) {
		// TODO Auto-generated method stub
		return zipPendingCommonBusiService.getTitle(tbAlarmPendingEntity);
	}
}

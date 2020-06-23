package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.ZipPendingCommonBusiService;
import com.cattsoft.eomsteam.iot.alarm.pending.pending.entity.TbAlarmPendingEntity;

@Service("com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.busi.ZipPendingCommonBusiService") 
public class ZipPendingCommonBusiServiceImpl implements ZipPendingCommonBusiService {

	/***
	 * 
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	@Override
	public String getMsg(List<TbAlarmPendingEntity> alarmPendingEntityList){
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
	@Override
	public String getTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		if(1 == tbAlarmPendingEntity.getI_OBJ_TYPE()){
			return this.getCityTitle(tbAlarmPendingEntity);
		}else if(2 == tbAlarmPendingEntity.getI_OBJ_TYPE()){
			return this.getTacTitle(tbAlarmPendingEntity);
		}else if(3 == tbAlarmPendingEntity.getI_OBJ_TYPE()){
			return this.getCellTitle(tbAlarmPendingEntity);
		}else if(4 == tbAlarmPendingEntity.getI_OBJ_TYPE()){
			return this.getNeTitle(tbAlarmPendingEntity);
		}else if(5 == tbAlarmPendingEntity.getI_OBJ_TYPE()){
			return this.getApnTitle(tbAlarmPendingEntity);
		}
		StringBuffer title = new StringBuffer();
		title.append("������ָ���ӻ�Ԥ��");
		return title.toString();
	}
	
	/***
	 * ͨ������
	 * @return
	 */
	protected String getCommonTitle(){
		StringBuffer title = new StringBuffer();
		title.append("������ָ���ӻ�Ԥ��");
		return title.toString();
	}

	/***
	 * 
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected String getCityTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		StringBuffer title = new StringBuffer();
		title.append(tbAlarmPendingEntity.getCITY_NAME()).append("����������ҵ��").append(getCommonTitle());
		return title.toString();
	}
	

	/***
	 * 
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected String getTacTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		StringBuffer title = new StringBuffer();
		title.append("TAC:").append(tbAlarmPendingEntity.getS_INST_NAME()).append("������ҵ��").append(getCommonTitle());
		return title.toString();
	}

	/***
	 * 
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected String getCellTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		StringBuffer title = new StringBuffer();
		title.append(tbAlarmPendingEntity.getCITY_NAME()).append("С��������ҵ��").append(getCommonTitle());
		return title.toString();
	}
	
	/***
	 * ��Ԫ������ҵ������ָ���ӻ�Ԥ��
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected String getNeTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		StringBuffer title = new StringBuffer();
		title.append(tbAlarmPendingEntity.getS_INST_NAME()).append("��Ԫ������ҵ��").append(getCommonTitle());
		return title.toString();
	}
	
	/***
	 * 
	 * @param tbAlarmPendingEntity
	 * @return
	 */
	protected String getApnTitle(TbAlarmPendingEntity tbAlarmPendingEntity){
		StringBuffer title = new StringBuffer();
		title.append("������APN:").append(tbAlarmPendingEntity.getS_INST_NAME()).append(getCommonTitle());
		return title.toString();
	}
	
}

package com.cattsoft.eomsteam.iot.alarm.pending.pending.service;

import java.util.List;
import java.util.Map;

import com.cattsoft.eomsteam.iot.alarm.pending.pending.entity.TbAlarmPendingEntity;


public interface TbAlarmPendingService {
	
	/***
	 * �����ɵ���־
	 * @param setIdList
	 */
	public void updateAlarmPendingDispatchFlag(List<Map<String,Object> > setIdList);
	
	/***
	 * ��ָ��ѹ������
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingNotCellZipCntList();
	
	/***
	 * ��ָ��ѹ������
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingCellZipCntList();
	
	/***
	 * ѹ���澯�б�
	 * @param S_INST_ID
	 * @param S_INST_NAME
	 * @return
	 */
	public List<TbAlarmPendingEntity> getAlarmPendingZipListByInst(String S_INST_ID,String S_INST_NAME);
	/***
	 * һ�������ɵ�
	 * @return
	 */
	public List<TbAlarmPendingEntity> getAlarmPendingByCellOneLevel();
	
	/***
	 * һ���ǵ����ɵ�
	 * @return
	 */
	public List<TbAlarmPendingEntity> getAlarmPendingByNotCellOneLevel();
	
	/***
	 * ���������ɵ�
	 * @return
	 */
	public List<TbAlarmPendingEntity> getAlarmPendingByCellTwoLevel();
	
	/***
	 * �����ǵ����ɵ�
	 * @return
	 */
	public List<TbAlarmPendingEntity> getAlarmPendingByNotCellTwoLevel();
	

}

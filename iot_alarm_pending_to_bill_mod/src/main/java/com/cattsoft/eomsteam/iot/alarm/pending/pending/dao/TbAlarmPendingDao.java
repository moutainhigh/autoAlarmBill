package com.cattsoft.eomsteam.iot.alarm.pending.pending.dao;

import java.util.List;
import java.util.Map;

public interface TbAlarmPendingDao {
	
	/***
	 * �����ɵ���־
	 * @param setIdList
	 */
	public void updateAlarmPendingDispatchFlag(List<Map<String,Object> > setIdList);
	
	/***
	 * ѹ���澯�б�
	 * @param S_INST_ID
	 * @param S_INST_NAME
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingZipListByInst(String S_INST_ID,String S_INST_NAME);
	
	/***
	 * ���ж�ָ��ѹ������
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingNotCellZipCntList();
	
	/***
	 * ���ж�ָ��ѹ������
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingCellZipCntList();
	
	/***
	 * һ�������ɵ�
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingByNotCellOneLevel();
	
	/***
	 * һ���ǵ����ɵ�
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingByCellOneLevel();
	
	/***
	 * ���������ɵ�
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingByCellTwoLevel();
	
	/***
	 * �����ǵ����ɵ�
	 * @return
	 */
	public List<Map<String, Object>> getAlarmPendingByNotCellTwoLevel();
}

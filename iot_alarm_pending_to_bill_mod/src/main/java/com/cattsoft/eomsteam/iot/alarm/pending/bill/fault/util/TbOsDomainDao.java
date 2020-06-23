package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util;

import java.util.List;
import java.util.Map;

/***
 * ����
 * @author pengshiyu
 *
 */
public interface TbOsDomainDao {

	/**
	 * getFtDomainCode : ��ѯ����
	 * @param sDomainName
	 * @return String(����)
	 */
	public String getDomainCodeByDomainName(String sDomainName);

	/***
	 * �����б�
	 * @return
	 */
	public List<Map<String,Object>> getDomainList();
	
	/**
	 * ������Id����������
	 * @param dataDomainId ��ID
	 * @return map
	 */
	public Map<String,String> getSCityName(Integer dataDomainId);
	
	/**
	 * getFtDomainCode : ��ѯ����
	 * @param iDomainId ö��1,2,3,4
	 * @return String(����)
	 */
	public String getDomainCode(String iDomainId);
	
	/**
	 * ������Ԫ�а���ID����������
	 * @param neUserId ��Ԫ�а���ID
	 * @return map
	 */
	public Map<String,String> getNeUserName(Integer neUserId);
}

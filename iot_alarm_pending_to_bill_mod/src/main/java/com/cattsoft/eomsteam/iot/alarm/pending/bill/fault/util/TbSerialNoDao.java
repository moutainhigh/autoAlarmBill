package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util;



/**
 * ���ݱ��Dao
 * 
 * @author lanxianghua
 * 
 * �޸�  luoshilong
    ��Ӹ�����ǰ׺����ȡ���ݱ��� ������getBillNoForDomain 
    �� �����-ǰ׺-����-��ˮ�� (GZ-YH-20160202-002)
 *  
 * 
 */
public interface TbSerialNoDao {


	/**
	 * ȡ�õ��ݱ��
	 * 
	 * @param type
	 * @param iDomainId
	 * @param sDomainName
	 * @return
	 */
	public String getBillNo(TbSerialNo.Type type, String iDomainId, String sDomainName);

	/**
	 * ��ȡ��ˮ��
	 * @param iType ��������
	 * @param iDomainId ��id
	 * @return String(��ˮ��)
	 */
	public String getSerialNo(String iType, String iDomainId);
	
	/**
	 * ��ȡǰ׺�Զ���ĵ��ݱ�ţ����������������Ϊǰ׺��
	 * @param type �������
	 * @param iDomainId ������
	 * @param dateFormat ��������
	 * @param  prefix �Զ���ǰ׺
	 * @return ���ݱ��
	 */
	public String getBillNo(TbSerialNo.Type type, String iDomainId, String dateFormat, String prefix);

}

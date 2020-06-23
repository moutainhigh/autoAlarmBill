package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util;

/**
 * ����ö��
 * @author liaoxiaojin
 *
 */
public enum DomainEnum {
	
	/**
	 * ʡ��˾
	 */
	NOC(1030005L, "ʡ��˾");
	
	/**
	 * value
	 */
	private Long value;

	/**
	 *name 
	 */
	private String name;
	
	/**
	 * ö��
	 * @param value ֵ
	 * @param name  ����
	 */
	DomainEnum(Long value, String name){
		this.value = value;
		this.name = name;
	}
	
	/**
	 * ȡֵ
	 * @return
	 */
	public Long getValue() {
		return this.value;
	}

	/**
	 * ȡ��������
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}

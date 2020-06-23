package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util;

import java.io.Serializable;



public class TbSerialNo implements Serializable {

	/**
	 * ϵ��
	 */
	private static final long serialVersionUID = 8765621485162121904L;

	
	public enum Type {
		/**
		 * ģ��
		 */
		DEF_TPL(2000, "ģ��"),
//
//		/**��Դ��������*/
//		RESOURCECORREC(2001,"��Դ��������"),
//		/**�ʺŹ�������*/
//		REGISTERACCOUNT(4001,"�ʺŹ�������"),
//
//		/**��ҵ�ƻ�����ִ��*/
//		TASKPLAN(3001,"��ҵ����ִ������");
		/**��������*/
		ARALM(2001,"�澯�ɵ�");

		private Integer value;

		private String name;

		Type(Integer value, String name) {
			this.value = value;
			this.name = name;
		}

		/**
		 * ȡö��
		 * @param value
		 * @return
		 */
		public static Type getEnum(Integer value) {
			Type[] types = Type.values();
			for (int i = 0; i < types.length; i++) {
				if (types[i].getValue().equals(value)) {
					return types[i];
				}
			}
			return DEF_TPL;
		}

		/**
		 * 
		 * ȡkey
		 * @return
		 */
		public Integer getValue() {
			return this.value;
		}

		/**
		 * 
		 * ȡvalue
		 * @return
		 */
		public String getName() {
			return this.name;
		}
	}


}

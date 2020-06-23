package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.impl;


import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.TbOsDomainDao;
import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.TbSerialNo;
import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.TbSerialNoDao;
import com.cattsoft.eomsteam.uc.pub.db.uc_main2.dao.UCMainDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.DateUtil;
import util.StringUtil;

import java.util.*;

/**
 * TbSerialNoDaoImpl : ����ģ�鵥�ݱ��������
 * @author lanxianghua
 * 
 * �޸�  luoshilong
    ��Ӹ�����ǰ׺����ȡ���ݱ��� ������getBillNoForDomain 
    �� �����-ǰ׺-����-��ˮ�� (GZ-YH-20160202-002)
 *
 */
@Repository("com.catt.data.dao.app.dzywSite.pub.impl.TbSerialNoDaoImpl")
public class TbSerialNoDaoImpl extends UCMainDao implements TbSerialNoDao {

	/**
	 * ע����Dao
	 * */
	@Autowired
	private TbOsDomainDao tbOsDomainDao;

	/** 
	 * ���log��־
	 */
	private static Log log = LogFactory.getLog(TbSerialNoDaoImpl.class);
	
	/**
	 * getBillNo : (��������)���ݲ�ͬ�Ĺ������࣬���ɲ�ͬ�ĵ��ݱ��
	 * @param type ��������ö��
	 * @param iDomainId ��id
	 * @return String
	 */
	@Override
	public String getBillNo(TbSerialNo.Type type, String iDomainId, String sDomainName) {
		String sDomainCode = tbOsDomainDao.getDomainCodeByDomainName(sDomainName);
		String sDate       = getYearMonthDay();
		String sSerialNo   = getSerialNo(String.valueOf(type.getValue()), iDomainId);
		String prefix = "";
		if(StringUtil.checkStr(sDomainCode)){
			prefix = sDomainCode + "-";
		}
		String sDzywCode  = prefix + sDate + "-" + sSerialNo;
		return sDzywCode;
	}
	
	/**
	 * ��ȡǰ׺�Զ���ĵ��ݱ�ţ����������������Ϊǰ׺��
	 * @param type �������
	 * @param iDomainId ������
	 * @param dateFormat ��������
	 * @param  prefix �Զ���ǰ׺
	 * @return ���ݱ��
	 */
	@Override
	public String getBillNo(TbSerialNo.Type type, String iDomainId, String dateFormat, String prefix){
		if(!StringUtil.checkStr(dateFormat)){
			dateFormat = "yyyyMMdd";
		}
		String sDate = DateUtil.parseToString(new Date(), dateFormat);
		String sSerialNo = getSerialNo(String.valueOf(type.getValue()), iDomainId);
		if (prefix == null || "".equals(prefix) || "null".equals(prefix)) {
			prefix = prefix + "-";
		}
		String billNo = prefix  + sDate + "-" + sSerialNo;
		return billNo;
	}
	
	/**
	 * getYearMonthDay : ȡ��������
	 * @return (String)����������
	 */
	public String getYearMonthDay(){
		Calendar cal =  Calendar.getInstance();
		int int_m    =  cal.get(Calendar.MONTH) + 1;
		int int_d    =  cal.get(Calendar.DATE);
		String month =  cal.get(Calendar.MONTH) + 1 + "";
		String day   =  cal.get(Calendar.DATE)  + "";
		String year  =  cal.get(Calendar.YEAR) + "";
		//�·�����10,ǰ��Ҫ��0
		if(int_m < 10){
			month = "0" + (cal.get(Calendar.MONTH) + 1);
		}
		//��������10,ǰ��Ҫ��0
		if(int_d < 10){
			day   = "0" + cal.get(Calendar.DATE) ;
		}
		String currentDate = year + month + day;
		return currentDate;
	}
	
	/**
	 * ��ȡ��ˮ��
	 * @param iType ��������
	 * @param iDomainId ��id
	 * @return String(��ˮ��)
	 */
	@Override
	public String getSerialNo(String iType, String iDomainId){
		String sSerialNo = "";
		if(StringUtil.checkStr(iDomainId) && StringUtil.checkStr(iType)){
 			String currDate    = "'" + DateUtil.getNowTime("yyyy-MM-dd") + "'";    				   			//��ʽ����ǰ���ڷ���
			String dDate       = datetimeTostring("DDATE","yyyy-MM-dd");                        //TbSerialNo���DDATE�ֶ�
			StringBuffer upSql = new StringBuffer();
			upSql.append(" update TBSERIALNO set ISERIALNO = ISERIALNO + 1 ");
			upSql.append(" where ");
			upSql.append(" IDOMAINID = ").append(iDomainId);
			upSql.append(" and ITYPE = ").append(iType);
			upSql.append(" and DDATE = ").append("TO_DATE("+currDate+",'YYYY-MM-DD')");
			String sUpdateSql = upSql.toString();
			int count = this.updateBySql(sUpdateSql);
			if(count <= 0){
				//����
				String iId = this.callIdGenratorProc2("TBSERIALNO", this.getDomain());
				StringBuffer insertSql = new StringBuffer();
				sSerialNo = "1";
				String dNowDate = getDate();  							//��ȡ��ǰ��������
				insertSql.append(" insert into TBSERIALNO(ISERIALNOID,IDOMAINID,DDATE,ITYPE,ISERIALNO)values(");
				insertSql.append(iId).append(",");
				insertSql.append(iDomainId).append(",");
				insertSql.append(dNowDate).append(",");
				insertSql.append(iType).append(",");
				insertSql.append(sSerialNo).append(")");  //Ĭ����ˮ��Ϊ1
				String sInsertSql = insertSql.toString();
				this.updateBySql(sInsertSql);
			}else{
				//��ѯ
				List<Map<String, String>> rsList = new ArrayList<Map<String,String>>();
				StringBuffer selectSql = new StringBuffer();
				selectSql.append(" select tb.ISERIALNOID,tb.ISERIALNO from TBSERIALNO tb ");
				selectSql.append(" where 1=1 ");
				selectSql.append(" and tb.ITYPE = ").append(iType);
				selectSql.append(" and tb.IDOMAINID = ").append(iDomainId);
				selectSql.append(" and DDATE = ").append("TO_DATE("+currDate+",'YYYY-MM-DD')");
				String sSelectSql = selectSql.toString();
				rsList = this.queryBySql(sSelectSql);
				//�����ϴ���0
				if(rsList.size() > 0){
					Map<String, String> tempMap = rsList.get(0);
					if(StringUtil.checkObj(tempMap)){
						sSerialNo = StringUtil.toString(tempMap.get("ISERIALNO"));
					}
				}
			}
			//��ˮ�Ÿ�ʽ��
			sSerialNo = formatSerialNo(sSerialNo);
			System.out.println("��ˮ����"+sSerialNo);
		}
		return sSerialNo;
	}

	public String getDate() {
		return "TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'YYYY-MM-DD')";
	}

	public String datetimeTostring(String col, String format) {
		if (StringUtil.checkStr(format)) {
			if("yyyy-MM-dd".equals(format))
				format = "%Y-%m-%d";
			else if ("yyyy-MM".equals(format)) {
				format = "%Y-%m";
			}else if ("HH:mm:ss".equals(format)){
				format = "%H:%i:%s";
			}else if("MM-dd".equals(format)){
				format = "%m-%d";
			}else if("HH:mm".equals(format)){
				format = "%H:%i";
			}else if("mm:ss".equals(format)){
				format = "%i:%s";
			}else if("yyyy".equals(format)){
				format = "%Y";
			}else if("MM".equals(format)){
				format = "%m";
			}else if("dd".equals(format)){
				format = "%d";
			}else if("HH".equals(format)){
				format = "%H";
			}else if("mm".equals(format)){
				format = "%i";
			}else if("ss".equals(format)){
				format = "%s";
			}else if("yyyy-MM-dd HH:mm:ss.ms".equals(format)){
				format = "%Y-%m-%d %H:%i:%s.%f";
			}else{
				format = "%Y-%m-%d %H:%i:%s";
			}
		}else {
			format = "%Y-%m-%d %H:%i:%s";
		}
		//return "DATE_FORMAT(" + col + ", '" + format + "')";
		return "TO_DATE(" + col + ", '" + format + "')";
	}
	
	/**
	 * formatSerialNo : ��ʽ����ˮ��
	 * @param sSerialNo ��ˮ��
	 * @return String
	 */
	public String formatSerialNo(String sSerialNo){
		String sDecimalSerialNo = "";
		if(StringUtil.checkStr(sSerialNo)){
			if(sSerialNo.length() == 1){
				sDecimalSerialNo = "000" + sSerialNo;
			}else if(sSerialNo.length() == 2){
				sDecimalSerialNo = "00" + sSerialNo;
			}else if(sSerialNo.length() == 3){
				sDecimalSerialNo = "0" + sSerialNo;
			}else{
				sDecimalSerialNo = sSerialNo;
			}
		}else{
			sDecimalSerialNo = "0001";
		}
		return sDecimalSerialNo;
	}


	/***
	 * ȡ��������
	 * @return
	 */


	/***
	 * ɾ��������
	 * @param pkId ����
	 * @return
	 */


	/***
	 * ��ѯ����
	 * @param pkId ����
	 * @return
	 */

	/***
	 * ��ҳ��ѯ
	 * @param paramData ��ѯ����
	 * @return
	 */

}
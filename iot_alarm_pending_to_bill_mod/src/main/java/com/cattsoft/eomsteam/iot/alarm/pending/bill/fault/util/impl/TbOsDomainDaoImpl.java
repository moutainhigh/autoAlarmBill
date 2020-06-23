package com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.impl;


import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.DomainEnum;
import com.cattsoft.eomsteam.iot.alarm.pending.bill.fault.util.TbOsDomainDao;
import com.cattsoft.eomsteam.uc.pub.db.uc_main2.dao.UCMainDao;
import org.springframework.stereotype.Repository;
import util.StringUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * �����б�ʵ��
 * @author pengshiyu
 *
 */
@Repository("com.cattsoft.eomsteam.zhdw.web.zhdw.pub.dao.impl.TbOsDomainDaoImpl")
public class TbOsDomainDaoImpl extends UCMainDao implements TbOsDomainDao {
	/**
	 * ����һ����������Map<key(��id),value(����)>
	 */
	private static Map<String,String> prefixFtCodeMap;

	/**
	 * getFtDomainCode : ��ѯ����
	 *
	 * @param sDomainName
	 * @return String(����)
	 */
	@Override
	public String getDomainCodeByDomainName(String sDomainName) {
		String sDomainCode = "";
		StringBuffer sbSql = new StringBuffer();
		List<Map<String, String>> ls = new ArrayList<Map<String,String>>();
		sbSql.append(" select a.SDOMAINNAME,a.SDOMAINCODE from TBOSDOMAIN a ");
		String sql = sbSql.toString();
		ls = this.queryBySql(sql);
		if(ls.size() > 0){
			prefixFtCodeMap = new HashMap<String, String>();
			for(Map<String, String> tempMap : ls){
				prefixFtCodeMap.put(tempMap.get("SDOMAINNAME"), tempMap.get("SDOMAINCODE"));
			}
			sDomainCode = prefixFtCodeMap.get(sDomainName.replaceAll("��", ""));
		}
		return sDomainCode;
	}

	@Override
	public List<Map<String,Object>> getDomainList(){
		StringBuffer sbSql = new StringBuffer();
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		sbSql.append(" select a.IDOMAINID as \"iDomainId\",a.SDOMAINNAME as \"sDomainName\" from TBOSDOMAIN a order by ISORT ");
		String sql = sbSql.toString();
	    ls = this.queryBySql(sql);
	    return ls;
	}
	
	/**
	 * getFtDomainCode : ��ѯ����
	 * @param iDomainId ö��1,2,3,4
	 * @return String(����)
	 */
	@Override
	public String getDomainCode(String iDomainId ){
		String sDomainCode = "";
		if(StringUtil.checkStr(iDomainId)){
			if(StringUtil.toString(DomainEnum.NOC.getValue()).equals(iDomainId)){
				return "HNNOC";
			}
			if(StringUtil.checkObj(prefixFtCodeMap)){
				sDomainCode = prefixFtCodeMap.get(iDomainId);
			}else{
				StringBuffer sbSql = new StringBuffer();
				List<Map<String, String>> ls = new ArrayList<Map<String,String>>();
				sbSql.append(" select a.IDOMAINID,a.SDOMAINCODE from TBOSDOMAIN a ");
				String sql = sbSql.toString();
			    ls = this.queryBySql(sql);
				if(ls.size() > 0){
					prefixFtCodeMap = new HashMap<String, String>();
					for(Map<String, String> tempMap : ls){
						prefixFtCodeMap.put(tempMap.get("IDOMAINID"), tempMap.get("SDOMAINCODE"));
					}
					sDomainCode = prefixFtCodeMap.get(iDomainId);
				}
			}
		}
				return sDomainCode;
	}

	@Override
	public Map<String,String> getSCityName(Integer dataDomainId){
		StringBuffer sbSql = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
		sbSql.append(" select a.SDOMAINNAME as \"sDomainName\" from TBOSDOMAIN a where a.IDOMAINID = ").append(dataDomainId);
		String sql = sbSql.toString();
	    ls = this.queryBySql(sql);
	    if(ls !=null && ls.size() > 0){
			map = ls.get(0);
		}
	    return map;
	}

	@Override
	public Map<String,String> getNeUserName(Integer neUserId){
		StringBuffer sbSql = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
		sbSql.append(" select a.SSTAFFNAME as \"sStaffName\" from TBOSSTAFF a where a.ISTAFFID = ").append(neUserId);
		String sql = sbSql.toString();
	    ls = this.queryBySql(sql);
	    if(ls !=null && ls.size() > 0){
			map = ls.get(0);
		}
	    return map;
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

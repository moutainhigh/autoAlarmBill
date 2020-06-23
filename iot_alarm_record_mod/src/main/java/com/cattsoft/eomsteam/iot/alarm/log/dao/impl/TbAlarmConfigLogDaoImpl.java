package com.cattsoft.eomsteam.iot.alarm.log.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cattsoft.eomsteam.iot.alarm.log.dao.TbAlarmConfigLogDao;
import com.cattsoft.eomsteam.iot.alarm.log.entity.TbAlarmConfigLogEntity;
import com.cattsoft.eomsteam.uc.pub.db.DefaultStringUtil;
import com.cattsoft.eomsteam.uc.pub.db.uc_main2.dao.UCMainDao;

@Repository("com.cattsoft.eomsteam.iot.alarm.log.dao.TbAlarmConfigLogDao")
public class TbAlarmConfigLogDaoImpl  extends UCMainDao  implements TbAlarmConfigLogDao {

	@Override
	public void save(TbAlarmConfigLogEntity tbDelimitedConfigLogEntity){
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into TB_ALARM_CONFIG_LOG ");
		sql.append("   (I_ID,I_REF_ID,I_CYCLE,I_FLAG,I_CREATE_TIME,S_INST_CYCLE,I_RUN_CNT,I_OBJ_TYPE)");
		sql.append(" values(?,?,?,?,?,?,?,?) ");
		List<Object> data = new ArrayList<Object>();
		data.add(this.callIdGenratorProc2("TB_ALARM_CONFIG_LOG"));
		data.add(tbDelimitedConfigLogEntity.getI_REF_ID());
		data.add(tbDelimitedConfigLogEntity.getI_CYCLE());
		data.add(tbDelimitedConfigLogEntity.getI_FLAG());
		data.add(tbDelimitedConfigLogEntity.getI_CREATE_TIME());
		data.add(tbDelimitedConfigLogEntity.getS_INST_CYCLE());
		data.add(tbDelimitedConfigLogEntity.getI_RUN_CNT());
		data.add(tbDelimitedConfigLogEntity.getI_OBJ_TYPE());
		this.updateByPrepareStatement(sql.toString(), data, this.getDomain());
	}
	
	@Override
	public List<Map<String,Object>> getAlarmConfigLogByRefId(Long I_REF_ID,String S_INST_CYCLE){
		StringBuffer sql = new StringBuffer();
		sql.append(" select  ");
		sql.append("   I_ID        as \"I_ID\"      ,I_OBJ_TYPE     as \"I_OBJ_TYPE\"");
		sql.append("  ,I_REF_ID    as \"I_REF_ID\"  ,I_CYCLE        as \"I_CYCLE\"");
		sql.append("  ,I_FLAG      as \"I_FLAG\"    ,S_INST_CYCLE   as \"S_INST_CYCLE\"");
		sql.append("  ,I_RUN_CNT   as \"I_RUN_CNT\" ,I_PENDING_CNT  as \"I_PENDING_CNT\"");
		sql.append("  ,I_CREATE_TIME as \"I_CREATE_TIME\"");
		sql.append(" from  TB_ALARM_CONFIG_LOG ");
		sql.append(" where I_REF_ID  = ? and S_INST_CYCLE = ?");
		List<Object> data = new ArrayList<Object>();
		data.add(I_REF_ID);
		data.add(S_INST_CYCLE);
		List<Map<String,Object>> tempResultList =  this.queryBySql(sql.toString(), data);
		return tempResultList;
	}
	
	@Override
	public List<Map<String,Object>> getAlarmConfigLogList(){
		StringBuffer sql = new StringBuffer();
		sql.append(" select  ");
		sql.append("   I_ID        as \"I_ID\"      ,I_OBJ_TYPE     as \"I_OBJ_TYPE\"");
		sql.append("  ,I_REF_ID    as \"I_REF_ID\"  ,I_CYCLE        as \"I_CYCLE\"");
		sql.append("  ,I_FLAG      as \"I_FLAG\"    ,S_INST_CYCLE   as \"S_INST_CYCLE\"");
		sql.append("  ,I_RUN_CNT   as \"I_RUN_CNT\" ,I_PENDING_CNT  as \"I_PENDING_CNT\"");
		sql.append("  ,I_CREATE_TIME as \"I_CREATE_TIME\"");
		sql.append(" from  TB_ALARM_CONFIG_LOG ");
		sql.append(" where I_FLAG  = 1");
		sql.append(" order by S_INST_CYCLE desc,I_RUN_CNT asc,I_OBJ_TYPE asc ");
		List<Object> data = new ArrayList<Object>();
		List<Map<String,Object>> tempResultList =  this.queryBySql(sql.toString(), data);
		return tempResultList;
	}
	

	@Override
	public void  updateAlarmConfigLogById(Long I_ID){
		StringBuffer sql = new StringBuffer();
		sql.append(" update  TB_ALARM_CONFIG_LOG ");
		sql.append(" set I_RUN_CNT = I_RUN_CNT + 1 ");
		sql.append(" where I_ID  = ? ");
		List<Object> data = new ArrayList<Object>();
		data.add(I_ID);
		this.updateByPrepareStatement(sql.toString(), data, this.getDomain());
	}
	
	@Override
	public void  updateRunningAlarmConfigLogById(Long I_ID,Long I_PENDING_CNT,Long I_START_TIME,Long I_END_TIME){
		StringBuffer sql = new StringBuffer();
		sql.append(" update  TB_ALARM_CONFIG_LOG ");
		sql.append(" set I_PENDING_CNT = ?,I_START_TIME=?,I_END_TIME=?,I_TIME_GO =? ");
		sql.append(" where I_ID  = ? ");
		List<Object> data = new ArrayList<Object>();
		data.add(I_PENDING_CNT);
		data.add(I_START_TIME);
		data.add(I_END_TIME);
		long ms = DefaultStringUtil.getTwoTimeDayHourMS(""+I_START_TIME, ""+I_END_TIME,"yyyyMMddHHmmss");
		data.add(ms/60);
		data.add(I_ID);
		this.updateByPrepareStatement(sql.toString(), data, this.getDomain());
	}
	
	@Override
	public void  updateAlarmConfigLogEndFlagById(Long I_ID){
		StringBuffer sql = new StringBuffer();
		sql.append(" update  TB_ALARM_CONFIG_LOG ");
		sql.append(" set I_FLAG = 2 ,I_FINISH_TIME=?");
		sql.append(" where I_ID  = ? ");
		List<Object> data = new ArrayList<Object>();
		data.add(DefaultStringUtil.getNowTime("yyyyMMddHHmmss"));
		data.add(I_ID);
		this.updateByPrepareStatement(sql.toString(), data, this.getDomain());
	}
}

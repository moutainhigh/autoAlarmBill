package util.app.backstage.local.iot.alarm.pending.main;


import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.eomsteam.iot.alarm.exec.AlarmToPendingRunningService;
import com.cattsoft.eomsteam.mtoppub.ssh3InitUtil.CattApplicationContextUtil;
import com.cattsoft.eomsteam.mtoppub.ssh3InitUtil.ConfigService;
import com.cattsoft.eomsteam.uc.pub.db.DefaultStringUtil;

import util.DateUtil;

/***
 * 
 * @author psy 主入口
 *
 */
public class AlarmToPendingMain {

	/**
	 * 日志对象
	 */
	private static Log logger = null;
	
	/***
	 * 公共入库参数
	 */
	public static String[] mainArgs = null;

	/**
	 * 启动函数
	 * 
	 * @param args
	 *            启动参数
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		logger = initLog(args,AlarmToPendingMain.class);
		logger.info("执行目录扫描自动扫描"+System.getProperty("user.dir"));
		mainArgs = args;
		init();
		run();
	}

	/**
	 * 初始化
	 */
	public static void init() {
		ConfigService.initProperties(null);
	}

	/**
	 * 运行
	 */
	public static void run() {
		AlarmToPendingRunningService alarmToPendingRunningService = (AlarmToPendingRunningService)CattApplicationContextUtil.getBean("com.cattsoft.eomsteam.iot.alarm.exec.AlarmToPendingRunningService");
		while (true) {
			exec(alarmToPendingRunningService);
			sleep();
		}
	}

	/**
	 * 同步单据状态
	 * @param alarmToPendingRunningService 
	 */
	public static void exec(AlarmToPendingRunningService alarmToPendingRunningService) {
		try {
			String startTime = DateUtil.getNowTime();
			alarmToPendingRunningService.doPending();
			String endTime = DateUtil.getNowTime();
			logger.info("结束执行目录扫描,开始时间:"+ startTime + ",结束时间:" + endTime + ",耗时:" + (DateUtil.getTwoTimeDayHourMin(startTime, endTime) == "" ? "0": DateUtil.getTwoTimeDayHourMin(startTime, endTime)));
		} catch (Exception e) {
			logger.error("结束执行目录扫描日志服务异常", e);
		}
	}

	/**
	 * 休眠
	 */
	public static void sleep() {
		try {
			Long time = Long.valueOf(ConfigService.getPropertiyByKey("sleep", "600"));
			logger.info("执行目录扫描日志服务休眠:" + time+ "秒");
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			logger.error("执行目录扫描日志服务异常", e);
		}
	}
	
	/***
	 * 初始化日志
	 * @param args 参数
	 * @param clazz 类
	 * @return
	 */
	private static Log initLog(String[] args, Class clazz) {
		String lsClient = "alarmPending";
		if(args.length >0){
			if(DefaultStringUtil.isNotNull(args[0])){
				 lsClient = args[0];
			}
		}
		System.setProperty("alarmPending",lsClient);
		return LogFactory.getLog(clazz);
	}

}

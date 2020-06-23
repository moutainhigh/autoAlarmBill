package util.app.backstage.local.iot.alarm.pending.bill.main;


import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.eomsteam.iot.alarm.pending.bill.exec.AlarmPendingToFaultBillRunningService;
import com.cattsoft.eomsteam.mtoppub.ssh3InitUtil.CattApplicationContextUtil;
import com.cattsoft.eomsteam.mtoppub.ssh3InitUtil.ConfigService;
import com.cattsoft.eomsteam.uc.pub.db.DefaultStringUtil;

import util.DateUtil;

/***
 * 
 * @author psy �����
 *
 */
public class AlarmPendingToBillMain {

	/**
	 * ��־����
	 */
	private static Log logger = null;
	
	/***
	 * ����������
	 */
	public static String[] mainArgs = null;

	/**
	 * ��������
	 * 
	 * @param args
	 *            ��������
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		logger = initLog(args,AlarmPendingToBillMain.class);
		logger.info("ִ��Ŀ¼ɨ���Զ�ɨ��"+System.getProperty("user.dir"));
		mainArgs = args;
		init();
		run();
	}

	/**
	 * ��ʼ��
	 */
	public static void init() {
		ConfigService.initProperties(null);
	}

	/**
	 * ����
	 */
	public static void run() {
		AlarmPendingToFaultBillRunningService alarmPendingToFaultBillRunningService = (AlarmPendingToFaultBillRunningService)CattApplicationContextUtil.getBean("com.cattsoft.eomsteam.iot.alarm.pending.bill.exec.AlarmPendingToFaultBillRunningService");
		while (true) {
			exec(alarmPendingToFaultBillRunningService);
			sleep();
		}
	}

	/**
	 * ͬ������״̬
	 * @param alarmPendingToFaultBillRunningService 
	 */
	public static void exec(AlarmPendingToFaultBillRunningService alarmPendingToFaultBillRunningService) {
		try {
			String startTime = DateUtil.getNowTime();
			alarmPendingToFaultBillRunningService.doPending();
			String endTime = DateUtil.getNowTime();
			logger.info("����ִ��Ŀ¼ɨ��,��ʼʱ��:"+ startTime + ",����ʱ��:" + endTime + ",��ʱ:" + (DateUtil.getTwoTimeDayHourMin(startTime, endTime) == "" ? "0": DateUtil.getTwoTimeDayHourMin(startTime, endTime)));
		} catch (Exception e) {
			logger.error("����ִ��Ŀ¼ɨ����־�����쳣", e);
		}
	}

	/**
	 * ����
	 */
	public static void sleep() {
		try {
			Long time = Long.valueOf(ConfigService.getPropertiyByKey("sleep", "600"));
			logger.info("ִ��Ŀ¼ɨ����־��������:" + time+ "��");
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			logger.error("ִ��Ŀ¼ɨ����־�����쳣", e);
		}
	}
	
	/***
	 * ��ʼ����־
	 * @param args ����
	 * @param clazz ��
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

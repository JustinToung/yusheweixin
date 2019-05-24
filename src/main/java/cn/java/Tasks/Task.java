package cn.java.Tasks;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 定时器
 * @author zxc
 *
 */
@Component
public class Task {
	//每隔1秒打印一次时间
	//@Scheduled(fixedRate=1000)
	//@Scheduled(cron="20 18 16 * * *")
	public void task1() {
		Date ad=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(ad));
	}

}

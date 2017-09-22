package com.qiaodan.smartball.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.qiaodan.smartball.model.s_moveWithBLOBs;
import com.qiaodan.smartball.pullUtils.PullHex;
import com.qiaodan.smartball.pullUtils.Utils;
import com.qiaodan.smartball.service.MoveServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class Test {
	private static final Logger logger = Logger.getLogger(Test.class);
	
	private MoveServiceI moveService;
	
		
		
		
		
		public MoveServiceI getMoveService() {
			return moveService;
		}
		@Autowired
		public void setMoveService(MoveServiceI moveService) {
			this.moveService = moveService;
		}

		/*@org.junit.Test
		public void login() {
			User u = userService.login();
			logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
		}
		@org.junit.Test
		public void register(){
			String mobile = "2222222";
			String password = "000000";
			User user = new User();
			user.setuPhone(mobile);
			user.setuPassword(password);
			int count = userService.addUser(user);
			System.out.println("count="+count);
		}
		@org.junit.Test
		public void forgetPw(){
			String mobile = "2222222";
			String password = "111111";
			
			int count = userService.updatePwd(mobile,password);
			System.out.println("forgetPw count="+count);
		}
		
		@org.junit.Test
		public void getFriends(){
			List<User> users = userService.getFriendList("1");
			System.err.println("=========================="+users.size());
		}
		*/
		@org.junit.Test
		public void getMovesForUserMobile(){
			/*
			 * 18300003341 小丁账号 李辉：13600156266  延陵 15201797527   陈晶 15980451184
			 * moto测试号 18320812086
			 */
			String mobile = "15201797527";
			String timeLike = "09-12";
			//Utils.makeFileForMoble(this.getClass(),mobile);
			List<s_moveWithBLOBs> moves = moveService.getMoveListForUserMobileAndTime(mobile,timeLike);
			//List<s_moveWithBLOBs> moves = moveService.getMoveListForUserMobile(mobile);
			//List<s_moveWithBLOBs> moves = moveService.getMoveListForUserMobile(mobile);
			
			if (! (moves == null || moves.size() <= 0)) {
				for (s_moveWithBLOBs move : moves) {
					System.err.println("-----------------begin--------------");
					Date beginTime = move.getBeginTime();
					String header = move.getHeader();
					String trail = move.getTrail();
					String jump = move.getVerJumpPoint();
					
					System.out.println("beginTime : "+Utils.simpDate(beginTime));
					System.out.println("header : " + header);
					if (header != null){
						PullHex.header(header);
					}
					if (jump != null){
						PullHex.pullDatabaseJumpData(jump);
					}
					if (trail != null){
						PullHex.pullTrak(trail);
					}
					System.err.println("-----------------end--------------");
				}
			}
		}
		
		
}

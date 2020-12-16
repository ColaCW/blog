package com.lgq.common.webSocket;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/WebSocket")
@CrossOrigin(allowCredentials="true",origins = "*",maxAge = 3600)
public class WebSocketController {

	@RequestMapping(value = "/test.do")
	public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		try {
			Thread thread = new MyThread();
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


// 通过继承Thread类 来重写run方法
class MyThread extends Thread {

	//通过正则式来设置输出的时间格式
	SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");

	//重写run()方法
	public void run() {
		while (true) {
			try {
				WebSocketUtil.sendInfo(s.format(new Date()), null);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				//间隔时间1秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

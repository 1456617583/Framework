package demo.a_hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {
	@Test
	public void test() throws Exception {
		//����spring����
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo/a_hello/applicationContext.xml");
		//��������ȡ���ֽ�u�Ķ���
		User u=(User) ctx.getBean("u");

		
	}

}
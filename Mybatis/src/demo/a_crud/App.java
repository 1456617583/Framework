package demo.a_crud;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	@Test
	public void testSave() throws Exception {
		/*
		 * Hibernate�У�
		 * 
		 * SessionFactory df=new Configuration().config("hibernate.cfg.xml");
		 * Session session=sf.openSession(); �������� session.beginTransaction();
		 * �ύ���� session.getTransaction().commit(); �ر����� session.close();
		 */

		// ����һ������������ȡMybatis�������ļ�
		// ����������Ǵ���·����ʼѰ����Դ������һ�����·�������Ǵ�classes�¿�ʼ��
		InputStream in = App.class.getClassLoader().getResourceAsStream(
				"demo/a_crud/conf.xml");
		// ����SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// ����һ��sqlSession
		// openSession(true)��ʾ���Զ��ύ ʡ��session.commit();
		SqlSession session = sf.openSession(true);

		User u = new User();
		u.setName("Iyring");
		u.setBirthday(new Date());
		u.setMoney(800d);

		session.insert("demo.a_crud.userMapper.save", u);
		// �ر�����
		session.close();

	}

	@Test
	public void testDelete() throws Exception {
		InputStream in = App.class.getClassLoader().getResourceAsStream(
				"demo/a_crud/conf.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sf.openSession(true);
		session.delete("demo.a_crud.userMapper.delete", 1);
		session.close();
	}

	@Test
	public void testUpdate() throws Exception {
		InputStream in = App.class.getClassLoader().getResourceAsStream(
				"demo/a_crud/conf.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sf.openSession(true);
		User u = new User();
		u.setId(6);
		u.setName("Wade");
		session.update("demo.a_crud.userMapper.update", u);
		session.close();
	}

	@Test
	public void testFindOne() throws Exception {
		InputStream in = App.class.getClassLoader().getResourceAsStream(
				"demo/a_crud/conf.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sf.openSession(true);

		User u = session.selectOne("demo.a_crud.userMapper.findOne", 6);
		System.out.println(u);
		session.close();

	}

	@Test
	public void testFindAll() throws Exception {
		InputStream in = App.class.getClassLoader().getResourceAsStream(
				"demo/a_crud/conf.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sf.openSession(true);
		List<User> list = session.selectList("demo.a_crud.userMapper.findAll");
		for (User user : list) {
			System.out.println(user);
		}
		session.close();
	}

}

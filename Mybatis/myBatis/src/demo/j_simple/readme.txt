1: ����IUserDao�ӿ�
	�����dao�ӿڣ����������֣������� �����ļ��е�id��ͬ
	�����뷵��ֵҲҪ�������ļ���һ��
	
2: ��userMapper.xml�����֣���ΪIUserDao.xml
       ���Ŵ����ڵ�IUserDao.xml�ļ�����namespace��ֵҲ��Ϊ��
   <mapper namespace="demo.j_simple.IUserDao">
   
3: ֱ�ӻ�ȡdaoʵ�� �������Լ�дdao���ʵ���ࣩ

       ��SqlSession��getMapper��������ӿڵ��ֽ��룬mybatis�ͻ������ʵ�ָýӿڣ�
       ����ʵ���˸ýӿڵ�ʵ����Ķ��󣬴������������ػ���!
   IUserDao dao = session.getMapper(IUserDao.class);
package com.yatai.action;



import java.util.ArrayList;
import java.util.List;
import com.yatai.dao.UserDao;
import com.yatai.dao.ZichanDao;
import com.yatai.model.Dept;
import com.yatai.model.User;
import com.yatai.model.Zichan;

/**
 * �������ɾ�Ĳ�
 * ������struts2.0��ʹ��
 *
 */
public class UserAction
{
	List<User> list = new ArrayList<User>();
	//List<Zichan> listZichan = new ArrayList<Zichan>();
	List<Dept> listzichan = new ArrayList<Dept>();
	UserDao userDao = new UserDao();
	ZichanDao zichanDao = new ZichanDao();
	User user = new User();
	Zichan zichan = new Zichan();
	public String showAction()
	{
        list = userDao.login();
		return "success";
	}
	
	//ɾ��һ����¼
	public String deleteAction()
	{
		userDao.delete(user.getId());
		return this.showAction();
	}
	
	//��ȡ��Ҫ�޸ĵĲ���
	public String updateAction()
	{
		user = userDao.update(user.getId());
		return this.showAction();
	}

	//updateChoose��ȡ��Ҫ�޸ĵĲ���
	public String updateChooseAction(){
		user = userDao.update(user.getId());
		listzichan = zichanDao.showDeptInfo();
		return "success";
	}
	
	
	public String addAction()
	{
		listzichan = zichanDao.showDeptInfo();
		return "success";
	}
	
	//ִ���޸���Ϣ
	public String executeUserUpdateAction()
	{
		userDao.executeUserUpdate(user);
		return this.showAction();
	}
	
	//��ͨ�û�ִ���޸�������Ϣ
	public String executeCommonUserUpdateAction()
	{
		userDao.executeUserUpdate(user);
		return this.showAction();
	}
	
	
	//executeUpdateChooseִ���޸���Ϣ
	public String executeUpdateChooseAction()
	{
		userDao.executeUpdateChoose(user);
		return this.showAction();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Dept> getListZichan() {
		return listzichan;
	}

	public void setListZichan(List<Dept> listZichan) {
		this.listzichan = listZichan;
	}

	public ZichanDao getZichanDao() {
		return zichanDao;
	}

	public void setZichanDao(ZichanDao zichanDao) {
		this.zichanDao = zichanDao;
	}

	public Zichan getZichan() {
		return zichan;
	}

	public void setZichan(Zichan zichan) {
		this.zichan = zichan;
	}

	public List<Dept> getListzichan() {
		return listzichan;
	}

	public void setListzichan(List<Dept> listzichan) {
		this.listzichan = listzichan;
	}
}

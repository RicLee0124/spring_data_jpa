package cn.sm1234.test;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

	@Resource
	private IProductDao productDao;
	
	/**
	 * save����
	 */
	@Test
	@Transactional  //�����Ǹ��²����������ڲ��Է����м�������ע��
	@Rollback(false) //ȡ�����Է�����������Զ��ع�
	public void test1(){
		Product product = new Product();
		product.setName("mac phone");
		product.setPrice(5000D);
		product.setBrand("apple");
		product.setStore(2500);
		
		productDao.save(product);
	}
	
	
	/**
	 * findAll����
	 */
	@Test
	public void test2(){
		List<Product> list = productDao.findAll();
		for (Product product : list) {
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getBrand());
		}
	}
	
	
	@PersistenceContext
	private EntityManager em;
	@Test
	public void test3(){
		//org.springframework.data.jpa.repository.support.SimpleJpaRepository@365f10e6
		//System.out.println(productDao);
		
		//class com.sun.proxy.$Proxy28  ������󣬻���JDK��̬�������ɵĴ������
		//System.out.println(productDao.getClass());
		
		
		//ģ��Spring Data JPA�ĵײ����
		JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
		//����JDK��̬�������ɴ������
		IProductDao productDao = factory.getRepository(IProductDao.class);
		System.out.println(productDao.getClass());
	}
	
	
	
}

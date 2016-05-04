package cn.it;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;

/**
 * @Description TODO(采用Spring的注解调试，仅仅支持Spring3.1及以上)
 * @author Ni Shengwu
 *
 */
/*
 * Spring3.1后多了个spring-test-4.2.4.RELEASE.jar包，这个jar包专门用来支持JUnit基于注解的测试的，
 * 该jar包里有个SpringJUnit4ClassRunner.class，用@RunWith注解加进来即可
 * 
 * 注解@ContextConfiguration表示将ApplicationContext对象注入进来，就不用在测试程序里先new了，直接使用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SSHTest {
	
	@Resource
	private Date date;
	
	@Resource
	private CategoryService categoryService;
	
	@Test //测试Spring IOC的开发环境
	public void springIoc() {
		System.out.println(date);
	}
	
	@Test  //测试Hibernate的开发环境，因为没有整合，也可以直接new
	public void hihernate() {
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category("男士休闲", true);
		categoryService.save(category);
	}
	
	@Test //测试Hibernate和Spring整合后
	public void hibernateAndSpring() {
		categoryService.update(new Category(1, "休闲男式22", true));
	}

}

package cn.it.shop.sevice.impl;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.service.SorderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SorderServiceImplTest {

	@Resource 
	private SorderService sorderService;

	@Test
	public void queryJoinCategory() {
		System.out.println(JSONSerializer.toJSON(sorderService.querySale(5)));
		for(Object temp : sorderService.querySale(5)) {
			System.out.println(temp);
		}
	}
}

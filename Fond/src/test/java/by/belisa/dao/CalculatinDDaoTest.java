package by.belisa.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.entity.CalculationD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dogovor-portlet.xml")
@TransactionConfiguration
@Transactional
public class CalculatinDDaoTest {
	@Autowired
	CalculationDDao dao;
	@Test
	public void test(){
		List<CalculationD> list = dao.getListByDogovor(466);
		Assert.assertEquals(4, list.size());
		for (CalculationD c:list){
			System.out.println(c.getCalcArticle().getCode() +"   "+c.getYear());
		}
	}
	
}

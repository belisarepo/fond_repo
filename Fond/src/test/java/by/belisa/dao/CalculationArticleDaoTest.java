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

import by.belisa.entity.CalculationArticle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dogovor-portlet.xml")
@TransactionConfiguration
@Transactional
public class CalculationArticleDaoTest {
	@Autowired
	private CalculationArticleDao calculationArticleDao;
	@Test
	public void testGetLatestArticlesMethod(){
		List<CalculationArticle> list = calculationArticleDao.getLatestArticles();
		Assert.assertFalse(list.isEmpty());
		for (CalculationArticle i : list){
			Assert.assertEquals(2010, i.getYear().intValue());
		}
	}
}

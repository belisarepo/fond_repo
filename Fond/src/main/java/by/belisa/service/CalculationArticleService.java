package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.CalculationArticleDao;
import by.belisa.dao.Dao;
import by.belisa.entity.CalculationArticle;

@Service
public class CalculationArticleService extends ServiceImpl<CalculationArticle, Integer>{

	public CalculationArticleService() {
		super(CalculationArticle.class);
	}

	@Override
	@Autowired
	@Qualifier("calculationArticleDao")
	protected void setBaseDao(Dao<CalculationArticle, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public List<CalculationArticle> getLatestArticles(){
		CalculationArticleDao dao = (CalculationArticleDao)baseDao;
		return dao.getLatestArticles();
	}

}

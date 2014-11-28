package by.belisa.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import by.belisa.entity.CalculationArticle;

@Repository
public class CalculationArticleDao extends DaoImpl<CalculationArticle, Integer> {

	public CalculationArticleDao() {
		super(CalculationArticle.class);
	}

	@SuppressWarnings("unchecked")
	public List<CalculationArticle> getLatestArticles() {
		DetachedCriteria maxYear = DetachedCriteria.forClass(CalculationArticle.class)
				.setProjection(Property.forName("year").max());
		return getSession().createCriteria(CalculationArticle.class)
				.add(Property.forName("year").eq(maxYear))
				.addOrder(Order.asc("code"))
				.list();
	}

}

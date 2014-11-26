package by.belisa.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.belisa.entity.CalculationD;

@Repository
public class CalculationDDao extends DaoImpl<CalculationD, Integer>{

	public CalculationDDao() {
		super(CalculationD.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<CalculationD> getListByDogovor(Integer dogId){
		List<CalculationD> list = getSession().createCriteria(CalculationD.class)
				.createAlias("dogovor", "d")
				.createAlias("calcArticle", "cA")
				.add(Restrictions.eq("d.id", dogId))
				.addOrder(Order.asc("year"))
				.addOrder(Order.asc("cA.code")).list();
		return list;
	}

}

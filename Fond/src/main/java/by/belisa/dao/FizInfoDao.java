package by.belisa.dao;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.entity.FizInfo;

@Repository
public class FizInfoDao extends DaoImpl<FizInfo, Integer>{

	public FizInfoDao() {
		super(FizInfo.class);
	}
	public FizInfo getByFio(String s, String n, String p, Date birthday){
		Query q = getSession().createQuery("FROM FizInfo where surname=:surname and birthday=:birthday");
		q.setDate("birthday", birthday);
		q.setString("surname", s+" "+n+" "+p);
		
		return (FizInfo) q.uniqueResult();
	}

}

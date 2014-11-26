package by.belisa.dao;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.entity.FizNRInfo;

@Repository
public class FizNRInfoDao extends DaoImpl<FizNRInfo, Integer>{

	public FizNRInfoDao() {
		super(FizNRInfo.class);
	}
	public FizNRInfo getByFio(String fullName, Date birthday){
		Query q = getSession().createQuery("FROM FizNRInfo where surname=:surname and birthday=:birthday");
		q.setDate("birthday", birthday);
		q.setString("surname", fullName);
		
		return (FizNRInfo) q.uniqueResult();
	}

}

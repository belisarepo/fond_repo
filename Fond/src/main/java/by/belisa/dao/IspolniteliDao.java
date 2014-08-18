package by.belisa.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Ispolnitel;
@Repository
public class IspolniteliDao extends DaoImpl<Ispolnitel, Integer>{

	public IspolniteliDao() {
		super(Ispolnitel.class);
	}
	
	public List<Ispolnitel> getAllByZayavkaId(Integer zayavkaId){
		Query q = getSession().createQuery("FROM Ispolnitel WHERE zayavkaFI.id = :zayavkaId");
		q.setInteger("zayavkaId", zayavkaId);
		return q.list();
	}

}

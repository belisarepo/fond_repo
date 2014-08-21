package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.StatusZayavkaFI;
@Repository
public class StatusZayavkaFIDao extends DaoImpl<StatusZayavkaFI, Integer>{

	public StatusZayavkaFIDao() {
		super(StatusZayavkaFI.class);
	}

}

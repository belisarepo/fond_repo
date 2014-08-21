package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.StatusZayavkaFI;

@Service
public class StatusZayavkaFIService extends ServiceImpl<StatusZayavkaFI, Integer>{

	public StatusZayavkaFIService() {
		super(StatusZayavkaFI.class);
	}

	@Override
	@Autowired
	@Qualifier(value="statusZayavkaFIDao")
	protected void setBaseDao(Dao<StatusZayavkaFI, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

	
}

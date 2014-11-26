package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.FizNRInfo;

@Service
public class FizNRInfoService extends ServiceImpl<FizNRInfo, Integer>{

	public FizNRInfoService() {
		super(FizNRInfo.class);
	}

	@Override
	@Autowired
	@Qualifier("fizNRInfoDao")
	protected void setBaseDao(Dao<FizNRInfo, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}

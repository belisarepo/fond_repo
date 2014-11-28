package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.PublicationMDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.PublicationM;
import by.belisa.exception.DaoException;

@Service
public class PublicationMService extends ServiceImpl<PublicationM, Integer>{

	public PublicationMService() {
		super(PublicationM.class);
	}

	@Override
	@Autowired
	@Qualifier("publicationMDao")
	protected void setBaseDao(Dao<PublicationM, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public PublicationMDTO getDTO(Integer id) throws DaoException{
		PublicationM entity = baseDao.get(id);
		return new PublicationMDTO(entity);
	}

	public void edit(PublicationMDTO dto) throws DaoException{
		PublicationM entity = baseDao.get(dto.getId());
		entity.setAuthors(dto.getAuthors());
		entity.setEdition(dto.getEdition());
		entity.setName(dto.getName());
		entity.setPages(dto.getPages());
		baseDao.update(entity);
	}
}

package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.PublicationDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.Publication;
import by.belisa.exception.DaoException;

@Service
public class PublicationService extends ServiceImpl<Publication, Integer>{

	public PublicationService() {
		super(Publication.class);
	}

	@Override
	@Autowired
	@Qualifier(value="publicationDao")
	protected void setBaseDao(Dao<Publication, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	public PublicationDTO getDTO(Integer id) throws DaoException{
		return new PublicationDTO(baseDao.get(id));
	}
	
	public void edit(PublicationDTO dto) throws DaoException{
		Publication entity = baseDao.get(dto.getId());
		entity.setAuthors(dto.getAuthors());
		entity.setCitationIndex(dto.getCitationIndex());
		entity.setDatabase(dto.getDatabase());
		entity.setEdition(dto.getEdition());
		entity.setName(dto.getName());
		baseDao.update(entity);
	}
}

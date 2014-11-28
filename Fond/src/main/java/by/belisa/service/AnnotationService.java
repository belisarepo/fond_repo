package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.AnnotationDao;
import by.belisa.dao.Dao;
import by.belisa.entity.Annotation;

@Service
public class AnnotationService extends ServiceImpl<Annotation, Integer>{

	public AnnotationService() {
		super(Annotation.class);
	}

	@Override
	@Autowired
	@Qualifier(value="annotationDao")
	protected void setBaseDao(Dao<Annotation, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	public byte[] getFile(int id) {
		AnnotationDao annotationDao = (AnnotationDao) baseDao;
		return annotationDao.getFile(id);
	}

	public void deleteFile(Integer zayavkaId) {
		AnnotationDao annotationDao = (AnnotationDao) baseDao;
		annotationDao.deleteFile(zayavkaId);
	}
}

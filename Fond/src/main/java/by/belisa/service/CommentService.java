package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CommentDTO;
import by.belisa.bean.OrgDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.OkoguDao;
import by.belisa.dao.UserDao;
import by.belisa.dao.VidOrgDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Comment;
import by.belisa.entity.Organization;
import by.belisa.entity.ZayavkaFI;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;

@Service
public class CommentService extends ServiceImpl<Comment, Integer> {

	public CommentService() {
		super(Comment.class);
	}
	@Override
	@Autowired
	@Qualifier(value = "commentDao")
	protected void setBaseDao(Dao<Comment, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	public void saveOrUpdate(CommentDTO commentDTO) throws ParseException, DaoException, ServiceException {
		Comment comment = new Comment();
		comment.setComment_date(new Date());
		comment.setText(commentDTO.getText());
		comment.setUser(userDao.get(commentDTO.getUser_id()));
		baseDao.saveOrUpdate(comment);
	}


}

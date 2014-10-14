package by.belisa.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Comment;
@Repository
public class CommentDao extends DaoImpl<Comment, Integer>{
	private static Logger log = Logger.getLogger(CommentDao.class);
	public CommentDao() {
		super(Comment.class);
	}

	
}

package by.belisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import by.belisa.entity.Anketa;
import by.belisa.entity.Comment;

public class CommentDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5556610303426905342L;

	public CommentDTO() {

	}

	public CommentDTO(Comment comment){
		if (comment!=null){
			this.id = comment.getId();
			this.comment_date = comment.getComment_date()!=null ? dateFormat.format(comment.getComment_date()): null;
			this.text = comment.getText();
		}
		
	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm");
	private Integer id;
	private String comment_date;
	private String text;
	private long user_id;

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	
	

}
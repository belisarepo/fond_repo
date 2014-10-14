package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import by.belisa.validation.IValidaton;
import by.belisa.validation.ValidationResult;

@Entity
@Table(name = "USER_COMMENT")
@SequenceGenerator(name="PK", sequenceName="SEQ_COMMENT")
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4443436266052344647L;

	public Comment() {

	}

	public Comment(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name = "COMMENT_DATE", columnDefinition = "TIMESTAMP")
	private Date comment_date;
	@Lob
	@Column(name = "TEXT")
	private String text;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="USER_ID")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}

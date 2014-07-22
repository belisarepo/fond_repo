package by.belisa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="PK", sequenceName="SEQ_TUSERINFO")
public class TUserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PK")
	private int id;
	@OneToOne(mappedBy="info",fetch=FetchType.LAZY)
	private TUser user;
	public int getId() {
		return id;
	}
	@Column
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	
}

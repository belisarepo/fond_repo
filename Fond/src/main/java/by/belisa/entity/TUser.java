package by.belisa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="PK", sequenceName="SEQ_TUSER")
public class TUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PK")
	private int id;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="t_user_info",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="info_id"))
	private TUserInfo info;
	
	@Column(name="CLOB_FIELD",columnDefinition="CLOB")
	private String clob;
	
	public String getClob() {
		return clob;
	}
	public void setClob(String clob) {
		this.clob = clob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TUserInfo getInfo() {
		return info;
	}
	public void setInfo(TUserInfo info) {
		this.info = info;
	}

}

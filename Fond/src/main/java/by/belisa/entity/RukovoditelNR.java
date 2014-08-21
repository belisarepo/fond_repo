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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="RUKOVODITEL_NR")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class RukovoditelNR implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3548396216375283318L;
	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	private Integer id;
	@Column(name="FIO", length=60)
	private String fio;
	@Column(name="FIO_FULL", length=100)
	private String fullFio;
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UCH_STEPENI_ID")
	private UchStepeni uchStepeni;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UCH_ZVANIY_ID")
	private UchZvaniy uchZvaniy;
	@Column(name="POST")
	private String post;
	@Column(name="BIRTHDAY", columnDefinition="DATE")
	private Date birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public String getFullFio() {
		return fullFio;
	}
	public void setFullFio(String fullFio) {
		this.fullFio = fullFio;
	}
	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}
	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	public UchStepeni getUchStepeni() {
		return uchStepeni;
	}
	public void setUchStepeni(UchStepeni uchStepeni) {
		this.uchStepeni = uchStepeni;
	}
	public UchZvaniy getUchZvaniy() {
		return uchZvaniy;
	}
	public void setUchZvaniy(UchZvaniy uchZvaniy) {
		this.uchZvaniy = uchZvaniy;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	

}

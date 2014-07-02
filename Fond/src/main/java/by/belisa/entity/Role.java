package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_", schema="LPORTAL")
@SequenceGenerator(name="PK", sequenceName="SEQ_ROLE")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7817371786874409904L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PK")
	@Column(name="roleid")
	private long id;
	@Column(name="name")
	private String name;

}

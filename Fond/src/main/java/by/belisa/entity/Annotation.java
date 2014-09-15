package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import by.belisa.validation.IValidaton;
import by.belisa.validation.ValidationResult;

@Entity
@Table(name = "ANNOTATION")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class Annotation implements Serializable, IValidaton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1466781647372993149L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen")
	private Integer id;

	@Column(name = "TEMA")
	private String tema;

	@Lob
	@Column(name = "KEY_WORDS")
	private String keyWords;
	@Lob
	@Column(name = "JOB_GOAL")
	private String jobGoal;
	@Lob
	@Column(name = "IDEA")
	private String idea;
	@Lob
	@Column(name = "RESULTS")
	private String results;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getJobGoal() {
		return jobGoal;
	}

	public void setJobGoal(String jobGoal) {
		this.jobGoal = jobGoal;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}

	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult vr = new ValidationResult();
		String message = null;
		String tabNameAnnotation = "во вкладке \"Аннотация\"";
		// Проверка ключевых слов
		if (this.keyWords.isEmpty()) {
			message = "Не заполненые ключевые слова" + " " + tabNameAnnotation;
			vr.getErrMessages().add(message);
		}
		// Проверка цели работы
		if (this.jobGoal.isEmpty()) {
			message = "Не заполнена цель работы" + " " + tabNameAnnotation;
			vr.getErrMessages().add(message);
		}
		// Проверка научной идеи
		if (this.getIdea().isEmpty()) {
			message = "Не указана научная идея" + " " + tabNameAnnotation;
			vr.getErrMessages().add(message);
		}
		//Проверка основных планируемых результатов
		if(this.getResults().isEmpty()){
			message = "Не заполенены основные планируемые результаты" +" "+ tabNameAnnotation;
			vr.getErrMessages().add(message);
		}
		return vr;
	}

}

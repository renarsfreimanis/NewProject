package main;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id")
	private Long id;
	
	@Column(name = "author")
	@NotEmpty(message = "*Please provide your name and last name")
	private String author;
	
	@Column(name = "course_code") // Kursa kods 
	@NotNull(message = "*Please provide course code")
	private int courseCode;
	
	@Column(name = "creditpoints") // Krediitpunkti (1,2,4,8)
	@NotNull(message = "*Please provide creditpoints for course")
	private int creditpoints;
	
	@Column(name = "precondition") // Prieskshnosaciijumi kursa uzsaakshanai
	@NotEmpty(message = "*Please provide preconditions for course")
	private String preconditions;
	
	@Column(name = "course_purpose") // Kursa meerkjis
	@NotEmpty(message = "*Please provide course purpose")
	private String coursePurpose; 
	
	@Column(name = "course_results") // Studiju rezultaati
	@NotEmpty(message = "*Please provide course results")
	private String courseResults;
	
	@Column(name = "permanent_work") // Studeejoshaa pastaavigaa darba org. veids
	@NotEmpty(message = "*Please provide students permanent work")
	private String permanentWork;
	
	@Column(name = "evaluation") // Studiju rezultatu verteshana
	@NotEmpty(message = "*Please provide course result evaluation")
	private String evaluation;
	
	@Column(name = "course_content")
	@NotEmpty(message = "*Please provide course content")
	private String courseContent;
	
	public Course() {}
	
	public Course(String author, int courseCode, int creditpoints, String preconditions, String coursePurpose, String courseResults, String permanentWork, String evaluation, String courseContent) {
		setAuthor(author);
		setCourseCode(courseCode);
		setCreditpoints(creditpoints);
		setPreconditions(preconditions);
		setCoursePurpose(coursePurpose);
		setCourseResults(courseResults);
		setPermanentWork(permanentWork);
		setEvaluation(evaluation);
		setCourseContent(courseContent);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public int getCreditpoints() {
		return creditpoints;
	}

	public void setCreditpoints(int creditpoints) {
		this.creditpoints = creditpoints;
	}

	public String getPreconditions() {
		return preconditions;
	}

	public void setPreconditions(String preconditions) {
		this.preconditions = preconditions;
	}

	public String getCoursePurpose() {
		return coursePurpose;
	}

	public void setCoursePurpose(String coursePurpose) {
		this.coursePurpose = coursePurpose;
	}

	public String getCourseResults() {
		return courseResults;
	}

	public void setCourseResults(String courseResults) {
		this.courseResults = courseResults;
	}

	public String getPermanentWork() {
		return permanentWork;
	}

	public void setPermanentWork(String permanentWork) {
		this.permanentWork = permanentWork;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}
}
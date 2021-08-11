package com.cg.fms.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="participant_feedback_fms" )
//@NamedQueries(	{	
//	@NamedQuery(name = "all-participants",query = "select p from Participant p Where p.participantId = ?1"),
//	@NamedQuery(name = "all-faculty",query = "select f from faculty f Where p.facultyId = ?1")})
public class ParticipantFeedback {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer feedbackNo;

	@Min(value = 1)
	@Max(value = 5)
	private Integer marksQuestion1;
	@Min(value = 1)
	@Max(value = 5)
	private Integer marksQuestion2;
	@Min(value = 1)
	@Max(value = 5)
	private Integer marksQuestion3;
	@Min(value = 1)
	@Max(value = 5)
	private Integer marksQuestion4;
	@Min(value = 1)
	@Max(value = 5)
	private Integer marksQuestion5;

	@ManyToOne
	@JoinColumn(name = "participant_id")
	private Participant participant;



	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;


	private Double averageRating;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date feedbackdate;


	@ManyToOne
	@JoinColumn(name = "feedback_sno" )
	private FeedbackMaster feedbackMaster;
	
	public ParticipantFeedback(Integer feedbackNo, @Min(1) @Max(5) Integer marksQuestion1,
			@Min(1) @Max(5) Integer marksQuestion2, @Min(1) @Max(5) Integer marksQuestion3,
			@Min(1) @Max(5) Integer marksQuestion4, @Min(1) @Max(5) Integer marksQuestion5, Double averageRating) {
		super();
		this.feedbackNo = feedbackNo;
		this.marksQuestion1 = marksQuestion1;
		this.marksQuestion2 = marksQuestion2;
		this.marksQuestion3 = marksQuestion3;
		this.marksQuestion4 = marksQuestion4;
		this.marksQuestion5 = marksQuestion5;
		this.averageRating = averageRating;
	}


}
package com.cg.fms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "feedback_master_fms" )
public class FeedbackMaster {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackSno;

	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;


	@JsonIgnore
	@OneToMany(mappedBy = "feedbackMaster",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<ParticipantFeedback> participantFeedbackSet;

	public FeedbackMaster(Integer feedbackSno, String question1, String question2, String question3, String question4,
			String question5) {
		super();
		this.feedbackSno = feedbackSno;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
	}
}

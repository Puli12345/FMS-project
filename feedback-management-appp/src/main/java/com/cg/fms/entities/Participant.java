package com.cg.fms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Setter
@Getter
@Table(name = "participant_fms")
public class Participant {
    

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer participantId;
	
    private String participantName;
	private String address;
	private Long mobile;
	private String email;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "participantSet",cascade = CascadeType.ALL)
	private Set<Course> courseSet;
	
	@JsonIgnore
	@OneToMany(mappedBy = "participant",fetch = FetchType.LAZY)
	private Set<ParticipantFeedback> participantFeedbackSet;
	
	public Participant(Integer participantId, String participantName, String address, Long mobile, String email) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	
	
}

package com.cg.fms.entities;

import java.util.List;

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
 //inverse side
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "faculty_fms")

public class Faculty {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer facultyId;
	private String facultyName;
	private Long mobile;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "facultySet",cascade = CascadeType.ALL)
	private List<Course> courseSet;
	
	private String email;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "facultySet",cascade = CascadeType.ALL)
	private Set<Skills> skillsSet;
	
	@JsonIgnore
	@OneToMany(mappedBy = "faculty",fetch = FetchType.LAZY)
	private Set<ParticipantFeedback> participantFeedbackSet;
	
	public Faculty(Integer facultyId, String facultyName, Long mobile, String email) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.mobile = mobile;
		this.email = email;
	}
	
}

package com.cg.fms.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//owning side
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "course_fms")
public class Course {
    

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
    private String courseName;
	private String courseDescription;
	private Integer duration;
	
	// here we are joining the tables courseId and partcipantId in participant_course
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Participant_Course",
	joinColumns = {@JoinColumn(name="courseId") },
	inverseJoinColumns = {@JoinColumn(name="participantId")})
	public Set<Participant> participantSet;
	
	// here we are joining the tables courseId and facultyId in faculty_course
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Faculty_Course",
	joinColumns = {@JoinColumn(name="course_id") },
	inverseJoinColumns = {@JoinColumn(name="faculty_id")})
	public Set<Faculty> facultySet;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
	private List<ParticipantFeedback> participantFeedbackSet;
	
	public Course(Integer courseId, String courseName, String courseDescription, Integer duration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.duration = duration;
	}
}

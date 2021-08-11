package com.cg.fms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "skills_fms")

public class Skills {
	public Skills(Integer skillId, String skillName, String skillDescription) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillDescription = skillDescription;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer skillId;
	
	private String skillName;
	private String skillDescription;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Faculty_Skill",
	joinColumns = {@JoinColumn(name="skillId") },
	inverseJoinColumns = {@JoinColumn(name="facultyId")})
	public Set<Faculty> facultySet;
	




}

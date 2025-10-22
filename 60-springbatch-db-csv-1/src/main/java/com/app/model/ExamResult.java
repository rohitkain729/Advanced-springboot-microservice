package com.app.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EXAM_RESULT")
public class ExamResult {
	@Id
	private Integer id;
	private Date dob;
	private Float percentage;
	private Integer semester;

}

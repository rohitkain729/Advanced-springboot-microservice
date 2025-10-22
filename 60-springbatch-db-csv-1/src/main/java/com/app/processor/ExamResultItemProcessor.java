package com.app.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.app.model.ExamResult;

@Component("erProcessor")
public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if (item.getPercentage() >= 90.0f) {
			return item;
		}
		return null;
	}
}

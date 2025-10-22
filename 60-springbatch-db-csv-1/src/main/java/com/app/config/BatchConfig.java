package com.app.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.app.listener.JobMonitoringListener;
import com.app.model.ExamResult;
import com.app.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobMonitoringListener listener;

	@Autowired
	private JobBuilderFactory jobFactory;

	@Autowired
	private StepBuilderFactory stepFactory;

	@Autowired
	private DataSource ds;

	@Autowired
	private ExamResultItemProcessor processor;

	@Bean(name = "jcir")
	public JdbcCursorItemReader<ExamResult> createReader() {
		return new JdbcCursorItemReaderBuilder<ExamResult>().name("jdbc-reader").dataSource(ds)
				.sql("select id,dob,percentage,semester from exam_result")
				.beanRowMapper(ExamResult.class).build();
//		below old ways
//				.rowMapper((rs,rownumb)->new ExamResult(rs.getInt(1),rs.getDate(2),rs.getFloat(3),rs.getInt(4))).build();
	}

	@Bean(name = "ffiw")
	public FlatFileItemWriter<ExamResult> createWriter() {
		return new FlatFileItemWriterBuilder<ExamResult>().name("writer")
				.resource(new FileSystemResource("C:\\Users\\rohit\\OneDrive\\Documents\\topbrains.csv"))
				
				.lineSeparator("\r\n").delimited().delimiter(",")
				.names("id", "dob", "percentage", "semester").build();
		
//		C:\\Users\\rohit\\OneDrive\\Documents\\topbrains.csv

//		old code
//				.lineAggregator(new DelimitedLineAggregator<ExamResult>() {{
//					setDelimiter(",");
//					setFieldExtractor(new BeanWrapperFieldExtractor<ExamResult>() {{
//						setNames(new String[] {"id","dob","percentage","semester"});
//					}});
//				}}).build();
		
	}

	// create the step object
	@Bean(name = "step1")
	public Step createStep() {
                        return stepFactory.get("step1")
		.<ExamResult,ExamResult>chunk(2)
		.reader(createReader())
		.writer(createWriter())
		.processor(processor)
		.build();
		
//		return new StepBuilder("step1", jobRepository).<Employee, Employee>chunk(3, transactionManager)
//				.reader(createReader()).writer(createWriter()).processor(processor).build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		return jobFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(createStep()).build();
				
				
				
//		return new JobBuilder("job1", jobRepository).incrementer(new RunIdIncrementer()).listener(listener).start(step1)
//				.build();
	}

}

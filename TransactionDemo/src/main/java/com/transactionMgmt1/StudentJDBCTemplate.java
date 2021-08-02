/**
 * 
 */
package com.transactionMgmt1;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author hcharadava
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager tm) {
		this.transactionManager = tm;
	}
	
	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplateObject.update(SQL1,name,age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplateObject.queryForObject(SQL2, Integer.class);

			String SQL3 = "insert into Marks(student_id, marks, years) " + "values (?, ?, ?)";
			jdbcTemplateObject.update(SQL3,sid,marks,year);

			System.out.println("Created Name = " + name + ", Age = " + age);
			transactionManager.commit(status);
		} 
		catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}
		return;
	}

	// first delete everything
	public void deleteFirst() {
		String delSQL = "delete from Marks";
		jdbcTemplateObject.update(delSQL);
		delSQL = "delete from Student";
		jdbcTemplateObject.update(delSQL);
		System.out.println("Data from both tables have been deleted.");
	}

	@Override
	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student, Marks where Student.id=Marks.student_id";
		List <StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());
		return studentMarks;
	}
}

package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.StudentDao;
import com.sofa.model.account.User;
import com.sofa.model.student.CardAddress;
import com.sofa.model.student.CurrentAddress;
import com.sofa.model.student.HistoryEducation;
import com.sofa.model.student.ParentStudent;
import com.sofa.model.student.StepParentStudent;
import com.sofa.model.student.Student;
import com.sofa.model.student.StudentDetail;

@Repository
public class StudentDaoImpl implements StudentDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Student student)
	{
		session.getCurrentSession().save(student.getCardAddress());
		session.getCurrentSession().save(student.getCurrentAddress());
		session.getCurrentSession().save(student.getParentStudent());
		session.getCurrentSession().save(student.getStepParentStudent());
		session.getCurrentSession().save(student.getStudentDetail());
		session.getCurrentSession().save(student.getHistoryEducation());
		session.getCurrentSession().save(student.getUser());
		session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student)
	{
		student.getCardAddress().setId(student.getCardAddress().getId());		
		session.getCurrentSession().update(student.getCardAddress());
	
		student.getCurrentAddress().setId(student.getCurrentAddress().getId());
		session.getCurrentSession().update(student.getCurrentAddress());
		
		student.getParentStudent().setId(student.getParentStudent().getId());
		session.getCurrentSession().update(student.getParentStudent());
		
		student.getStepParentStudent().setId(student.getStepParentStudent().getId());
		session.getCurrentSession().update(student.getStepParentStudent());
		
		student.getStudentDetail().setId(student.getStudentDetail().getId());
		session.getCurrentSession().update(student.getStudentDetail());
		
		student.getHistoryEducation().setId(student.getHistoryEducation().getId());
		session.getCurrentSession().update(student.getHistoryEducation());
		
		session.getCurrentSession().update(student);	
	}

	@Override
	public void delete(int studentId)
	{		
		//session.getCurrentSession().delete(getStudent(studentId));
		session.getCurrentSession().delete((CardAddress)session.getCurrentSession().get(CardAddress.class, getStudent(studentId).getCardAddress().getId()));
		session.getCurrentSession().delete((CurrentAddress)session.getCurrentSession().get(CurrentAddress.class, getStudent(studentId).getCurrentAddress().getId()));
		session.getCurrentSession().delete((ParentStudent)session.getCurrentSession().get(ParentStudent.class, getStudent(studentId).getParentStudent().getId()));
		session.getCurrentSession().delete((StepParentStudent)session.getCurrentSession().get(StepParentStudent.class, getStudent(studentId).getStepParentStudent().getId()));
		session.getCurrentSession().delete((HistoryEducation)session.getCurrentSession().get(HistoryEducation.class, getStudent(studentId).getHistoryEducation().getId()));
		session.getCurrentSession().delete((StudentDetail)session.getCurrentSession().get(StudentDetail.class, getStudent(studentId).getStepParentStudent().getId()));
		session.getCurrentSession().delete((User)session.getCurrentSession().get(User.class, getStudent(studentId).getUser().getId()));
		
		session.getCurrentSession().delete((Student)session.getCurrentSession().get(Student.class, studentId));
	}

	@Override
	public Student getStudent(int studentId)
	{
		return (Student)session.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public List getAllStudent() 
	{
		//return session.getCurrentSession().createQuery("from Student").list();
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(Student.class);
		
		return critSelectedResumes.list();
	}

}

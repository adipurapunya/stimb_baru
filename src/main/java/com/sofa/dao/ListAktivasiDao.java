package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ListSemesterPerkuliahan;

public interface ListAktivasiDao 
{
	void add(ListSemesterPerkuliahan listSemesterPerkuliahan);
	void edit(ListSemesterPerkuliahan listSemesterPerkuliahan);
	void delete(int listSemesterPerkuliahanId);
	ListSemesterPerkuliahan find(int listSemesterPerkuliahanId);
	List<ListSemesterPerkuliahan> findTrue(boolean param);
	List<ListSemesterPerkuliahan> getAllListSemesterPerkuliahan();
	List<ListSemesterPerkuliahan> getAllListSemesterPerkuliahanById(int id);
}

package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ListSemesterPerkuliahan;

public interface ListAktivasiService
{
	public void add(ListSemesterPerkuliahan listSemesterPerkuliahan);
	public void edit(ListSemesterPerkuliahan listSemesterPerkuliahan);
	public void delete(int listSemesterPerkuliahanId);
	public ListSemesterPerkuliahan getListMatakuliah(int listSemesterPerkuliahanId);
	public List<ListSemesterPerkuliahan> findTrue(boolean param);
	public List getAllListSemesterPerkuliahan();
	public List<ListSemesterPerkuliahan> getAllListSemesterPerkuliahanById(int Id);
}

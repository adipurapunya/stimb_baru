package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ListInstrumentMayor;

public interface ListIntrumentMayorService
{
	public void add(ListInstrumentMayor listInstrumentMayor);
	public void edit(ListInstrumentMayor listInstrumentMayor);
	public void delete(int listInstrumentMayorId);
	public ListInstrumentMayor getListInstrumentMayor(int listInstrumentMayorId);
	public List getAllListInstrumentMayor();
	List<ListInstrumentMayor> getAllListInstrumentMayorId(int listInstrumentMayorId);
	List<ListInstrumentMayor> getAllListInstrumentMayorByMatkulId(int matkulId);
}

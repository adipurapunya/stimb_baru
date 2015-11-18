package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ListInstrumentMayor;

public interface ListInstrumentMayorDao 
{
	void add(ListInstrumentMayor listInstrumentMayor);
	void edit(ListInstrumentMayor listInstrumentMayor);
	void delete(int listInstrumentMayorId);
	ListInstrumentMayor find(int listInstrumentMayorId);
	List<ListInstrumentMayor> getAllListInstrumentMayor();
	List<ListInstrumentMayor> getAllListInstrumentMayorId(int listInstrumentMayorId);
	List<ListInstrumentMayor> getAllListInstrumentMayorByIdMatkul(int matkulId);
}

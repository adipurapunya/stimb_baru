package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ReffInstrumentMayor;

public interface ReffInstrumentMayorDao 
{
	void addReffMayor(ReffInstrumentMayor reffMayor);
	void editReffMayor(ReffInstrumentMayor reffMayor);
	void deleteReffMayor(int reffMayorId);
	ReffInstrumentMayor findReffMayor(int reffMayorId);
	ReffInstrumentMayor findReffMayorName(String name);
	List<ReffInstrumentMayor> getAllReffMayor();
}

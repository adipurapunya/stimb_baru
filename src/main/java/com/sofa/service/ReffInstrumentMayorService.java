package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ReffInstrumentMayor;

public interface ReffInstrumentMayorService
{
	public void add(ReffInstrumentMayor reffMayor);
	public void edit(ReffInstrumentMayor reffMayor);
	public void delete(int reffMayorId);
	public ReffInstrumentMayor getReffMayor(int reffMayorId);
	public List<ReffInstrumentMayor> getAllReffMayor();
}

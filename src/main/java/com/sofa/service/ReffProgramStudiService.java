package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ReffProgramStudi;

public interface ReffProgramStudiService
{
	public void add(ReffProgramStudi reffProgramStudi);
	public void edit(ReffProgramStudi reffProgramStudi);
	public void delete(int reffProgramStudiId);
	public ReffProgramStudi getReffProgramStudi(int reffProgramStudiId);
	public List getAllReffProgramStudi();
}

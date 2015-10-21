package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ReffProgramStudi;

public interface ReffProgramStudiDao {
	void addReffProgramStudi(ReffProgramStudi reffProgramStudi);
	void editReffProgramStudi(ReffProgramStudi reffProgramStudi);
	void deleteReffProgramStudi(int userId);
	ReffProgramStudi findReffProgramStudi(int reffProgramStudiId);
	ReffProgramStudi findReffProgramStudiByName(String name);
	List<ReffProgramStudi> getAllReffProgramStudi();
}

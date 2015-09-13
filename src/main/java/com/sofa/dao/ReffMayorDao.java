package com.sofa.dao;

import java.util.List;

import com.sofa.model.kurikulum.ReffMayor;

public interface ReffMayorDao 
{
	void addReffMayor(ReffMayor reffMayor);
	void editReffMayor(ReffMayor reffMayor);
	void deleteReffMayor(int reffMayorId);
	ReffMayor findReffMayor(int reffMayorId);
	ReffMayor findReffMayorName(String name);
	List<ReffMayor> getAllReffMayor();
}

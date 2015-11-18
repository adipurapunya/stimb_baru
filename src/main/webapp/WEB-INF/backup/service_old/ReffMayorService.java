package com.sofaaa.service_old;

import java.util.List;

import com.sofa.model.kurikulum.ReffMayor;

public interface ReffMayorService
{
	public void add(ReffMayor reffMayor);
	public void edit(ReffMayor reffMayor);
	public void delete(int reffMayorId);
	public ReffMayor getReffMayor(int reffMayorId);
	public List getAllReffMayor();
}

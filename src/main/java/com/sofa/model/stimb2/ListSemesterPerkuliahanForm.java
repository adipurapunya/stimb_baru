package com.sofa.model.stimb2;

import java.util.List;


public class ListSemesterPerkuliahanForm 
{
	private List<ListSemesterPerkuliahan> listSemesterPerkuliahans;
	
	private List<MasterKurikulum> masterKurikulums;

	public List<ListSemesterPerkuliahan> getListSemesterPerkuliahans() {
		return listSemesterPerkuliahans;
	}

	public void setListSemesterPerkuliahans(
			List<ListSemesterPerkuliahan> listSemesterPerkuliahans) {
		this.listSemesterPerkuliahans = listSemesterPerkuliahans;
	}

	public List<MasterKurikulum> getMasterKurikulums() {
		return masterKurikulums;
	}

	public void setMasterKurikulums(List<MasterKurikulum> masterKurikulums) {
		this.masterKurikulums = masterKurikulums;
	}
}

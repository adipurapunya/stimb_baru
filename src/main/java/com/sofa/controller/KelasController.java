package com.sofa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.model.stimb2.KelasPerkuliahan;
import com.sofa.model.stimb2.ListInstrumentMayor;
import com.sofa.model.stimb2.ListMatakuliah;
import com.sofa.model.stimb2.ListDosenKelas;
import com.sofa.model.stimb2.ListSemesterPerkuliahan;
import com.sofa.service.KrsService;
import com.sofa.service.ReffTahunAjaranService;
import com.sofa.service.KelasService;
import com.sofa.service.ListAktivasiService;
import com.sofa.service.ListIntrumentMayorService;
import com.sofa.service.ListMatkulService;
import com.sofa.service.ListDosenKelasService;
import com.sofa.service.MasterDosenService;
import com.sofa.service.MasterKurikulumService;
import com.sofa.service.MasterMatkulService;
import com.sofa.service.KrsService;



@Controller
@RequestMapping(value="/classes")
public class KelasController 
{
	@Autowired
	private KelasService kelasService;
	
	@Autowired
	private ListMatkulService listMatkulService;
	
	@Autowired
	private MasterDosenService MasterDosenService;
	
	@Autowired
	private MasterKurikulumService MasterKurikulumService;
	
	@Autowired
	private MasterMatkulService masterMatkulService;
	
	@Autowired
	private ListAktivasiService listAktivasiService;
	
	@Autowired
	private ListIntrumentMayorService listIntrumentMayorService;
	
	@Autowired
	private ListDosenKelasService ListDosenKelasService;
	
	@Autowired
	private ReffTahunAjaranService reffTahunAjaranService;
	
	@Autowired
	private KrsService krsService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping({"/kelas", "/class"})
	public String setupForm(Map<String, Object> map)
	{
		KelasPerkuliahan kelasPerkuliahan = new KelasPerkuliahan();
		map.put("kelas", kelasPerkuliahan);
		map.put("kelasList", kelasService.getAllKelasPerkuliahan());
		map.put("taList", reffTahunAjaranService.getAllReffTahunAjaranByAktivasi(true));
		
		List<ListSemesterPerkuliahan> ls =  listAktivasiService.findTrue(true);
		for(ListSemesterPerkuliahan lt : ls)
		{
			map.put("matkulList", listMatkulService.getAllListMatakuliahByIdKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()))));
			map.put("prodiId", MasterKurikulumService.getMasterKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()))));
		}
		
		return "kelasview";
	}
	
	@RequestMapping(value="/create/{id}", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ListInstrumentMayor> createClass(@PathVariable int id)
	{
		return listIntrumentMayorService.getAllListInstrumentMayorByMatkulId(id);
	}
	
	@RequestMapping(value="/viewKelas", method=RequestMethod.GET)
	public ModelAndView viewListMk(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("detailkelasview");
		KelasPerkuliahan kelasPerkuliahan = new KelasPerkuliahan();
		
		mav.addObject("detailkelasview", kelasPerkuliahan);
		map.put("kelasList", kelasService.getKelasPerkuliahan(id));
		map.put("dosenList", ListDosenKelasService.getAllListDosenKelasByIdKelas(id));
		return mav;
	}
	
	@RequestMapping(value="/addDosen", method=RequestMethod.GET)
	public ModelAndView AddForm(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("detailkelasAdd");
		KelasPerkuliahan kelasPerkuliahan = kelasService.getKelasPerkuliahan(id);
		ListDosenKelas listDosenKelas = new ListDosenKelas();
		
		mav.addObject("detailkelasAdd", listDosenKelas);
		map.put("kelasList", kelasPerkuliahan);
		map.put("dosenList", MasterDosenService.getAllMasterDosen());
		return mav;
	}
	
	@RequestMapping(value="/updateDosen", method=RequestMethod.GET)
	public ModelAndView EditForm(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("detailkelasEdit");
		//KelasPerkuliahan kelasPerkuliahan = kelasService.getKelasPerkuliahan(id);
		ListDosenKelas listDosenKelas = ListDosenKelasService.getListDosenKelas(id);
		
		mav.addObject("detailkelasEdit", listDosenKelas);
		//map.put("listDosenList", listDosenKelas);
		map.put("dosenList", MasterDosenService.getAllMasterDosen());
		return mav;
	}
	
	
	@RequestMapping(value="/updateKelas", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("kelasviewEdit");
		KelasPerkuliahan kelasPerkuliahan = kelasService.getKelasPerkuliahan(id);
		
		mav.addObject("kelasviewEdit", kelasPerkuliahan);
		map.put("taList", reffTahunAjaranService.getAllReffTahunAjaranByAktivasi(true));
		
		List<ListSemesterPerkuliahan> ls =  listAktivasiService.findTrue(true);
		for(ListSemesterPerkuliahan lt : ls)
		{
			List<ListMatakuliah> s = listMatkulService.getAllListMatakuliahByIdKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId())));
			map.put("matkulList", s);
			map.put("prodiId", MasterKurikulumService.getMasterKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()))));
		}	
		return mav;
	}
	
	@RequestMapping(value="/updateKelas", method=RequestMethod.POST)
	public String update(@ModelAttribute("kelasviewEdit") KelasPerkuliahan kelasPerkuliahan, BindingResult result, SessionStatus status)
	{
		for(ListSemesterPerkuliahan lt : listAktivasiService.findTrue(true))
		{
			kelasPerkuliahan.setMasterKurikulum(lt.getMasterKurikulum());
		}
		kelasService.edit(kelasPerkuliahan);
		status.setComplete();
		return "redirect:kelas";
	}
	
	
	@RequestMapping(value="/kelas.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute KelasPerkuliahan kelasPerkuliahan,@ModelAttribute("detailkelasAdd") ListDosenKelas listDosenKelas, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		KelasPerkuliahan kelasPerkuliahanResult = new KelasPerkuliahan();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":
					for(ListSemesterPerkuliahan lt : listAktivasiService.findTrue(true))
					{
						kelasPerkuliahan.setMasterKurikulum(lt.getMasterKurikulum());
					}
					kelasService.add(kelasPerkuliahan);
					status.setComplete();
					kelasPerkuliahanResult = kelasPerkuliahan;
					//model.addAttribute("kelas",new KelasPerkuliahan());
					break;
				case "tambah dosen":	
					//System.out.println("Masuk "+listDosenKelas.getMasterDosen().getId()+" "+listDosenKelas.getKelasPerkuliahan().getId());
					ListDosenKelasService.add(listDosenKelas);
					status.setComplete();
					kelasPerkuliahanResult = kelasPerkuliahan;
					break;
					
				case "edit dosen":
					ListDosenKelasService.edit(listDosenKelas);
					status.setComplete();
					kelasPerkuliahanResult = kelasPerkuliahan;
					break;
					/*
				case "delete":
					listMatkulService.delete(Integer.parseInt(String.valueOf(listmatkulResult.getId())));
					listmatkulResult = new ListMatakuliah();
					break;
				case "search":
					ListMatakuliah searchedListMatakuliah = listMatkulService.getListMatakuliah(Integer.parseInt(String.valueOf(listmatkul.getId())));
					listmatkulResult = searchedListMatakuliah!=null ? searchedListMatakuliah: new ListMatakuliah();
					break;*/
				case "batal":
						status.setComplete();
						kelasPerkuliahanResult = kelasPerkuliahan;
					break;
					
		}
		map.put("kelas", kelasPerkuliahanResult);
		map.put("kelasList", kelasService.getAllKelasPerkuliahan());
		List<ListSemesterPerkuliahan> ls =  listAktivasiService.findTrue(true);
	
		for(ListSemesterPerkuliahan lt : ls)
		{
			List<ListMatakuliah> s = listMatkulService.getAllListMatakuliahByIdKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId())));			
			map.put("matkulList", s);
			map.put("prodiId", MasterKurikulumService.getMasterKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()))));
		}
		
		return "redirect:kelas";
	}
	
	
	@RequestMapping("deleteKelas")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ListDosenKelasService.deleteByIdKelas(id);
		kelasService.delete(id);
		return "redirect:kelas";
	}
	
	@RequestMapping("deleteDosen")
	public String deleteFormDosen(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		KelasPerkuliahan kelasPerkuliahanResult = new KelasPerkuliahan();
		ListDosenKelasService.delete(id);
		kelasPerkuliahanResult = new KelasPerkuliahan();
		map.put("kelas", kelasPerkuliahanResult);
		map.put("kelasList", kelasService.getAllKelasPerkuliahan());
		List<ListSemesterPerkuliahan> ls =  listAktivasiService.findTrue(true);
	
		for(ListSemesterPerkuliahan lt : ls)
		{
			List<ListMatakuliah> s = listMatkulService.getAllListMatakuliahByIdKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId())));			
			map.put("matkulList", s);
			map.put("prodiId", MasterKurikulumService.getMasterKurikulum(Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()))));
		}
		
		return "redirect:kelas";
	}
	
}

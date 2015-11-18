package com.sofa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sofa.model.stimb2.MasterDosen;
import com.sofa.model.stimb2.NilaiMahasiswa;
import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.service.MasterMahasiswaService;
import com.sofa.service.NilaiMahasiswaService;
import com.sofa.service.KrsService;

@Controller
//@RequestMapping(value="/nilai")
public class NilaiMahasiswaController 
{
	@Autowired
	private NilaiMahasiswaService nilaiMahasiswaService;
	
	@Autowired
	private MasterMahasiswaService masterMahasiswaService;
	
	@Autowired
	private KrsService krsService;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
		
	@RequestMapping(value="/insertNilai", method=RequestMethod.GET)
	public ModelAndView editNilai(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("nilaimhsviewEdit");
		mav.addObject("nilaimhsviewEdit", krsService.getKartuRencanaStudi(id));
		
		return mav;
	}
	
	@RequestMapping(value="/insertNilai", method=RequestMethod.POST)
	public String update(@ModelAttribute("nilaimhsviewEdit") KartuRencanaStudi krs, BindingResult result, SessionStatus status)
	{
		krsService.edit(krs);
		status.setComplete();
		return "redirect:updateKrs.do?idMhs="+krs.getMasterMahasiswa().getId()+"&idTa="+krs.getReffTahunAjaran().getId();
	}
	
	/*
	@RequestMapping(value="/mahasiswa/{nimm}", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MasterMahasiswa> getMhs(@PathVariable String nimm, Map<String, Object> map)
	{
		List<MasterMahasiswa> idnya = masterMahasiswaService.getMasterMahasiswaByNim(nimm);
		
		for(MasterMahasiswa d : idnya)
		{
			this.nim = d.getId();
		}
		return idnya;
	}
	
	@RequestMapping(value = "/cetakpdf", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(HttpServletResponse response, @RequestParam("idMhs")Integer idMhs,@RequestParam("npm")Integer npmMhs, @RequestParam("idTa")Integer idTa, @RequestParam("status")Integer status) throws JRException, IOException 
	{
		String namaFile = "", jenis="";
        if(status==1)
        {
        	namaFile = "krsLama.jasper";
        	System.out.println(namaFile);
        }
        else if(status==2)
        {
        	namaFile = "krsBaru.jasper";
        	jenis = "baru-";
        	System.out.println(namaFile);
        }
        else if(status==3)
        {
        	namaFile = "pkrs.jasper";
        	jenis = "pkrs-";
        	System.out.println(namaFile);
        }
        else if(status==4)
        {
        	namaFile = "drafkrs.jasper";
        	jenis = "draf-";
        	System.out.println(namaFile);
        }
        
		try 
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
               
            InputStream jasperStream = this.getClass().getClassLoader().getResourceAsStream("com/sofa/jasper/"+namaFile);
		    
		    Map<String,Object> params = new HashMap<>();
		    params.put("idMhs",idMhs);
		    params.put("idTa",idTa);
		    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
	
		    response.setContentType("application/x-pdf");
		    response.setHeader("Content-disposition", "inline; filename="+jenis+"krs-"+npmMhs+".pdf");
	
		    final OutputStream outStream = response.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	  
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	
	@RequestMapping(value="/updateKrs", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("idMhs")Integer idMhs,@RequestParam("idTa")Integer idTa, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("krsviewEdit");
		List<KartuRencanaStudi> kartuRencanaStudi= KrsService.getAllKartuRencanaStudiByMhsId(idMhs,idTa);
		String keteranganKrs = "", statusKrsdisetujui = "", statusPKrsdisetujui = "";
		boolean statusAmbilKrsbool = false ;
		ReffTahunAjaran thn = new ReffTahunAjaran();
		for(KartuRencanaStudi v : kartuRencanaStudi)
		{
			thn.setId(v.getReffTahunAjaran().getId());
			thn.setNamaTahunAjaran(v.getReffTahunAjaran().getNamaTahunAjaran());
			thn.setPeriode(v.getReffTahunAjaran().getPeriode());
			keteranganKrs = v.getKeterangan();
			statusAmbilKrsbool = v.isAmbilpkrs();
			statusKrsdisetujui = v.getStatusPKRS();
			statusPKrsdisetujui = v.getStatusPKRS();
		}
		
		map.put("krsList", kartuRencanaStudi);
		map.put("mhsList", masterMahasiswaService.getMasterMahasiswa(idMhs));
		map.put("taList", thn);
		map.put("krsStatus", keteranganKrs);
		map.put("statusKrsdisetujui", statusKrsdisetujui);
		map.put("statusPKrsdisetujui", statusPKrsdisetujui);
		map.put("statusAmbilKrs", statusAmbilKrsbool);
		
		return mav;
	}
	
	@RequestMapping(value="/pkrs", method=RequestMethod.GET)
	public ModelAndView editPkrs(@RequestParam("idMhs")Integer idMhs,@RequestParam("idTa")Integer idTa,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("pkrsviewEdit");
		KrsService.editStatusAmbilPkrs(idMhs, idTa);
		List<KartuRencanaStudi> kartuRencanaStudi= KrsService.getAllKartuRencanaStudiByStatusAmbil(idMhs, idTa, true);
		String keteranganKrs = "", keteranganPKrs ="",statusPKrsdisetujui = "";
		boolean statusAmbilKrs = false ;
		ReffTahunAjaran thn = new ReffTahunAjaran();
		for(KartuRencanaStudi v : kartuRencanaStudi)
		{
			thn.setId(v.getReffTahunAjaran().getId());
			thn.setNamaTahunAjaran(v.getReffTahunAjaran().getNamaTahunAjaran());
			thn.setPeriode(v.getReffTahunAjaran().getPeriode());
			keteranganKrs = v.getKeterangan();
			keteranganPKrs = v.getStatusPKRS();
			statusAmbilKrs = v.isAmbilpkrs();
		}
		
		map.put("krsList", kartuRencanaStudi);
		map.put("mhsList", masterMahasiswaService.getMasterMahasiswa(idMhs));
		map.put("taList", thn);
		map.put("krsStatus", keteranganKrs);
		map.put("pkrsStatus", keteranganPKrs);
		map.put("statusAmbilKrs", statusAmbilKrs);
		return mav;
	}
	
	@RequestMapping("setujui")
	public String setujuiForm(@RequestParam("idTa")int idta,@RequestParam("idMhs")int idmhs,Map<String, Object> map)
	{
		KrsService.editSetujui(idta, idmhs);
		//return "redirect:updateKrs?id="+idmhs; 
		return "redirect:updateKrs?idMhs="+idmhs+"&idTa="+idta; //
	}
	
	@RequestMapping("setujuiPkrs")
	public String setujuiPkrsForm(@RequestParam("idTa")int idta,@RequestParam("idMhs")int idmhs,Map<String, Object> map)
	{
		KrsService.editSetujuiPkrs(idta, idmhs);
		return "redirect:pkrs?idMhs="+idmhs+"&idTa="+idta;
	}
	*/
	
	/*
	@RequestMapping(value="/updateDosen", method=RequestMethod.POST)
	public String update(@ModelAttribute("lecturerviewEdit") MasterDosen masterDosen, BindingResult result, SessionStatus status)
	{
		masterDosenService.edit(masterDosen);
		status.setComplete();
		return "redirect:dosen";
	}
	*/
	/*
	@RequestMapping(value="/krs.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute("krs") KartuRencanaStudiForm kartuRencanaStudiForm, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		KartuRencanaStudi krsResult = new KartuRencanaStudi();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":		
					
					Long idThn = null, idMhs = null;
					List<ReffTahunAjaran> tahunAjarans = reffTahunAjaranService.getAllReffTahunAjaranByAktivasi(true);
					for(ReffTahunAjaran ajaran : tahunAjarans)
					{
						idThn = ajaran.getId();
					}
					
					List<KartuRencanaStudi> krss = kartuRencanaStudiForm.getKartuRencanaStudis();
					for(KartuRencanaStudi a : krss)
					{
						try 
						{
								System.out.println(this.nim+" "+a.getKelasPerkuliahan().getId()+" "+idThn);
								
								MasterMahasiswa m = new MasterMahasiswa();
								m.setId(this.nim);
								
								ReffTahunAjaran t = new ReffTahunAjaran();
								t.setId(idThn);
								
								a.setMasterMahasiswa(m);
								a.setReffTahunAjaran(t);
								a.setKeterangan("Belum Disetujui");
								KrsService.add(a);
								
						} 
						catch (Exception e)
						{	
						}
					}
					status.setComplete();
					break;
				/*	
				case "tambah":
					masterDosenService.add(masterDosen);
					status.setComplete();
					masterDosenResult = masterDosen;
					model.addAttribute("dosen",new MasterDosen());
					break;
				case "edit":
					masterDosenService.edit(masterDosen);
					masterDosenResult = masterDosen;
					model.addAttribute("dosen",new MasterDosen());
					break;
				case "delete":
					masterDosenService.delete(Integer.parseInt(String.valueOf(masterDosen.getId())));
					masterDosenResult = new MasterDosen();
					break;
				case "search":
					MasterDosen searchedmasterDosen = masterDosenService.getMasterDosen(Integer.parseInt(String.valueOf(masterDosen.getId())));
					masterDosenResult = searchedmasterDosen!=null ? searchedmasterDosen: new MasterDosen();
					break;
				case "back":
					model.addAttribute("dosen",new MasterDosen());
					break;
					
		}
		return "redirect:krs";
	}
	
	@RequestMapping("deleteKrs")
	public String deleteKrs(@RequestParam("idmhs")Integer idmhs,@RequestParam("idta")Integer idta,Map<String, Object> map)
	{
		KrsService.deleteKrsMhs(idmhs, idta);
		return "redirect:krs";
	}
	
	@RequestMapping("pKrsMatkul")
	public String deletepKrsMatkul(@RequestParam("id")Integer id,@RequestParam("idmhs")Integer idmhs,@RequestParam("idta")Integer idta,Map<String, Object> map)
	{
		KrsService.editMatkulPkrs(id,idmhs, idta);
		return "redirect:pkrs?idMhs="+idmhs+"&idTa="+idta;
	}
	
	@RequestMapping("deleteKrsMatkul")
	public String deleteForm(@RequestParam("id")Integer id,@RequestParam("idmhs")Integer idmhs,@RequestParam("idta")Integer idta,Map<String, Object> map)
	{
		KrsService.delete(id);
		System.out.println(idmhs);
		return "redirect:updateKrs?idMhs="+idmhs+"&idTa="+idta; //
	}	
	*/
}

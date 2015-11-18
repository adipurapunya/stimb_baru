package com.sofa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
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
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.model.stimb2.KartuRencanaStudiForm;
import com.sofa.model.stimb2.KelasPerkuliahan;
import com.sofa.model.stimb2.ListDosenKelas;
import com.sofa.model.stimb2.ListMatakuliah;
import com.sofa.model.stimb2.ListMatakuliahForm;
import com.sofa.model.stimb2.ListPrequisiteMatakuliah;
import com.sofa.model.stimb2.ListSemesterPerkuliahan;
import com.sofa.model.stimb2.MasterMahasiswa;
import com.sofa.model.stimb2.ReffTahunAjaran;
import com.sofa.service.KrsService;
import com.sofa.service.ListAktivasiService;
import com.sofa.service.ListDosenKelasService;
import com.sofa.service.ListMatkulService;
import com.sofa.service.KelasService;
import com.sofa.service.MasterMahasiswaService;
import com.sofa.service.ReffTahunAjaranService;
import com.sofa.service.ListPrequisiteService;
import com.sofa.service.NilaiMahasiswaService;

@Controller
//@RequestMapping(value="/krss")
public class KrsController 
{
	@Autowired
	private KrsService KrsService;
	
	@Autowired
	private MasterMahasiswaService masterMahasiswaService;
	
	@Autowired
	private ListAktivasiService listAktivasiService;
	
	@Autowired
	private KelasService kelasService;
	
	@Autowired
	private ListMatkulService listMatkulService;
	
	@Autowired
	private ReffTahunAjaranService reffTahunAjaranService;
	
	@Autowired
	private ListDosenKelasService ListDosenKelasService;
	
	@Autowired
	private ListPrequisiteService listPrequisiteService;
	
	@Autowired
	private NilaiMahasiswaService nilaiMahasiswaService;
	
	public Long nim ;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/krs", "/KRS"})
	public String setupForm(Map<String, Object> map)
	{
		int ids = 0;
		List<ListSemesterPerkuliahan> ls =  listAktivasiService.findTrue(true);
		for(ListSemesterPerkuliahan lt : ls)
		{
			ids = Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()));
		}
		
		KartuRencanaStudiForm kartuRencanaStudiForm = new KartuRencanaStudiForm();
		kartuRencanaStudiForm.setKartuRencanaStudis(new ArrayList<KartuRencanaStudi>());
		kartuRencanaStudiForm.setKelasPerkuliahans(kelasService.getAllKelasPerkuliahanByIdKurikulum(ids));
		
		map.put("kelasList", kartuRencanaStudiForm);
		map.put("krsList", KrsService.getAllKartuRencanaStudiSql());
		map.put("tahunajaranList", reffTahunAjaranService.getAllReffTahunAjaran());
		
		return "krsview";
	}
	
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
	public void getRpt1(HttpServletResponse response, @RequestParam("idMhs")Integer idMhs,@RequestParam("npm")String npmMhs, @RequestParam("idTa")Integer idTa, @RequestParam("status")Integer status) throws JRException, IOException 
	{
		String namaFile = "", jenis="";
        if(status==1)
        {
        	namaFile = "krsLama.jasper";
        	//System.out.println(namaFile);
        }
        else if(status==2)
        {
        	namaFile = "krsBaru.jasper";
        	jenis = "baru-";
        	//System.out.println(namaFile);
        }
        else if(status==3)
        {
        	namaFile = "pkrs.jasper";
        	jenis = "pkrs-";
        	//System.out.println(namaFile);
        }
        else if(status==4)
        {
        	namaFile = "drafkrs.jasper";
        	jenis = "draf-";
        	//System.out.println(namaFile);
        }
        else if(status==5)
        {
        	namaFile = "khs.jasper";
        	jenis = "khs-";
        	//System.out.println(namaFile);
        }
        else if(status==6)
        {
        	namaFile = "drafpkrs.jasper";
        	jenis = "drafpkrs-";
        	//System.out.println(namaFile);
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
	
	@RequestMapping(value="/addNewMatkul", method=RequestMethod.GET)
	public ModelAndView addNewMatkul(@RequestParam("idMhs")Integer idMhs,@RequestParam("idTa")Integer idTa, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("krsviewAdd");	
		int ids = 0;
		List<ListSemesterPerkuliahan> ls =  listAktivasiService.findTrue(true);
		for(ListSemesterPerkuliahan lt : ls)
		{
			ids = Integer.parseInt(String.valueOf(lt.getMasterKurikulum().getId()));
		}
		
		KartuRencanaStudiForm kartuRencanaStudiForm = new KartuRencanaStudiForm();
		kartuRencanaStudiForm.setKartuRencanaStudis(new ArrayList<KartuRencanaStudi>());
		kartuRencanaStudiForm.setKelasPerkuliahans(kelasService.getAllKelasPerkuliahanByIdKurikulum(ids));
		
		map.put("kelasList", kartuRencanaStudiForm);
		map.put("mhsList",masterMahasiswaService.getMasterMahasiswa(idMhs));
		map.put("idMhs",idMhs);
		this.nim=Long.parseLong(String.valueOf(idMhs));
		map.put("idTa",reffTahunAjaranService.getReffTahunAjaran(idTa));
		return mav;
	}
	
	@RequestMapping(value="/addNewMatkul", method=RequestMethod.POST)
	public String addNewMatkul(/*@RequestParam("idTa")int idta,@RequestParam("idMhs")int idmhs,Map<String, Object> map,*/@ModelAttribute("krsviewAdd") KartuRencanaStudiForm kartuRencanaStudiForm, SessionStatus status)
	{
		Long idThn = null;
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
					a.setStatusambil(3);
					KrsService.add(a);
					
			} 
			catch (Exception e)
			{	
			}
		}
		status.setComplete();
		return "redirect:updateKrs.do?idMhs="+this.nim+"&idTa="+idThn;
	}
	
	@RequestMapping(value="/updateKrs", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("idMhs")Integer idMhs,@RequestParam("idTa")Integer idTa, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("krsviewEdit");
		List<KartuRencanaStudi> kartuRencanaStudi= KrsService.getAllKartuRencanaStudiByMhsId(idMhs,idTa);
		String keteranganKrs = "", statusKrsdisetujui = "", statusPKrsdisetujui = "";
		Integer statusAmbilpKrsbool = 1;
		ReffTahunAjaran thn = new ReffTahunAjaran();
		for(KartuRencanaStudi v : kartuRencanaStudi)
		{
			thn.setId(v.getReffTahunAjaran().getId());
			thn.setNamaTahunAjaran(v.getReffTahunAjaran().getNamaTahunAjaran());
			thn.setPeriode(v.getReffTahunAjaran().getPeriode());
			keteranganKrs = v.getKeterangan();
			statusAmbilpKrsbool = v.getAmbilpkrs();
			statusKrsdisetujui = v.getStatusPKRS();
			statusPKrsdisetujui = v.getStatusPKRS();
		}
		
		map.put("krsList", kartuRencanaStudi);
		map.put("mhsList", masterMahasiswaService.getMasterMahasiswa(idMhs));
		map.put("taList", thn);
		map.put("krsStatus", keteranganKrs);
		map.put("statusKrsdisetujui", statusKrsdisetujui);
		map.put("statusPKrsdisetujui", statusPKrsdisetujui);
		map.put("statusAmbilpKrs", statusAmbilpKrsbool);
		
		return mav;
	}
	
	@RequestMapping(value="/pkrs", method=RequestMethod.GET)
	public ModelAndView editPkrs(@RequestParam("idMhs")Integer idMhs,@RequestParam("idTa")Integer idTa,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("pkrsviewEdit");
		KrsService.editStatusAmbilPkrs(idMhs, idTa);
		List<KartuRencanaStudi> kartuRencanaStudi= KrsService.getAllKartuRencanaStudiByStatusAmbil(idMhs, idTa, 1);
		String keteranganKrs = "", keteranganPKrs ="";
		Integer statusAmbilpKrsbool = 1;
		ReffTahunAjaran thn = new ReffTahunAjaran();
		for(KartuRencanaStudi v : kartuRencanaStudi)
		{
			thn.setId(v.getReffTahunAjaran().getId());
			thn.setNamaTahunAjaran(v.getReffTahunAjaran().getNamaTahunAjaran());
			thn.setPeriode(v.getReffTahunAjaran().getPeriode());
			keteranganKrs = v.getKeterangan();
			keteranganPKrs = v.getStatusPKRS();
			statusAmbilpKrsbool = v.getAmbilpkrs();
		}
		
		map.put("krsList", kartuRencanaStudi);
		map.put("mhsList", masterMahasiswaService.getMasterMahasiswa(idMhs));
		map.put("taList", thn);
		map.put("krsStatus", keteranganKrs);
		map.put("pkrsStatus", keteranganPKrs);
		map.put("statusAmbilpKrs", statusAmbilpKrsbool);
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
	
	@RequestMapping(value="/krs.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute("krs") KartuRencanaStudiForm kartuRencanaStudiForm, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		KartuRencanaStudi krsResult = new KartuRencanaStudi();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":		
					
					Long idThn = null;
					List<ReffTahunAjaran> tahunAjarans = reffTahunAjaranService.getAllReffTahunAjaranByAktivasi(true);
					
					for(ReffTahunAjaran ajaran : tahunAjarans)
					{
						idThn = ajaran.getId();
					}
					
					List<KartuRencanaStudi> krss = kartuRencanaStudiForm.getKartuRencanaStudis();
					
					for(KartuRencanaStudi a : krss)
					{
						int count = 0 ;
						try 
						{
							KelasPerkuliahan kelas = kelasService.getKelasPerkuliahan(Integer.parseInt(String.valueOf(a.getKelasPerkuliahan().getId())));
							List<ListPrequisiteMatakuliah> prequisite = listPrequisiteService.getAllListPrequisiteMatakuliahByIdMatkul(kelas.getMasterMatakuliah().getId());
								
								if(prequisite!=null)
								{
									try 
									{
										Long idPrequisite = null ;
										for(ListPrequisiteMatakuliah ls : prequisite)
										{
											idPrequisite = ls.getMasterMatakuliahPrequisite().getId();
										}
										List<KartuRencanaStudi> listKul = KrsService.getAllKartuRencanaStudiByMhsIdnyasaja(Integer.parseInt(String.valueOf(this.nim)));
										
										for(KartuRencanaStudi ks : listKul)
										{
											if(idPrequisite.equals(ks.getKelasPerkuliahan().getMasterMatakuliah().getId()))
											{
												if(("D").equals(ks.getNilaiMahasiswa().getNilaiAkhirHuruf()) || ("E").equals(ks.getNilaiMahasiswa().getNilaiAkhirHuruf()))
												{
													System.out.println("NILAI : "+ks.getNilaiMahasiswa().getNilaiAkhirHuruf());
													count++;
												}
											}
										}
									} 
									catch (Exception e) 
									{
									}
									System.out.println("Masuk 1");
								}
								
								if(count==0)
								{
									System.out.println("Msuk 2");
									MasterMahasiswa m = new MasterMahasiswa();
									m.setId(this.nim);
									
									ReffTahunAjaran t = new ReffTahunAjaran();
									t.setId(idThn);
									
									a.setMasterMahasiswa(m);
									a.setReffTahunAjaran(t);
									a.setKeterangan("Belum Disetujui");
									KrsService.add(a);
								}
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
					*/
		}
		return "redirect:krs";
	}
	
	@RequestMapping("deleteKrs")
	public String deleteKrs(@RequestParam("idmhs")Integer idmhs,@RequestParam("idta")Integer idta,Map<String, Object> map)
	{
		KrsService.deleteKrsMhs(idmhs, idta);
		//KrsService.deleteNilaiMhs(idmhs, idta);
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
		KartuRencanaStudi krs = KrsService.getKartuRencanaStudi(id);
		int idNilai = Integer.parseInt(String.valueOf(krs.getNilaiMahasiswa().getId()));
		KrsService.delete(id);
		nilaiMahasiswaService.delete(idNilai);
		//System.out.println(idmhs);
		return "redirect:updateKrs?idMhs="+idmhs+"&idTa="+idta; //
	}	
	
}

/*
$(document).ready(function(){
  sendAjax();
});
 
function sendAjax() {
 
$.ajax({ 
    url: "/kelass", 
    type: 'POST', 
    dataType: 'json', 
    data: "{\"title\":\"hmkcode\",\"url\":\"http:yahoo.com\",\"categories\":\"loreng\",\"tags\":\"jsp\"}", 
    contentType: 'application/json',
    mimeType: 'application/json',
    success: function(data) { 
        alert(data.title + " " + data.categories);
    },
    error:function(data,status,er) { 
        alert("error: "+data+" status: "+status+" er:"+er);
    }
});
}

*/

function show() { 
        if(document.getElementById('coba').style.display=='none') { 
            document.getElementById('coba').style.display='block'; 
        } 
        return false;
    } 
    function hide() { 
        if(document.getElementById('coba').style.display=='block') { 
            document.getElementById('coba').style.display='none'; 
        } 
        return false;
    }  

function hideAjax() 
{
	document.getElementById("coba").style.display = 'none';
}


function showAjax() 
{
	document.getElementById("coba").style.display = 'block';
}

function deleteAjax() 
{
	$("#tabel1 tr").has("td").remove();
	$("#tabel2 tr").has("td").remove();
	hide();
	document.getElementById("nimMhs").value="";
}

function sendAjax() 
{	
	var nim = document.getElementById("nimMhs").value;

    $.ajax({
        url: "mahasiswa/"+nim+".json",
        type: 'POST',
        beforeSend: function(xhr) 
        {
    		xhr.setRequestHeader("Accept", "application/json");
    		xhr.setRequestHeader("Content-Type", "application/json");
    	},
        success: function (krss) 
        {
        	$("#tabel1 tr").has("td").remove();
        	$("#tabel2 tr").has("td").remove();
        	
        	var baris11 = "<tr>"; 
        	var baris21 = "<tr>"; 
        	var baris31 = "<tr>";
        	//var baris41 = "<tr>";
        	var baris12 = "<tr>";
        	var baris22 = "<tr>";
        	var baris32 = "<tr>";
        	//var baris42 = "<tr>";
        	
        	$(krss).each(function(i, value)
        	{
        		$(value).each(function(i, value2)
        		{
        			baris11 += 	"<td align='right'><label class='control-label' for='nama'>NAMA</label></td>";
        			baris11 +=  "<td>&nbsp;&nbsp;</td>";
        			baris11 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.nama+"' class='form-control'></td>";
        			baris11 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			baris21 += 	"<td align='right'><label class='control-label' for='npm'>NPM</label></td>";
        			baris21 +=  "<td>&nbsp;&nbsp;</td>";
        			baris21 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.npm+"' class='form-control'></td>";
        			baris21 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			baris31 += 	"<td align='right'><label class='control-label' for='status'>MAYOR</label></td>";
        			baris31 +=  "<td>&nbsp;&nbsp;</td>";
        			baris31 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.reffInstrumentMayor.namaInstrumentMayor+"-"+value2.reffInstrumentMayor.kodeInstrumentMayor+"' class='form-control'></td>";
        			baris31 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			//baris41 += 	"<td align='right'><label class='control-label' for='status'>TAHUN AJARAN</label></td>";
        			//baris41 +=  "<td>&nbsp;&nbsp;</td>";
        			//baris41 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.+"' class='form-control'></td>";
        			//baris41 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			baris12 += 	"<td align='right'><label class='control-label' for='prodi'>PRODI</label></td>";
        			baris12 +=  "<td>&nbsp;&nbsp;</td>";
        			baris12 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.reffProgramStudi.namaProgramStudi+"' class='form-control'></td>";
        			baris12 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			baris22 += 	"<td align='right'><label class='control-label' for='angkatan'>ANGKATAN</label></td>";
        			baris22 +=  "<td>&nbsp;&nbsp;</td>";
        			baris22 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.angkatann.tahun+"' class='form-control'></td>";
        			baris22 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			baris32 += 	"<td align='right'><label class='control-label' for='batasstudi'>DOSEN WALI</label></td>";
        			baris32 +=  "<td>&nbsp;&nbsp;</td>";
        			baris32 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.angkatann.masterDosen.nama+"' class='form-control'></td>";
        			baris32 +=	"<td>&nbsp;&nbsp;</td>";
        			
        			//baris42 += 	"<td align='right'><label class='control-label' for='batasstudi'>DOSEN WALI</label></td>";
        			//baris42 +=  "<td>&nbsp;&nbsp;</td>";
        			//baris42 +=  "<td align='right'><input type='text' disabled='disabled' value='"+value2.angkatann.masterDosen.nama+"' class='form-control'></td>";
        			//baris42 +=	"<td>&nbsp;&nbsp;</td>";
        		})        		
        		baris11 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>"; 
        		baris21 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        		baris31 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        		//baris41 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        		
        		baris12 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        		baris22 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        		baris32 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        		//baris42 += "</tr><tr><td>&nbsp;&nbsp;</td></tr>";
        	});
        	
    		$("#tabel1").append(baris11);
    		$("#tabel1").append(baris21);
    		$("#tabel1").append(baris31);
    		//$("#tabel1").append(baris41);
        	$("#tabel2").append(baris12);
        	$("#tabel2").append(baris22);
        	$("#tabel2").append(baris32);
        	//$("#tabel2").append(baris42);
        	
        	if(document.getElementById('coba').style.display=='none') { 
                document.getElementById('coba').style.display='block'; 
            } 
        },
        error:function(data,status,er) {
            alert("error: "+ids+" status: "+status+" er:"+er);
        }
    });
}
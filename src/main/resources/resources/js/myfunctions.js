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


function sendAjax() {
 
    // get inputs
	/*
    var article = new Object();
    article.namaInstrumentMayor = $('#nama').val();
    article.kodeInstrumentMayor = $('#kode').val().split(";");
    article.prodiInstrumentMayor = $('#prodi').val().split(";");
    */
    //var namaInstrumentMayor = $('#nama').val();
	//var kodeInstrumentMayor = $('#kode').val();
	//var prodiInstrumentMayor = $('#prodi').val();
	
	var e = document.getElementById("matkul");
	var indikator = document.getElementById("indikator").value;
	var ids = e.options[e.selectedIndex].value;
	var d = false;
	//var ids = $('#masterMatakuliah').val();
	
	//var json = { "masterMatakuliah" : [{"id":ids}], "reffInstrumentMayor" : [{"id":null}]};
 
    $.ajax({
        url: "create/"+ids+".json",
        type: 'POST',
        //data: JSON.stringify(json),
        beforeSend: function(xhr) 
        {
    		xhr.setRequestHeader("Accept", "application/json");
    		xhr.setRequestHeader("Content-Type", "application/json");
    	},
        success: function (classes) 
        {
        	$("#added-articles2 tr").has("td").remove();
        	//$("#added-articles2 tr").has("th").remove();
        	//$("#added-articles2").has("tr").remove();
        	//var tr = "<tr><th>Kode</th><th>Mayor</th><th>Pilih</th></tr> <tr>";
        	var tr = "<tr>";  
        	$(classes).each(function(i, value)
        	{
        		$(value).each(function(i, value2)
        		{
        			tr += "<td>"+value2.reffInstrumentMayor.kodeInstrumentMayor+"</td>";
            		tr += "<td>"+value2.reffInstrumentMayor.namaInstrumentMayor+"</td>";
            		//tr += "<td><form:radiobutton path='instrumentMayor.id' value='"+value2.reffInstrumentMayor.id+"'/></td>";
            		tr += "<td> <input type='radio' id='"+"_"+value2.reffInstrumentMayor.id+"' name='instrumentMayor.id' value='"+value2.reffInstrumentMayor.id+"'></td>"
            		if(indikator==value2.reffInstrumentMayor.id)
            		{
            			d=true;
            		}
        		})        		
        		tr += "</tr>";
        	});
        	$("#added-articles2").append(tr);
        	
        	if(d==true)
        	{
        		document.getElementById("_"+indikator).checked = true;
        	}
        },
        error:function(data,status,er) {
            alert("error: "+ids+" status: "+status+" er:"+er);
        }
    });
}
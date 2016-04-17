/**
 * Created by Hemantc09 on 11/20/15.
 */

//function calldata() {
$("button").click(function() {

    alert("hi");
    alert(this.id); // or alert($(this).attr('id'));
});

function submitRequest(i)
{

    var obj = JSON.parse(sessionStorage.getItem('availableTrips'));
    var objstring = JSON.stringify(obj[i]);
    alert(objstring);

}



$(document).ready(function () {
    //   var objtrip = (sessionStorage.getItem('availableTrips'));//get the json object

    var obj = JSON.parse(sessionStorage.getItem('availableTrips'));
    alert("Number of trips" + obj.length);
    var numberOftrips = obj.length; //get the number of trips
    //var objstring = JSON.stringify(obj);

    var tr=[];
    for (var i = 0; i < obj.length; i++) {
        tr.push('<tr>');
        tr.push("<td>" + obj[i].startLocation + "</td>");
        tr.push("<td>" + obj[i].destination + "</td>");
        tr.push("<td>" + obj[i].tripType + "</td>");
        tr.push("<td>" + obj[i].tripTime + "</td>");
        tr.push("<td>" + obj[i].tripDate + "</td>");
        //tr.push("<td>"+ "<button id=\"" + i + "\" onClick=\""+submitRequest+"(this.id)\"> submit</button>"); //onclick=\"submitRequest();\">");
        tr.push("<td>"+ "<button id=\""+i+"\"  onClick=\"submitRequest(this.id)\"> submit</button>"); //onclick=\"submitRequest();\">");
        tr.push('</tr>');
    }
    $('tbody').append($(tr.join('')));


});



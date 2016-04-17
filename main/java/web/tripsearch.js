/**
 * Created by Hemantc09 on 11/20/15.
 */




function tripsearchvalidation() {
    //document.getElementById('loginfailed').style.display = 'none';
    var error = 0;
    if (!sourcevalidation('source')) {
        document.getElementById('sourceError').style.display = 'block';
        error++;
    }
    if(!destinationvalidation('destination'))
    {
        document.getElementById('destinationError').style.display='block';
        error++
    }
    if(error==0)
    {
       // Logincheck();
      //  alert('success');
        getTripData();
       // document.getElementById('loginfailed').style.display='none';
    }
    else
    {
        //alert('error')
        // document.getElementById('loginfailed').style.display='block';
    }
}
function sourcevalidation(source)
{

    var re = /[A-Za-z -']$/;
    // Check input
    if(re.test(document.getElementById(source).value)){
        // Style green
        document.getElementById(source).style.background ='#ccffcc';
        // Hide error prompt
        document.getElementById(source + 'Error').style.display = "none";
        return true;
    }else{
        // Style red
        document.getElementById(source).style.background ='#e35152';
        // Show error prompt
        document.getElementById(source + 'Error').style.display = "block";
        return false;
    }
    //document.getElementById('loginfail').style.display='none';
}
function destinationvalidation(destination)
{

  //  document.getElementById('loginfailed').style.display='none';
    var re = /[A-Za-z -']$/;
    // Check input
    if(re.test(document.getElementById(destination).value)){
        // Style green
        document.getElementById(destination).style.background ='#ccffcc';
        // Hide error prompt
        document.getElementById(destination + 'Error').style.display = "none";
        return true;
    }else{
        // Style red
        document.getElementById(destination).style.background ='#e35152';
        // Show error prompt
        document.getElementById(destination + 'Error').style.display = "block";
        return false;
    }
}

function getTripData()
{

    //alert("trips are:");
    var comfrom =document.getElementById("source").value;
    var comto=document.getElementById("destination").value;


    var JSONObjectSearchTrip= {
        startLocation:comfrom,
        destination:comto
    };


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/shareonwheels/v1/tripper",
        traditional: true,
        data: JSON.stringify(JSONObjectSearchTrip),
        contentType: "application/json",
        traditional:true,
        // cache: false,
        //ifModified: true,
        //  cache: true
        success: function (data) {
           var obj1=JSON.stringify(data);
            var objparse = JSON.parse(obj1);
            sessionStorage.setItem("availableTrips", obj1);
            if(obj1=='[]')
            {

                document.getElementById('NotripsError').style.display='block';

            }
            else {
                document.getElementById('NotripsError').style.display='none';
                tripSuccessRedirect();
            }
        },
        error: function (response) {

            alert("No trips available");
            tripFailRedirect();

        }
    });

}


function tripSuccessRedirect(obj) {

   window.location.assign("tripdisplay.html");
//    document.getElementById("trip").value=obj.typeOfTrip;


}

function tripFailRedirect()
{
    window.location.assign("tripsearch.html")
}


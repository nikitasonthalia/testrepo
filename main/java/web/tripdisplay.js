/**
 * Created by Hemantc09 on 11/20/15.
 */

//function calldata() {
//var  obj;
var  objLoginuser;
var jsontripid,jsonuserid,jsontriptype,jsonusertype;
var useridis;

$(document).ready(function() {

    objLoginuser = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json object
    useridis=objLoginuser.userId;
    obj = JSON.parse(sessionStorage.getItem('availableTrips'));
    document.getElementById("logInUserNameGuest").innerHTML=objLoginuser.firstName;
   // var  objtripdetails = JSON.parse(sessionStorage.getItem('availableTrips')); //get the json object for trip details

   // alert("User id"+objLoginuser.userId);

    var triparray=new Array();
    var i=0;
    for(i=0;i<obj.length;i++)
    {

        trip(obj.tripId,obj.userId,obj.tripType,obj.tripType);
    }

    function trip(tripid,userid,triptype,usertype)
    {
            this.tripid=tripid;
            this.userid=userid;
            this.tripType=triptype;
            this.userType=usertype;

    }



   // document.getElementById("first").value=obj.firstName;

    var jsonUserId=
    {
        "userId":obj.userId
    }


}); // query end here





function submittrip() {
    var tripselected = document.querySelector('input[name = "tripselect"]:checked').value;
   // alert("You have selected " + tripselected +"");

    for(i=0;i<obj.length;i++)
    {
        if(tripselected==obj[i].tripId)
        {
            jsontripid=obj[i].tripId;
            jsonuserid=obj[i].userId
            jsontriptype=obj[i].tripType;
            jsonusertype=obj[i].userType;
        }
    }

    //alert(jsontripid+","+jsonuserid+","+jsontriptype+","+jsonusertype);



sendselectedtripdata();

}
function sendselectedtripdata()
{

    var JSONsendselectedtripdata= {

       "tripId":jsontripid,
        "userId": jsonuserid,
        "tripType": jsontriptype,
        "userType":jsonusertype

      /*  "tripId":"24",
        "userId": "88",
        "userType":"Driver",
        "tripType": "Routine"*/


    }
    //"+useridis+"";
var u="http://localhost:8080/shareonwheels/v1/trip/request/90";
    $.ajax({
        type: "POST",
        url:"http://localhost:8080/shareonwheels/v1/trip/request/"+useridis+"",

        data: JSON.stringify(JSONsendselectedtripdata),
        contentType: "application/json",
        success: function (data) {
            alert("Your trip requested. You will get the mail for more information.");

           //setTimeout(,1000);
           // alert(data.capacity);

            successsubmittrip();
            //sessionStorage.setItem('loogenInuserVehicle', JSON.stringify(JSONsendselectedtripdata)); // we are setting up the session variabl in json format

        },

        error: function (response) {

            //  document.getElementById('loginfailed').style.display='block';

        }

    });
   // alert(url);
}


function successsubmittrip()
{
    //document.getElementById("tripsuccessmsg").value="Your trip registered successfully!"
    window.location.assign("history.html");
}

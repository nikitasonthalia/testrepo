/**
 * Created by N on 12/15/15.
 */
//*********************************** for displaying all history

var jsonUserIdforhistory;
var objhistoryall;
var objhistoryasdriver;
var j; // this is the counter
var idh1;
var flag=true;// to display or hide
var flagdisplay=true;//its for trips are already clicked via user to display
var obj = JSON.parse(sessionStorage.getItem('loogenInuser'));

$(document).ready(function () {

    jsonUserIdforhistory=
    {
        "userId": obj.userId
    };

    $.ajax({
        type: "POST",
        url:"http://localhost:8080/shareonwheels/v1/alltriphistory",
        data: JSON.stringify(jsonUserIdforhistory),
        contentType: "application/json",
        success: function (data)
        {
            sessionStorage.setItem('loogenInuserhistoryall', JSON.stringify(data)); // we are setting up the session variabl in json format
        },
        error: function (response) {
        }
    });

});

function alltriphostory()
{
    objhistoryall = JSON.parse(sessionStorage.getItem('loogenInuserhistoryall'));

    displayallhistory();


    function displayallhistory()
    {

        if (flag == true&&flagdisplay==true)
        {

            display(); // display once and make it visible

        }
        else if(flag==false&&flagdisplay==false)
        {

            for (j = 0; j <= objhistoryall.length; j++)
            {
                document.getElementById("idAllhistory"+j).style.visibility = "hidden";

                flag=true; // setting flag true  to dispplay the all history data
            }
        }
        else if(flag==true&&flagdisplay==false)
        {

            for (j = 0; j <=objhistoryall.length; j++)
            {
                document.getElementById("idAllhistory"+j).style.visibility = "visible";

                flag=false; // setting flag false not   to display the all history data after next click again
            }

        }
        // var newElement;
        function display()
        {
            for( j=0;j<objhistoryall.length;j++)
            {
                idh1 ="idAllhistory"+j;

                newElement = document.createElement('p');
                newElement.setAttribute("id",idh1);
                newElement.style.margin = "25px 25px 25px 25px";
                newElement.style.padding = "25px 25px 25px 25px";
                newElement.style.width = "250px";
                newElement.style.border = "solid";
                newElement.style.background = "white";
                newElement.innerHTML = "<br>Trip Type:" + objhistoryall[j].tripType + "<br>"+
                    "Source: " + objhistoryall[j].startLocation + "<br>"+
                    "Destination:" + objhistoryall[j].destination + "<br>"+
                    "Trip time: " + objhistoryall[j].tripTime + "<br>"+
                    "Trip date: " +objhistoryall[j].tripDate+ "<br>"+
                    //"Day of Week: " +objhistoryall[j].dayOfWeek+ ",<br>";

                document.getElementById("divnooftripshistorytext").appendChild(newElement);

            }




            flag = false; // this flag is for to display i.e visible or hide the history
            flagdisplay=false; // this flag is to display the contents only one time click after next click only set visible or hidden

        }
        document.getElementById(idh1).style.visibility = "visible";
    }
}

////*********************************** for displaying as a driver history

var flag1=true;
var flagdisplay1=true;
var idh2; // counter for for id assigning
//var obj = JSON.parse(sessionStorage.getItem('loogenInuser'));
//var j;
jsonUserIdforhistoryD=
{
    "userId": obj.userId
};
$.ajax({  // this call for loogen In user history as driver
    type: "POST",
    url:"http://localhost:8080/shareonwheels/v1/triphistory/driver",
    data: JSON.stringify(jsonUserIdforhistoryD),
    contentType: "application/json",
    success: function (data1)
    {
        sessionStorage.setItem('loogenInuserhistoryasdriver', JSON.stringify(data1)); // we are setting up the session variabl in json format
        //alert(data1.value);
    },
    error: function (response) {
    }
});
function triphistoryasdriver() {
    objhistoryasdriver = JSON.parse(sessionStorage.getItem('loogenInuserhistoryasdriver'));
    //alert(objhistoryasdriver[0].firstName);
    displayallhistory();


    function displayallhistory()
    {

        if (flag1 == true&&flagdisplay1==true)
        {

            display(); // display once and make it visible

        }
        else if(flag1==false&&flagdisplay1==false)
        {

            for (j = 0; j <= objhistoryasdriver.length; j++){
                //alert(objhistoryasdriver.tripId);
                document.getElementById("iddriver"+j).style.visibility = "hidden";

                flag1=true; // setting flag true  to dispplay the all history data
            }
        }
        else if(flag1==true&&flagdisplay1==false) {

            for (j = 0; j <=objhistoryasdriver.length; j++){
                //alert(objhistoryasdriver.tripId);
                document.getElementById("iddriver"+j).style.visibility = "visible";

                flag1=false; // setting flag false not   to display the all history data after next click again
            }

        }
        function display() {
            for (j = 0; j < objhistoryasdriver.length; j++){
                // for (j = 0; j < 2; j++) {
                idh2 = "iddriver"+j;
                newElement = document.createElement('p');
                newElement.setAttribute("id",idh2);
                newElement.style.margin = "25px 25px 25px 25px";
                newElement.style.padding = "25px 25px 25px 25px";
                newElement.style.width = "250px";
                newElement.style.border = "solid";
                newElement.style.background = "white";
                newElement.innerHTML = "Name: &nbsp;" + objhistoryasdriver[j].first_name + "<br>" +
                    "Source: &nbsp;" + objhistoryasdriver[j].start_Location + "<br>" +
                    "Destination:&nbsp;" + objhistoryasdriver[j].destination + "<br>" +
                    "Trip date:&nbsp; " + objhistoryasdriver[j].tripDate + "<br>" +
                    "Trip time: &nbsp;" + objhistoryasdriver[j].tripTime + "<br>";
                document.getElementById("divnooftripsasadrivertext").appendChild(newElement);
            }
            flag1 = false; // this flag is for to display i.e visible or hide the history
            flagdisplay1=false; // this flag is to display the contents only one time click after next click only set visible or hidden
        }
        document.getElementById(idh2).style.visibility = "visible";
    }
}

////*********************************** for displaying as a rider history

var flag2=true;
var flagdisplay2=true;
var idh3; // counter for for id assigning
//var obj = JSON.parse(sessionStorage.getItem('loogenInuser'));
//var j;
jsonUserIdforhistoryD=
{
    "userId": obj.userId
};
$.ajax({  // this call for loogen In user history as driver
    type: "POST",
    url:"http://localhost:8080/shareonwheels/v1/triphistory/rider",
    data: JSON.stringify(jsonUserIdforhistoryD),
    contentType: "application/json",
    success: function (data2)
    {
        sessionStorage.setItem('loogenInuserhistoryasrider', JSON.stringify(data2)); // we are setting up the session variabl in json format
        //alert(data1.value);
    },
    error: function (response) {
    }
});
function triphistoryasrider() {
    objhistoryasrider = JSON.parse(sessionStorage.getItem('loogenInuserhistoryasrider'));
    //alert(objhistoryasdriver[0].firstName);
    displayallhistory();


    function displayallhistory()
    {

        if (flag2 == true&&flagdisplay2==true)
        {

            display(); // display once and make it visible

        }
        else if(flag2==false&&flagdisplay2==false)
        {

            for (j = 0; j <= objhistoryasrider.length; j++){
                document.getElementById("idrider"+j).style.visibility = "hidden";

                flag2=true; // setting flag true  to dispplay the all history data
            }
        }
        else if(flag2==true&&flagdisplay2==false) {

            for (j = 0; j <=objhistoryasrider.length; j++){
                //alert(objhistoryasdriver.tripId);
                document.getElementById("idrider"+j).style.visibility = "visible";

                flag2=false; // setting flag false not   to display the all history data after next click again
            }

        }
        function display() {
            for (j = 0; j < objhistoryasrider.length; j++){
                idh3 = "idrider"+j;
                newElement = document.createElement('p');
                newElement.setAttribute("id",idh3);
                newElement.style.margin = "25px 25px 25px 25px";
                newElement.style.padding = "25px 25px 25px 25px";
                newElement.style.width = "250px";
                newElement.style.border = "solid";
                newElement.style.background = "white";
                newElement.innerHTML = "Name: &nbsp;" + objhistoryasrider[j].first_name + "<br>" +
                    "Source: &nbsp;" + objhistoryasrider[j].start_Location + "<br>" +
                    "Destination:&nbsp;" + objhistoryasrider[j].destination + "<br>" +
                    "Trip date:&nbsp; " + objhistoryasrider[j].tripDate + "<br>" +
                    "Trip time: &nbsp;" + objhistoryasrider[j].tripTime + "<br>";
                document.getElementById("divnooftripsasaridertext").appendChild(newElement);
            }
            flag2 = false; // this flag is for to display i.e visible or hide the history
            flagdisplay2=false; // this flag is to display the contents only one time click after next click only set visible or hidden
        }
        document.getElementById(idh3).style.visibility = "visible";
    }
}
/**
 * Created by Hemantc09 on 11/12/15.
 */
//function selectRidePreference()

var useridIS;
var totaldays = [];//take the data here

function loaduserID() {  // to get the user id from the session
    $(document).ready(function ()
    {
        var obj = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json objecta
      //  alert(obj.userId);
        useridIS=obj.userId;
      //  alert(useridIS);
    });

}

function showHideVehicleDetails()
{
    var chkVehicleYes = document.getElementById("IHaveCarID");
    var dvVehicle = document.getElementById("dvVehicle");
    dvVehicle.style.display = chkVehicleYes.checked ? "block" : "none";
    if(chkVehicleYes.checked)
    {
        var JsonvehicleData1=
        {
           "userId":useridIS
        };
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/owner/vehicle",
            data: JSON.stringify(JsonvehicleData1),
            contentType: "application/json",
            success: function (data) {
                // alert("One time Trip Details added");

                sessionStorage.setItem('vehicledata', JSON.stringify(data));
            }


        });

        dataobjvehicle= JSON.parse(sessionStorage.getItem('vehicledata'));
            //alert(dataobjvehicle.model);
        document.getElementById("VehicleModel").value=dataobjvehicle.model;
            document.getElementById("VehicleNumber").value=dataobjvehicle.licencePlateNumber;
                document.getElementById("VehicleCapacity").value=dataobjvehicle.capacity;



    }

}

function showHideDays()
{

    var chkDaysYes = document.getElementById("RoutineTripID");
    var dvDays = document.getElementById("dvDays");
    dvDays.style.display = chkDaysYes.checked ? "block" : "none";
}


function checksendtripdata()
{
    var error;

    if((document.getElementById("IWantRideID").checked)&&(document.getElementById("oneTimeTripID").checked)) {
       // alert("One time trip");
        error = 0;
        if (!selectdate('datepicker'))  //validate date name
        {
            document.getElementById('datepickerError').style.display = "block";
            error++;
        }
        if (!selecttime('SelectTimeMytime'))  //validate date name
        {
            document.getElementById('SelectTimeMytimeError').style.display = "block";
            error++;
        }

        if (!commutefrom('CommuteFromPlaceTXT')) {
            document.getElementById('CommuteFromPlaceTXTError').style.display = "block";
            error++;
        }

        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }
        if(!valdiateTerm('term&conditions'))
        {
            document.getElementById('term&conditionsError').style.display = "block";
            error++;
        }
    }
    else if((document.getElementById("IWantRideID").checked)&&(document.getElementById("RoutineTripID").checked)){

       // alert("rotine trip");
        error = 0;
        if (!selectdate('datepicker'))  //validate date name
        {
            document.getElementById('datepickerError').style.display = "block";
            error++;
        }
        if (!selecttime('SelectTimeMytime'))  //validate date name
        {
            document.getElementById('SelectTimeMytimeError').style.display = "block";
            error++;
        }

        if (!commutefrom('CommuteFromPlaceTXT')) {
            document.getElementById('CommuteFromPlaceTXTError').style.display = "block";
            error++;
        }

        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }
        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }

        var su=document.getElementById("sunday").checked;
        var mo=document.getElementById("monday").checked;
        var tu=document.getElementById("tuesday").checked;
        var we=document.getElementById("wednesday").checked;
        var th=document.getElementById("thursday").checked;
        var fr=document.getElementById("friday").checked;
        var sa=document.getElementById("saturday").checked;

       // alert(s);

        if((su||mo||tu||we||th||fr||sa)==false)
        {
            document.getElementById('routinedaysError').style.display = "block";
            error++;

        }else
        {
            document.getElementById('routinedaysError').style.display = "ccffcc";
            tripadded();

        }

        if(!valdiateTerm('term&conditions'))
        {
            document.getElementById('term&conditionsError').style.display = "block";
            error++;
        }
    }
    else if((document.getElementById("IHaveCarID").checked)&&(document.getElementById("oneTimeTripID").checked))
    {
         error = 0;
        if (!selectdate('datepicker'))  //validate date name
        {
            document.getElementById('datepickerError').style.display = "block";
            error++;
        }
        if (!selecttime('SelectTimeMytime'))  //validate date name
        {
            document.getElementById('SelectTimeMytimeError').style.display = "block";
            error++;
        }

        if (!commutefrom('CommuteFromPlaceTXT')) {
            document.getElementById('CommuteFromPlaceTXTError').style.display = "block";
            error++;
        }

        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }
        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }
        if (!selectvehiclemodel('VehicleModel')) {
            document.getElementById('VehicleModelError').style.display = "block";
            error++;
        }
        if (!selectvehiclenumber('VehicleNumber')) {
            document.getElementById('VehicleNumberError').style.display = "block";
            error++;
        }
        if (!selectvehiclecapacity('VehicleCapacity')) {
            document.getElementById('VehicleCapacityError').style.display = "block";
            error++;
        }
      /*  if (!selectvehiclemake('VehicleMake')) {
            document.getElementById('VehicleMakeError').style.display = "block";
            error++;
        }*/
        if(!valdiateTerm('term&conditions'))
        {
            document.getElementById('term&conditionsError').style.display = "block";
            error++;
        }


    }else if((document.getElementById("IHaveCarID").checked)&&(document.getElementById("RoutineTripID").checked))
    {
        error = 0;
        if (!selectdate('datepicker'))  //validate date name
        {
            document.getElementById('datepickerError').style.display = "block";
            error++;
        }
        if (!selecttime('SelectTimeMytime'))  //validate date name
        {
            document.getElementById('SelectTimeMytimeError').style.display = "block";
            error++;
        }

        if (!commutefrom('CommuteFromPlaceTXT')) {
            document.getElementById('CommuteFromPlaceTXTError').style.display = "block";
            error++;
        }

        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }
        if (!commuteto('CommuteToPlaceTXT')) {
            document.getElementById('CommuteToPlaceTXTError').style.display = "block";
            error++;
        }
        if (!selectvehiclemodel('VehicleModel')) {
            document.getElementById('VehicleModelError').style.display = "block";
            error++;
        }
        if (!selectvehiclenumber('VehicleNumber')) {
            document.getElementById('VehicleNumberError').style.display = "block";
            error++;
        }
        if (!selectvehiclecapacity('VehicleCapacity')) {
            document.getElementById('VehicleCapacityError').style.display = "block";
            error++;
        }
      /*  if (!selectvehiclemake('VehicleMake')) {
            document.getElementById('VehicleMakeError').style.display = "block";
            error++;
        }*/
        var sun=document.getElementById("sunday").checked;
        var mon=document.getElementById("monday").checked;
        var tue=document.getElementById("tuesday").checked;
        var wed=document.getElementById("wednesday").checked;
        var thu=document.getElementById("thursday").checked;
        var fri=document.getElementById("friday").checked;
        var sat=document.getElementById("saturday").checked;

        // alert(s);

        if((sun||mon||tue||wed||thu||fri||sat)==false)
        {
            document.getElementById('routinedaysError').style.display = "block";
            error++;

        }else
        {
            document.getElementById('routinedaysError').style.display = "ccffcc";
          //  tripadded();

        }
        if(!valdiateTerm('term&conditions'))
        {
            document.getElementById('term&conditionsError').style.display = "block";
            error++;
        }

    }


    if(error > 0){


        return false;
    }
    else
    {
        if(error==0)
        {
            sendtripdata();
            //tripadded();
            // window.location.assign("LoginPage.html");
        }
    }

}

function tripadded()
{
//    alert("trip details added");

}




function selectdate(datepicker)
{


    if((document.getElementById(datepicker).value)!="")
    {
        document.getElementById(datepicker).style.background='#ccffcc';
        document.getElementById(datepicker+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(datepicker).style.background='#e35152';
        document.getElementById(datepicker+'Error').style.display='block';
        return false;
    }

}

function selecttime(st)
{


    if((document.getElementById(st).value)!="")
    {
        document.getElementById(st).style.background='#ccffcc';
        document.getElementById(st+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(st).style.background='#e35152';
        document.getElementById(st+'Error').style.display='block';
        return false;
    }

}

function commutefrom(commutefrom)
{

    if((document.getElementById(commutefrom).value)!="")
    {
        document.getElementById(commutefrom).style.background='#ccffcc';
        document.getElementById(commutefrom+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(commutefrom).style.background='#e35152';
        document.getElementById(commutefrom+'Error').style.display='block';
        return false;
    }
}
function commuteto(commuteto)
{

    if((document.getElementById(commuteto).value)!="")
    {
        document.getElementById(commuteto).style.background='#ccffcc';
        document.getElementById(commuteto+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(commuteto).style.background='#e35152';
        document.getElementById(commuteto+'Error').style.display='block';
        return false;
    }
}

function selectvehiclemodel(vehiclemodel)
{


    if((document.getElementById(vehiclemodel).value)!="")
    {
        document.getElementById(vehiclemodel).style.background='#ccffcc';
        document.getElementById(vehiclemodel+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(vehiclemodel).style.background='#e35152';
        document.getElementById(vehiclemodel+'Error').style.display='block';
        return false;
    }

}
function selectvehiclenumber(vehiclenumber)
{


    if((document.getElementById(vehiclenumber).value)!="")
    {
        document.getElementById(vehiclenumber).style.background='#ccffcc';
        document.getElementById(vehiclenumber+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(vehiclenumber).style.background='#e35152';
        document.getElementById(vehiclenumber+'Error').style.display='block';
        return false;
    }

}

function selectvehiclecapacity(VehicleCapacity)
{
    var range = /^[0-9]+$/;
    if(range.test(document.getElementById('VehicleCapacity').value))
        {
            document.getElementById(VehicleCapacity).style.background='#ccffcc';
            document.getElementById(VehicleCapacity+'Error').style.display='none';
            return true;
        }
        else
        {
            document.getElementById(VehicleCapacity).style.background='#e35152';
            document.getElementById(VehicleCapacity+'Error').style.display='block';
            return true;
        }



}


/*function selectvehiclemake(vehiclemake)
{


    if((document.getElementById(vehiclemake).value)!="")
    {
        document.getElementById(vehiclemake).style.background='#ccffcc';
        document.getElementById(vehiclemake+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(vehiclemake).style.background='#e35152';
        document.getElementById(vehiclemake+'Error').style.display='block';
        return false;
    }

}*/

function valdiateTerm(tandc)
{
    if(document.getElementById('term&conditions').checked)
    {

        document.getElementById(tandc+'Error').style.display='none'
        return true;
    }
    else
    {
        document.getElementById(tandc+'Error').style.background='block';
        return false;
    }


}
function sendtripdata()
{
    //Var tripId = document.getElementById();
    var startLocation1 = document.getElementById("CommuteFromPlaceTXT").value;
    var destination1 = document.getElementById("CommuteToPlaceTXT").value;
    var tripTime1 = document.getElementById("SelectTimeMytime").value;
    var seatAvailable1 = document.getElementById("VehicleCapacity").value;
    var userId1=useridIS;//get from session object
    //alert(userId1);
    var userType1;

    if (document.getElementById("IWantRideID").checked) // check whether user is rider or driver.
    {

        userType1 = "Rider"; // user is rider
    }
    else
    {
        userType1="Driver"; //user is driver
    }

    var i=0
            $.each($("input[name='days']:checked"), function()
            {

                totaldays[i]=($(this).val());
              //  totaldays[i]=$this.val();
                i=i+1;
            });
           // alert("Days are: " + totaldays);

    var tripDate1=document.getElementById("datepicker").value;
   // alert(tripDate1);

    var frequency1=1; //what is frequency? here
    var dayOfWeek1=[];
     dayOfWeek1=totaldays;
    var tripType1;//=document.getElementsByName("typeOfTrip").value;
   // var tripType2=document.getElementById("oneTimeTripID").value;
    //var tripType1;
    //alert(tripType1);
    var chkVehicleYes1 = document.getElementById("IHaveCarID").value; //get the value if user is driver.
   // alert(chkVehicleYes1);
    if(document.getElementById("oneTimeTripID").checked)
    {
        tripType1='onetime';
    }
    else
    {
        tripType1='Routine';
    }

   // tripType1=tripOnetimeOrRoutine;

    //alert(totaldays);
    var JsonTripData=
    {
        "startLocation":startLocation1,
        "destination":destination1,
        "tripTime":tripTime1,
        "seatAvailable":seatAvailable1,
        "userId":userId1,
        "userType":userType1,
        "tripDate":tripDate1,
        "tripType":tripType1// this should be one time trip
    };
    var JsonTripData1=
    {
        "startLocation":startLocation1,
        "destination":destination1,
        "tripTime":tripTime1,
        "seatAvailable":seatAvailable1,
        "userId":userId1,
        "userType":userType1,
        "tripDate":tripDate1,
        "tripType":tripType1, // this routine trip
        "dayOfWeek":dayOfWeek1
       // "dayOfWeek":["SUNDAY","TUESDAY"]
    };


    //var tripOnetimeOrRoutine=document.getElementById("typeOfTrip").checked=true;
        //document.getElementById("_1234").checked = true;

    if((tripType1=='onetime')&&(document.getElementById("IWantRideID").checked))
    {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/trip",
            data: JSON.stringify(JsonTripData),
            contentType: "application/json",
            success: function (data) {
               // alert("One time Trip Details added");
            }


        });
        //alert("One time Trip Details added");
    }
    else if((tripType1=='Routine')&&(document.getElementById("IWantRideID").checked))
    {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/trip",
            data: JSON.stringify(JsonTripData1),
            contentType: "application/json",
            success: function (data) {
               // alert(" Routine Trip Details added");
            }


        });
    }
    //else
    //{
    //    $.ajax({
    //        type: "POST",
    //        url: "http://localhost:8080/shareonwheels/v1/trip",
    //        data: JSON.stringify(JsonTripData1),
    //        contentType: "application/json",
    //        success: function (data) {
    //            alert(" Routine Trip Details added");
    //        }
    //
    //
    //    });
    //
    //}


    var u=userId1; // this is the user id which is going to vehicle table
 //   alert(u);
    if((document.getElementById("IHaveCarID").checked)&&(tripType1=='onetime'))
    {
        var url1="http://localhost:8080/shareonwheels/v1/driver/" + useridIS + "/vehicle";
        var model1=document.getElementById("VehicleModel").value;
        var capacity1=document.getElementById("VehicleCapacity").value;
        var licenceplatenumber1=document.getElementById("VehicleNumber").value;
        var JsonVehicleData=
        {
            "model":model1,
            "capacity":capacity1,
            "licencePlateNumber":licenceplatenumber1
        };


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/trip",
            data: JSON.stringify(JsonTripData),
            contentType: "application/json",
            success: function (data) {
              //  alert(" time Trip Details added");
            }


        });

        $.ajax({
            type: "POST",
            url:"http://localhost:8080/shareonwheels/v1/driver/"+u+"/vehicle",
            data: JSON.stringify(JsonVehicleData),
            contentType: "application/json",
            success: function (data) {
                //alert("Vehicle Details added");
                RegisterSuccessRedirect();
            }
        });
    }

    else if((document.getElementById("IHaveCarID").checked)&&(tripType1=='Routine'))
    {
        var url1="http://localhost:8080/shareonwheels/v1/driver/" + useridIS + "/vehicle";
        var model1=document.getElementById("VehicleModel").value;
        var capacity1=document.getElementById("VehicleCapacity").value;
        var licenceplatenumber=document.getElementById("VVehicleNumber").value; // temporary doesnt changed the name. its taking value from vehicle make

        var JsonVehicleData=
        {
            "model":model1,
            "capacity":capacity1,
            "licencePlateNumber":licenceplatenumber
        };


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/trip",
            data: JSON.stringify(JsonTripData1),
            contentType: "application/json",
            success: function (data) {
               // alert(" Routine Trip Details added");
            }


        });

        $.ajax({
            type: "POST",
            url:"http://localhost:8080/shareonwheels/v1/driver/"+u+"/vehicle",
            data: JSON.stringify(JsonVehicleData),
            contentType: "application/json",
            success: function (data) {
                //alert("Vehicle Details added");
                RegisterSuccessRedirect();
            }
        });
    }
    else{
        RegisterSuccessRedirect();
    }
}

function RegisterSuccessRedirect()
{
    alert("Your trip Registered successfully!!")
    window.location.assign("history.html");
}

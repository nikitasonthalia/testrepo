/**
 * Created by Hemantc09 on 11/18/15.
 */

var flag=true;

var  obj;
var  objvehicle;

var i;
var j=0;
var idh,idh1; // for displaying the user all history by using each for one category
var objhistory// object for all user  history
var jsonUserIdforhistory; // this the json object for user id which is same for all types    of history
$(document).ready(function() {

     obj = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json object user
   // alert(obj.password);

   // var obj1 = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json object user


    objvehicle= JSON.parse(sessionStorage.getItem('loogenInuserVehicle'));

    //alert(objvehicle.model);
    document.getElementById("first").value=obj.firstName;
    document.getElementById("last").value=obj.lastName;
    document.getElementById("cellnumber").value=obj.phoneNumber;
    document.getElementById("studentEmailId").value=obj.emailAddress;
   // alert(obj.password1);
    document.getElementById("password").value=obj.password;
    document.getElementById("addressLine1").value=obj.addressLine1;
    document.getElementById("addressLine2").value=obj.addressLine2;
    document.getElementById("city").value=obj.city;
    document.getElementById("state").value=obj.state;
    document.getElementById("zipcode").value=obj.zipCode;
    document.getElementById("loggedInGuestName").innerHTML=obj.firstName;

    document.getElementById("VehicleModel").value=objvehicle.model;
    document.getElementById("VehicleNumber").value=objvehicle.licencePlateNumber;
    document.getElementById("vehicleCapacity").value=objvehicle.capacity;
    //loggedInGuestName






}); // query end here








function disableText(){
    document.getElementById('Datasavedsuccess').disabled=false;
    document.getElementById('first').disabled = true;
    document.getElementById('last').disabled = true;
    document.getElementById('cellnumber').disabled = true;
    document.getElementById('studentEmailId').disabled = true;
    document.getElementById('password').disabled = true;
    document.getElementById('addressLine1').disabled = true;
    document.getElementById('addressLine2').disabled = true;
    document.getElementById('city').disabled = true;
    document.getElementById('state').disabled = true;
    document.getElementById('zipcode').disabled = true;
    document.getElementById('VehicleModel').disabled = true;
    document.getElementById('VehicleNumber').disabled = true;
    document.getElementById('vehicleCapacity').disabled = true;
    document.getElementById('riderPreference').disabled = true;
    flag=true;
}
function enableText()
{
    document.getElementById('Datasavedsuccess').style.display="none";
    document.getElementById('first').disabled = false;
    document.getElementById('last').disabled = false;
    document.getElementById('cellnumber').disabled = false;
    document.getElementById('studentEmailId').disabled = false;
    document.getElementById('password').disabled = false;
    document.getElementById('addressLine1').disabled = false;
    document.getElementById('addressLine2').disabled = false;
    document.getElementById('city').disabled = false;
    document.getElementById('state').disabled = false;
    document.getElementById('zipcode').disabled = false;
    document.getElementById('VehicleModel').disabled = false;
    document.getElementById('VehicleNumber').disabled = false;
    document.getElementById('vehicleCapacity').disabled = false;
    document.getElementById('riderPreference').disabled = false;
    flag=false;
    if(flag=false)
    {

            //savedata();
    }
}

function savedata()
{

    enableText();
    myprofilevalidation();
    //alert("Data save successfully!!")
 //   disableText();

}



function myprofilevalidation() //call my profile Validation() on click of button
{

var chkvalue=document.getElementById("term&conditions").checked;

    var error=0;
    if(!validateFirstName('first'))  //validate first name
    {
        document.getElementById('firstError').style.display = "block";
        error++;
    }
    if(!validateLastname('last')) //if user doesn't enter anything it will increase the error number //validate last name
    {
        document.getElementById('lastError').style.display="block";
        error++;
    }

    if(!validateCellnumber('cellnumber')) //validate cellnumbers
    {
        document.getElementById('cellnumberError').style.display='block';
        error++;
    }

    if(!validateEmail('studentEmailId')) //validate student email id
    {
        document.getElementById('studentEmailId').style.display='block';
        error++;
    }

    //if(!validatePassword('password'))
    //{
    //    document.getElementById('passwordError').style.display='block';
    //    error++;
    //
    //
    //}
    if(!validateAddressline1('addressLine1'))
    {
        document.getElementById('addressLine1Error').style.display='block';
        error++;
    }

    if(!validateAddressline2('addressLine2'))
    {
        document.getElementById('addressLine2Error').style.display='block';
        error++;
    }

    if(!validateCity('city'))
    {
        document.getElementById('cityError').style.display='block';
        error++;
    }
    if(!validateState('state'))
    {
        document.getElementById('stateError').style.display='block';
        error++;
    }
    if(!validateZipcode('zipcode'))
    {
        document.getElementById('zipcodeError').style.display='block';
        error++;
    }
    if(!valdiateTerm(chkvalue))
    {
        document.getElementById('term&conditionsError').style.display='block';
        error++;
    }
   // var chkvalue=document.getElementById("term&condition").checked;

    if(error > 0){

       // alert("Error");
        enableText();
        return false;
    }
    else
    {
        if(error==0)
        {
            document.getElementById('Datasavedsuccess').style.display='block';
            disableText();

//            SendDB(); // call this functio to update data.. /*****************************/

            // window.location.assign("LoginPage.html");
        }
    }


}


function validateFirstName(x){
    // Validation rule
    var re = /[A-Za-z -']$/;
    // Check input
    if(re.test(document.getElementById(x).value)){
        // Style green
        document.getElementById(x).style.background ='#ccffcc';
        // Hide error prompt
        document.getElementById(x + 'Error').style.display = "none";
        return true;
    }else{
        // Style red
        document.getElementById(x).style.background ='#e35152';
        // Show error prompt
        document.getElementById(x + 'Error').style.display = "block";
        return false;
    }
}


function validateLastname(x){
    // Validation rule
    var re = /[A-Za-z -']$/;
    // Check input
    if(re.test(document.getElementById(x).value)){
        // Style green
        document.getElementById(x).style.background ='#ccffcc';
        // Hide error prompt
        document.getElementById(x + 'Error').style.display = "none";
        return true;
    }else{
        // Style red
        document.getElementById(x).style.background ='#e35152';
        // Show error prompt
        document.getElementById(x + 'Error').style.display = "block";
        return false;
    }
}

//validate cell number

function validateCellnumber(x)
{
    var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    if(phoneno.test(document.getElementById('cellnumber').value))
    {
        document.getElementById(x).style.background="#ccffcc"
        document.getElementById(x+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(x).style.background='#e35152';
        document.getElementById(x+'Error').style.display='block';
        return false;
    }
}


//validate student email id
function validateEmail(mail)
{
    var mailformat=/^[0-9_.+-]+.+[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\.)?[a-zA-Z]+\.)?students.itu\.edu$/;
    if(mailformat.test(document.getElementById('studentEmailId').value))
    {
        document.getElementById(mail).style.background='#ccffcc';
        document.getElementById(mail+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(mail).style.background='#e35152';
        document.getElementById(mail+'Error').style.display='block';
        return false;
    }
}

//validate password

function validatePassword(cpass)
{
    var passE=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;

    if(passE.test(document.getElementById('password').value))
    {
        document.getElementById(cpass).style.background='#ccffcc';
        document.getElementById(cpass+'Error').style.display='none';

        return true;


    }
    else
    {
        document.getElementById(cpass).style.background='#e35152';
        document.getElementById(cpass+'Error').style.display='block';
        return false;
    }
}



//validate address line 1
function validateAddressline1(addressline1)
{

    if((document.getElementById(addressline1).value)!="")
    {
        document.getElementById(addressline1).style.background='#ccffcc';
        document.getElementById(addressline1+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(addressline1).style.background='#e35152';
        document.getElementById(addressline1+'Error').style.display='block';
        return false;
    }
}

//validate address line 2
function validateAddressline2(addressline2)
{

    if((document.getElementById(addressline2).value)!="")
    {
        document.getElementById(addressline2).style.background='#ccffcc';
        document.getElementById(addressline2+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(addressline2).style.background='#e35152';
        document.getElementById(addressline2+'Error').style.display='block';
        return false;
    }

}
//validate city
function validateCity(city)
{
    var re=/[A-Za-z -']$/;
    if(re.test(document.getElementById(city).value))
    {
        //style= green if lanme is correct
        document.getElementById(city).style.background="#ccffcc";
        //then hide the error prompt
        document.getElementById(city+ 'Error').style.display= "none";
        return true;
    }
    else
    {
        // else background color red
        document.getElementById(city).style.background="#e35152";
        //show the error prompt;
        document.getElementById(city+'Error').style.display='block';
        return false;
    }
}

//validate state
function validateState(state)
{
    var re=/[A-Za-z -']$/;
    if(re.test(document.getElementById(state).value))
    {
        //style= green if lanme is correct
        document.getElementById(state).style.background="#ccffcc";
        //then hide the error prompt
        document.getElementById(state+ 'Error').style.display= "none";
        return true;
    }
    else
    {
        // else background color red
        document.getElementById(state).style.background="#e35152";
        //show the error prompt;
        document.getElementById(state+'Error').style.display='block';
        return false;
    }
}

//validate Zip code
function validateZipcode(zip)
{
    var range = /^\d{5}$/;
    if(range.test(document.getElementById('zipcode').value))
    {
        document.getElementById(zip).style.background='#ccffcc';
        document.getElementById(zip+'Error').style.display='none';
        return true;
    }
    else
    {
        document.getElementById(zip).style.background='#e35152';
        document.getElementById(zip+'Error').style.display='block';
        return false;
    }
}


function valdiateTerm(chkvalue)
{

    if(chkvalue==true)
    {
       // SendDB();
        // alert("User has been added successfully.");
        //window.location.reload()
        document.getElementById('term&conditionsError').style.display='none';
        alert("Congrats!! Reigstration Successful!");
       // RegisterSuccessRedirect();
        return true;
    }
    else
    {
       // alert("Please accept Terms and Conditions before submitting the form");
        return false;
    }
}
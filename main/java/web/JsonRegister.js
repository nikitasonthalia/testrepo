/**
 * Created by Hemantc09 on 10/20/15.
 */


function SendDB() {

    var fn1 = document.getElementById("first").value;
    var ln1 = document.getElementById("last").value;
    var gen1 = document.getElementById("gender_id").value;
    var cn1 = document.getElementById("cell_number").value;
    var sei1 = document.getElementById("student_email_id").value;
    var psd1 = document.getElementById("password").value;
    var cpsd1 = document.getElementById("confirm_password").value;
    var al1 = document.getElementById("address_line_1").value;
    var al2 = document.getElementById("address_line_2").value;
    var city1 = document.getElementById("city").value;
    var state1 = document.getElementById("state").value;
    var zc1 = document.getElementById("zipcode").value;

    //alert(gen1);
    var flag=true;
    var a=fn1;
    var finaladdress;

    if(al1==" ")
    {
        finaladdress=al2;

    }
    else
    {
        finaladdress=al1+al2;
        //alert("finaladdress is:" +finaladdress);
    }


//JSON object is below
    var JsonObjRegisterFrm = {
        "firstName": fn1,
        "lastName": ln1,
        "gender": gen1,
        "phoneNumber": cn1,
        "emailAddress": sei1,
        "password": psd1,
        "confirmpsd": cpsd1,
        "addressLine1": al1,
        "addressLine2": al2,
        "city": city1,
        "state": state1,
        "zipCode": zc1


    };


    //alert(JsonObjRegisterFrm.zipcode);

    $(document).ready(function(){
        //$("button").click(function(){


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/user",
            data: JSON.stringify(JsonObjRegisterFrm),
            contentType: "application/json",
            //statuscode : {
            //    401: function() {
            //      alert('username and password correct');
            //     }
            // },

            success: function (data) {

                alert("User has been added successfully.");

            },
            error: function (data) {
                alert("Error.");
            }
        });
        // });
    });



}

//////////////////////////////////////////////////////

function validateFirstName()
{

    var fn = document.getElementById("first");
    var letters = /^[A-Za-z]+$/;
    if(fn.match(letters))
    {
        return true;

    }
    else
    {
        // fn.focus();
        document.getElementById("fnameError").innerHTML = "Invalid First name";
        return false;
    }
}


function formValidation()
{
    var firstNamevalid = document.getElementById("first").value;
    var lastNamevalid = document.getElementById("last").value;
    var gendervalid = document.getElementById("gender_id");
    var selectgendervalid = gendervalid.options[gendervalid.selectedIndex].value;
    var phoneNumbervalid=document.getElementById("cell_number").value;
    var emailAddressvalid=document.getElementById("student_email_id").value;
    var psdvalid=document.getElementById("password").value;
    var cpsdvalid=document.getElementById("confirm_password").value;
    var addline1valid=document.getElementById("address_line_1").value;
    var addline2valid=document.getElementById("address_line_2").value;
    var cityvalid=document.getElementById("city").value;
    var statevalid= document.getElementById("state").value;
    var zipcodevalid=document.getElementById("zipcode").value;
    var chkvalue=document.getElementById("Term&conditionsCHK").checked;









    // alert(selectgender);


    //  var msex=document.RegisterFrm

    // var msex=document.RegisterFrm.getElementById("msex");
    //var fsex=document.RegisterFrm.getElementById("fsex");










    //var uname = document.registration.username;
    //var uadd = document.registration.address;
    //var ucountry = document.registration.country;
    //var uzip = document.registration.zip;
    //var uemail = document.registration.email;
    //var umsex = document.registration.msex;
    //var ufsex = document.registration.fsex;
    //  if(userid_validation(first,5,12))

    if(allLetterfname(firstNamevalid))
    {
        if(allLetterlname(lastNamevalid))
        //
        {
           if(validsex(selectgendervalid))
            {
                if(cellnumber(phoneNumbervalid))
                //
                {
                    if(ValidateEmail(emailAddressvalid))
                    //
                    {
                        if(passid_validation(psdvalid))
                        //
                        {
                            if(confirmpsdcheck(psdvalid,cpsdvalid))
                            //
                            {
                                if(addresschk1(addline1valid,addline2valid))

                                {
                                    {
                                        if (citycheck(cityvalid))
                                        {
                                            if (statecheck(statevalid))
                                            {
                                                if (zipcodecheck(zipcodevalid))
                                                {


                                                   if(termsandconditions(chkvalue))
                                                    {

                                                    }


                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return false;

}


function validsex(umsex,ufsex)
{
    x=0;

    if(umsex.checked)
    {
        x++;
    } if(ufsex.checked)
{
    x++;
}
    if(x==0)
    {
        alert('Select Male/Female');
        //umsex.focus();
        return false;
    }

}
/*

 function userid_validation(uid,mx,my)
 {
 var uid_len = uid.value.length;
 if (uid_len == 0 || uid_len >= my || uid_len < mx)
 {
 alert("User Id should not be empty / length be between "+mx+" to "+my);
 uid.focus();
 return false;
 }
 return true;
 }

 */

/*

 */

/*
 function gotolocation()
 {
 alert('Form Succesfully Submitted');

 window.location.assign("/Users/Hemantc09/IdeaProjects/ITUCommute/web/LoginPage.html")
 }

 */


//**************************************
// first name  validation

function clearFnameError()
{
    document.getElementById('fnameError').innerHTML = "";
}

function allLetterfname(uname)
{
    var letters = /^[A-Za-z]+$/;
    if(uname.match(letters))
    {

       document.getElementById('fnameError').innerHTML = "";
        return true;

    }
    else
    {
        alert('First name must have alphabet characters only');
        fFlag=false;
        uname.focus();

        return false;
    }


}

//********************************************
//last name validation

function allLetterlname(last)
{
    var letters = /^[A-Za-z]+$/;
    if(last.match(letters))
    {

        return true;

    }
    else
    {
        alert('Last name must have alphabet characters only');
        //last.focus();
        return false;
    }


}


//********************************************
//Gender selection


function validsex(sgender)
{

    if (sgender == "I am")
    {
        alert("Please select the gender");
        return false
    }
    else
    {
        return true;

    }

}//********************************************
//Mobile number validation
function cellnumber(inputtxt)
{
    var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    if(inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
        alert("Please enter a valid Phone Number");
        return false;
    }
}
//********************************************
//Email  validation
function ValidateEmail(semail)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;


    var reg =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;


    if(semail.match(mailformat))
    {
        return true;
    }
    else
    {
        alert("You have entered an invalid email address!");
        semail.focus();
        return false;
    }
}


//********************************************
//password validation

function passid_validation(inputpsd)
{
    var paswd=  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
    if(inputpsd.match(paswd))
    {
        //  alert('Correct, try another...')
        return true;
    }
    else
    {
        // alert('Wrong...!')
        alert("Password should be 7 to 15 characters long which contain at least one numeric digit and a special character]")
        return false;
    }
}

//********************************************
//Confirm password validation

function confirmpsdcheck(password,confirmpsd)
{

    if(confirmpsd==password)
    {
        return true;

    }
    else
    {
        alert("Password is not matching please re-enter");
        return false;
    }
}


//********************************************
//Address line-1 validation

function alphanumeric(addline1)
{
    var letters = /^[0-9a-zA-Z]+$/;
    if(addline1.match(letters))
    {
        return true;
    }
    else
    {
        alert('User address line 1 must have alphanumeric characters only');
        addline1.focus();
        return false;
    }
}



//********************************************
//Address line 1 blank validation

function addresschk1(addline1,addline2)
{
    if(addline1=="" && addline2=="")
    {
        alert("Please enter the address correct format in line or line 2")
        return false;

    }
    else
    {
        return true;
    }
}


function addresschk2(addline2)
{
    if(addline2=="")
    {
        alert("Please enter the address correct format")
        return false;

    }
    else
    {
        return true;
    }
}

//********************************************
//City validation


/*
 function citycheck(inputcity)
 {
 var alpha = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
 if(inputcity.value.match(alpha))
 {

 return true;
 }
 else
 {
 alert("City should contain alphabets only");
 return false;
 city.focus();

 }


 }


 */


function citycheck(inputcity)
{
    var alpha = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
    if(inputcity.match(alpha))
    {

        return true;
    }
    else
    {
        alert("City should contain alphabets only");
        return false;
        inputcity.focus();


    }

}

//********************************************
//state validation
function statecheck(inputstate)
{
    var alpha = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
    if(inputstate.match(alpha))
    {

        return true;
    }
    else
    {
        alert("State should contain alphabets only");
        return false;
        inputstate.focus();

    }

}

//********************************************
//zip code validation


function zipcodecheck(zipcode)
{
    var range = /^\d{5}$/;
    if(zipcode.match(range))
    {
        return true;
    }
    else
    {
        alert("Not a valid zip code");
        return false;
    }
}


/*Check box terms and conditions validations*/

function termsandconditions(chkvalue)
{
    if(chkvalue==true)
    {
        SendDB();
        // alert("User has been added successfully.");
        //window.location.reload()
        alert("Congrats!! Reigstration Successful!");
        RegisterSuccessRedirect();
        return true;
    }
    else
    {
        alert("Please accept Terms and Conditions before submitting the form");
        return false;
    }
}



function RegisterSuccessRedirect()
{
    window.location.assign("LoginPage.html");
}

function RegisterFailRedirect()
{
    window.location.assign("http://localhost:63342/shareonwheels/web/Register.html");
}

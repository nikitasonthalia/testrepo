


function formValidation() //call formValidation() on click of button
{

    var error=0;
    if(!validateName('first'))  //validate first name
    {
        document.getElementById('firstError').style.display = "block";
        error++;
    }
    if(!validateLname('last')) //if user doesn't enter anything it will increase the error number //validate last name
    {
        document.getElementById('lastError').style.display="block";
        error++;
    }
    if(!validateGender('gender'))
    {
        document.getElementById('genderError').style.display='block';
        error++;
    }

    if(!validateCellnumber('cellnumber')) //validate cellnumbers
    {
        document.getElementById('cellnumberError').style.display='block';
        error++;
    }

    if(!validateEmail('studentemailid')) //validate student email id
    {
        document.getElementById('studentemailidError').style.display='block';
        error++;
    }

    if(!validatePassword('password1'))
    {
        document.getElementById('password1Error').style.display='block';
        error++;


    }

    if(!validateconfirmpassword('confirmpassword'))
    {
        document.getElementById('confirmpasswordError').style.display='block';
        error++;

    }

    if(!validateAddressline1('addressline1'))
    {
        document.getElementById('addressline1Error').style.display='block';
        error++;
    }

    if(!validateAddressline2('addressline2'))
    {
        document.getElementById('addressline2Error').style.display='block';
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
    if(!valdiateTerm('term&conditions'))
    {
        document.getElementById('term&conditionsError').style.display='block';
        error++;
    }

    if(error > 0){


        return false;
    }
    else
    {
        if(error==0)
        {
            SendDB();

           // window.location.assign("LoginPage.html");
        }
    }


}
/******************************/
//first name validation
function validateName(x){
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

//Last name validation
function validateLname(x)
{
    var re=/[A-Za-z -']$/;
    if(re.test(document.getElementById(x).value))
    {
        //style= green if lanme is correct
        document.getElementById(x).style.background="#ccffcc";
        //then hide the error prompt
        document.getElementById(x+ 'Error').style.display= "none";
        return true;
    }
    else
    {
        // else background color red
        document.getElementById(x).style.background="#e35152";
        //show the error prompt;
        document.getElementById(x+'Error').style.display='block';
        return false;
    }
}

//Validate Gender
function validateGender(x)
{
    if(document.getElementById(x).selectedIndex!==0)
    {
        document.getElementById(x).style.background="#ccffcc";
        document.getElementById(x+'Error').style.display='none';
        return true //if user selected the gender
    }
    else
    {
        document.getElementById(x).style.background="#e35152";
       document.getElementById(x+'Error').style.display='block';
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
    var mailformat=/^[0-9_.+-]+.+[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\.)?[a-zA-Z]+\.)?itu\.edu$/;
    if(mailformat.test(document.getElementById('studentemailid').value))
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

    if(passE.test(document.getElementById('password1').value))
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

//validate confirm password
function validateconfirmpassword(cpass) {
    var passE = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
    if (passE.test(document.getElementById(cpass).value))
    {

        var p=document.getElementById('password1').value;
        var cp=document.getElementById('confirmpassword').value;
        if(p==cp)
        {
            document.getElementById(cpass).style.background = '#ccffcc';
            document.getElementById(cpass + 'Error').style.display = 'none';
            return true;
        }
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

//validate terms and conditions
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


function SendDB() {

    var fn1 = document.getElementById("first").value;
    var ln1 = document.getElementById("last").value;
    var gen1 = document.getElementById("gender").value;
    var cn1 = document.getElementById("cellnumber").value;


    var emailidTodatabase=document.getElementById("studentemailid");

    var sei1=emailidTodatabase.value.toLowerCase();


    var psd1 = document.getElementById("password1").value;
    var cpsd1 = document.getElementById("confirmpassword").value;
    var al1 = document.getElementById("addressline1").value;
    var al2 = document.getElementById("addressline2").value;
    var city1 = document.getElementById("city").value;
    var state1 = document.getElementById("state").value;
    var zc1 = document.getElementById("zipcode").value;
    var flag=true;

    var finaladdress;

    if(al1==" ")
    {
        finaladdress=al2;

    }
    else
    {
        finaladdress=al1+al2;
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


    $(document).ready(function(){
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/shareonwheels/v1/user",
            data: JSON.stringify(JsonObjRegisterFrm),
            contentType: "application/json",

            success: function (data)
            {
               // sessionStorage.setItem('confirmuser', JSON.stringify(data))
                //var  objconfirm = JSON.parse(sessionStorage.getItem('confirmuser'));
                var longvalueis=123456789; // if the valuev
                if(data==longvalueis)
                {
                        alert("duplicate user");


                }
                else
                {
                    //alert("No duplicate");
                    RegisterSuccessRedirect();
                }
               // RegisterSuccessRedirect();
            }
        });
    });
}

function RegisterSuccessRedirect()
{
    alert("User has been added successfully.");
    window.location.assign("index.html");

}

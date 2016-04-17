
/*
* Designed by Hemant Choudhari
* */
function logintextboxValiadation() {

    document.getElementById('loginfailed').style.display = 'none';

    var error = 0;
    if (!useridvalidation('Username_loginfrm')) {
        document.getElementById('Username_loginfrmError').style.display = 'block';
        error++;
    }
    if(!passwordvalidation('Password_loginfrm'))
    {
        document.getElementById('Password_loginfrmError').style.display='block';
        error++
    }
    if(error==0)
    {
        Logincheck();
        document.getElementById('loginfailed').style.display='none';
    }
    else
    {
       // document.getElementById('loginfailed').style.display='block';
    }
}
function useridvalidation(studentemialid)
{
    var mailformat=/^[0-9_.+-]+.+[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\.)?[a-zA-Z]+\.)?students.itu\.edu$/;
    document.getElementById('loginfailed').style.display='none';
    if(mailformat.test(document.getElementById(studentemialid).value))
    {
        document.getElementById(studentemialid).style.background='#ccffcc';
        document.getElementById(studentemialid+'Error').style.display='none';
        return true;
    }
    else
    {
        //document.getElementById(studentemialid).style.background='#e35152';
        document.getElementById(studentemialid+'Error').style.display='block';
        return false;
    }
}
function passwordvalidation(passwordloginform)
{
    var passE = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
    document.getElementById('loginfailed').style.display='none';
    if (passE.test(document.getElementById(passwordloginform).value))
    {
            document.getElementById(passwordloginform).style.background = '#ccffcc';
            document.getElementById(passwordloginform + 'Error').style.display = 'none';
            return true;
    }
    else
    {
        //document.getElementById(passwordloginform).style.background='#e35152';
        document.getElementById(passwordloginform+'Error').style.display='block';
        return false;
    }
}

function Logincheck()
{
    var u1 =document.getElementById("Username_loginfrm").value;
    var p1=document.getElementById("Password_loginfrm").value;
    var JSONObject= {
        emailAddress:u1,
        password:p1
    };


    var USER_CONFIRMED='USER_CONFIRMED' ;  //if user name ,password and status is matching
    var USERNAME_PASSWORD_DOES_NOT_MATCH='USERNAME_PASSWORD_DOES_NOT_MATCH'; //username and password does not match
    var NOT_CONFIRMED='NOT_CONFIRMED'; // user is not confirmed
    //var  // user is not confirmed
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/shareonwheels/v1/login",
        data: JSON.stringify(JSONObject),
        contentType: "application/json",
        success: function (data) {

            if(data) {
                //alert("User has been login successfully.");
                sessionStorage.setItem('loogenInuser', JSON.stringify(data)); // we are setting up the session variabl in json format
                loginSuccessRedirect();
            }

        },
        error: function (e, status) {

            if (e.status == 401) {
                //document.getElementById().innerHTML="User email is not conformed please confirm your email address";
                alert("User email is not conformed please confirm your email address");
            }
           else if (e.status == 403) {
               // document.getElementById().innerHTML="User name or password does not match";
               alert("User name or password does not match");
            }
        }
    });



}
function loginSuccessRedirect() {

    window.location.assign('index.html');
}


function loginfailedRedirect()
{
    document.getElementById('loginfailed').style.display ='block';
    window.location.assign('Loginpage.html');
    document.getElementById('loginfailed').style.display ='block';
}

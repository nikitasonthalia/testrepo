/**
 * Created by Hemantc09 on 12/10/15.
 */

var flagpassword = true;

$(document).ready(function () { //logged out code/
    document.getElementById('loggedInGuestName').innerHTML = "Guest";

    document.getElementById('loggedInmyprofilehref').innerHTML= "";
    document.getElementById('loggedInmyprofilehref').style.visibility = "hidden";



    var obj = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json object
    if (!obj == '') {
        document.getElementById('contentright').style.visibility = "hidden";
        document.getElementById('contentrightafterlogin').style.visibility = "visible";
        document.getElementById('loggedInGuestName').innerHTML = "" + obj.firstName + "";
        document.getElementById('loggedInmyprofilehref').innerHTML= "My Profile";
        document.getElementById('loggedInmyprofilehref').style.visibility = "visible";
        document.getElementById("loggedInmyprofilehref").href = "MyProfile.html";

        var jsonUserId=
        {
            "userId":obj.userId
        };


        $.ajax({
            type: "GET",
            url: "http://localhost:8080/shareonwheels/v1/owner/"+obj.userId+"/vehicle",
            data: JSON.stringify(jsonUserId),
            contentType: "application/json",
            success: function (data) {
                sessionStorage.setItem('loogenInuserVehicle', JSON.stringify(data));// we are setting up the session variabl in json format
            },
            error: function (response) {

            }
        });



       // loggedInmyprofile
    }

    else {
        localStorage.clear();
        sessionStorage.clear();
        document.getElementById('contentrightafterlogin').style.visibility = "hidden";
        document.getElementById('logoutbutton').style.visibility="hidden";
        document.getElementById('loggedInGuestName').innerHTML = "Guest!!";
    }


});

function logoutuser() {
    localStorage.clear();
    sessionStorage.clear();
    document.getElementById('loggedInGuestName').value = 'Guest!';
    window.location.assign('index.html');
}

function forgotpasswordsendvalidation() {

    document.getElementById('contentright').style.visibility = "hidden";
    document.getElementById('contentrightafterlogin').style.visibility = "hidden";
    document.getElementById('contentrightforgotpass').style.visibility = "visible";
    document.getElementById('logoutbutton').disabled = true;

}

function forgotpasswordvalidation(studentemialid) {
    var error = 0;
    var mailformat = /^[0-9_.+-]+.+[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\.)?[a-zA-Z]+\.)?students.itu\.edu$/;
    document.getElementById('loginfailed').style.display = 'none';
    if (mailformat.test(document.getElementById(studentemialid).value)) {
        document.getElementById(studentemialid).style.background = '#ccffcc';
        document.getElementById(studentemialid + 'Error').style.display = 'none';
        error = 0;
    }
    else {

        document.getElementById(studentemialid + 'Error').style.display = 'block';

        error++;
    }
    if (error > 0) {
        flagpassword = true;
    }
}

function forgotpasswordsend() {
    if (flagpassword = true) {
        var sendemailid = document.getElementById('forgotpasswordvalue').value;
        var JsonObjsendemailid = {
            "emailAddress": sendemailid
        }

        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/shareonwheels/v1/user/forgotpassword",
                data: JSON.stringify(JsonObjsendemailid),
                contentType: "application/json",
                success: function (data) {
                    alert("Email id sent");
                    gotohomepage();
                },
                error: function (e, status) {
                    if (e.status == 500);
                    {
                        document.getElementById('forgotpasswordvalueError').style.display = 'block';
                        // alert("Enter valid id.");
                    }
                }
            });

        });
    } else {

    }
}
function gotohomepage() {

    document.getElementById('contentright').style.visibility = "visible";
    document.getElementById('contentrightafterlogin').style.visibility = "hidden";
    document.getElementById('contentrightforgotpass').style.visibility = "hidden";
    window.location.assign("index.html");
}


function wantaride() {
    window.location.assign('tripSearch.html');

}

function newuser() {
    window.location.assign('Register1.html');
}

function ihavecar() {
    window.location.assign('tripDetails.html');
}
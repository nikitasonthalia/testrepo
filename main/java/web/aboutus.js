/**
 * Created by Hemantc09 on 12/19/15.
 */

$(document).ready(function () { //logged out code/
    document.getElementById('loggedInGuestName').innerHTML = "Guest";


    var obj = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json object
    if (!obj == '') {


        document.getElementById('loggedInusertriprequest').innerHTML="Trip Search";
        document.getElementById('loggedInusertripregister').innerHTML="Trip Register";
        document.getElementById("tripsearchhref").href = "tripSearch.html";
        document.getElementById("tripregisterhref").href = "tripDetails.html";
        document.getElementById('loggedInGuestName').innerHTML = "" + obj.firstName + "";
    }

    else {
        localStorage.clear();
        sessionStorage.clear();
        document.getElementById('loggedInusertriprequest').innerHTML="";
        document.getElementById('loggedInusertripregister').innerHTML="";
        document.getElementById("tripsearchhref").href = "";
        document.getElementById("tripregisterhref").href = "";
        document.getElementById('logbtn').innerHTML = "";
        document.getElementById('logbtn').href = "";
        document.getElementById('loggedInGuestName').innerHTML = "Guest!!";
    }
});
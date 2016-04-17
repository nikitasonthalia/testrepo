/**
 * Created by Hemantc09 on 12/11/15.
 */
$(document).ready(function() { //logged out code/
    document.getElementById('loggedInGuestName').innerHTML="Guest";
    var  obj = JSON.parse(sessionStorage.getItem('loogenInuser')); //get the json object
    if(!obj=='')
    {
        document.getElementById('loggedInGuestName').innerHTML=""+obj.firstName+"";
    }
    else
    {
        localStorage.clear();
        sessionStorage.clear();
        document.getElementById('loggedInGuestName').innerHTML="Guest!!";
    }
});

function logoutuser()
{
    localStorage.clear();
    sessionStorage.clear();
    document.getElementById('loggedInGuestName').value='Guest!';
    window.location.assign('index.html');
}

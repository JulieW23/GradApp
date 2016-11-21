/**
 * This File Contains all necessary javascript functions to validate client sign
 * up form.
 */

var req_count; // request variable for countries
var req_state; // request variable for provinces


window.onload = refresh; // on window loading populate country select element

// ---------------------------------Ajax Calls for countries and
// provinces-----------------------------------------

function refresh() {
	document.getElementById("email").value = '';
	document.getElementById("email2").value = '';
	document.getElementById("password").value = '';
	document.getElementById("name").value = '';
	document.getElementById("lastname").value = '';
}

function hide(elem){
	document.getElementById(elem).style.visibility = "hidden";	
}

// -------------------First Email Processing-------------------------

function isEmailEmpty() {
	
	var val = document.getElementById("email");
	if (val.value == '') {
		$("#email_err").show();
		val.style.borderColor = "red";
		document.getElementById("email_err").style.visibility = "visible";
	} 
}

// -----------------------------Second Email Processing
// -----------------------------------

/*function isEmail2Empty() {
	var val = document.getElementById("email2");
	if (val.value == '') {
		email2_valid = -2; // -2, this input has been visited and left empty.
		$("#email2_alert").show();
		$("#email2_err").hide();
		val.style.borderColor = "red";
		document.getElementById("email2_err").focus();
		document.getElementById("email2_err").childNodes[2].innerHTML = 'This Field is Required.';
	} else {
		email2_valid = 0; // has some value.
		val.style.borderColor = "#dedede";
		$("#email2_alert").hide();
		$("#email2_err").hide();
	}
}

// -----------------------------Password Processing


function isPassEmpty() {
	
	var val = document.getElementById("password");

	if (val.value == '') {
		pass_valid = -2; // -2, this input has been visited and left empty.
		val.style.borderColor = "red";
		
		$("#pass_alert").show();
		$("#pass_err").hide();
		document.getElementById("pass_err").focus();
		document.getElementById("pass_err").childNodes[2].innerHTML = 'This Field is Required.';
	} else {
		pass_valid = 0; // has some value.
		val.style.borderColor = "#dedede";
		
		$("#pass_alert").hide();
		$("#pass_err").hide();
	}
}

function showPassHelp(){
	document.getElementById("pass_help").style.visibility = "visible";
}


// -----------------------------Name and Last name Processing
// -----------------------------------

function isNameEmpty() {

	var name = document.getElementById("name");

	if (name.value == '') {
		name_valid = -2; // -2, this input has been visited and left empty.
		$("#name_alert").show();
		$("#name_err").hide();

		name.style.borderColor = "red";
		document.getElementById("name_err").focus();
		document.getElementById("name_err").childNodes[2].innerHTML = 'This Field is Required.';
	} else {
		name_valid = 0; // has some value.
		name.style.borderColor = "#dedede";
		$("#name_alert").hide();
		$("#name_err").hide();
	}
}

function isLastNameEmpty() {

	var lastname = document.getElementById("lastname");

	if (lastname.value == '') {
		
		lastname_valid = -2; // -2, this input has been visited and left
							// empty.
		$("#last_name_alert").show();
		$("#last_name_err").hide();
		
		lastname.style.borderColor = "red";
		document.getElementById("last_name_err").childNodes[2].innerHTML = 'This Field is Required.';
	} else {
		lastname_valid = 0; // has some value.
		lastname.style.borderColor = "#dedede";
		
		$("#last_name_alert").hide();
		$("#last_name_err").hide();
	}
}

// ------------------------------ form processing before
// submission-----------------------

function isEmail(element) {
	var regx = /^[=`{|}~/_a-z0-9A-Z!#$%&'*+-]+([\.][=`{|}~/_a-z0-9A-Z!#$%&'*+-]+)*@[a-z0-9A-Z]+[-]?[a-z0-9A-Z]+([\.]([a-z0-9A-Z]+[-]?[a-z0-9A-Z]+))+$/;
	var value = element;
	return regx.test(value);
}

function isPassword(element) {
	var regx = /(?=((.)*[a-z]))(?=((.)*[A-Z]))(?=((.)*[0-9])){8,}/;
	return regx.test(element);
}

function isName(element) {
	var regx = /^[a-zA-Z]+$/;
	return regx.test(element);
}

function changePass(pass) {

	if (pass.checked)
		document.getElementById("password").type = "text";
	else
		document.getElementById("password").type = "password";

}*/

function check_form() {

	var allchecked = 0;
	var email1, email2;

	if ( isEmailEmpty()) {
		allchecked = -1 ;
    }	
		
	if (allchecked != 0) {
		return false;
}
}


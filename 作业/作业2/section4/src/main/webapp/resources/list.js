
function modifyChange(index) {
    var tableAddress = document.getElementsByClassName('tableAddress_'+index)[0];
    var tableZipCode = document.getElementsByClassName('tableZipCode_'+index)[0];
    var tablePhone = document.getElementsByClassName('tablePhone_'+index)[0];
    var modifyAddress = document.getElementsByClassName('modifyAddress_'+index)[0];
    var modifyZipCode = document.getElementsByClassName('modifyZipCode_'+index)[0];
    var modifyPhone = document.getElementsByClassName('modifyPhone_'+index)[0];
    tableAddress.style.display=tableAddress.style.display==='none'?'inline-block':'none';
    tableZipCode.style.display=tableZipCode.style.display==='none'?'inline-block':'none';
    tablePhone.style.display=tablePhone.style.display==='none'?'inline-block':'none';
    modifyAddress.style.display=modifyAddress.style.display==='inline-block'?'none':'inline-block';
    modifyZipCode.style.display=modifyZipCode.style.display==='inline-block'?'none':'inline-block';
    modifyPhone.style.display=modifyPhone.style.display==='inline-block'?'none':'inline-block';
    var modifyButton = document.getElementsByClassName('modifyButton_'+index)[0];
    var modifyConfirm = document.getElementsByClassName('modifyConfirm_'+index)[0];
    var modifyCancel = document.getElementsByClassName('modifyCancel_'+index)[0];
    modifyButton.style.display=modifyButton.style.display==='none'?'inline-block':'none';
    modifyConfirm.style.display=modifyConfirm.style.display==='inline-block'?'none':'inline-block';
    modifyCancel.style.display=modifyCancel.style.display==='inline-block'?'none':'inline-block';
}

function modifyPerson(index) {
    var tableName = document.getElementsByClassName('tableName_'+index)[0];
    var modifyAddress = document.getElementsByClassName('modifyAddress_'+index)[0];
    var modifyZipCode = document.getElementsByClassName('modifyZipCode_'+index)[0];
    var modifyPhone = document.getElementsByClassName('modifyPhone_'+index)[0];
    if(modifyZipCode.value.length > 6){
        alert("ZipCode can't be longer than 6 letters!");
    }else if(modifyPhone.value.length > 11){
        alert("Phone can't be longer than 11 letters!");
    }else{
        var http = new XMLHttpRequest();
        http.onreadystatechange = function(){
            if (http.readyState==4 && http.status==200){
                location.reload();
            }
        };
        var url = '/section4/person/update';
        var data = 'name='+tableName.innerHTML+'&address='+modifyAddress.value+'&zipCode='+modifyZipCode.value+'&phone='+modifyPhone.value;
        http.open('POST',url,true);
        http.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        http.send(data);
    }
}

function deletePerson(name) {
    var http = new XMLHttpRequest();
    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            location.reload();
        }
    };
    var url = '/section4/person/delete';
    http.open('POST',url,true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
    http.send('name=' + name);
}
const url = 'http://localhost:8080/RevEmployeeReinbursement/';

document.getElementById("logbtn").addEventListener('click', logFunc);

async function logFunc(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username:usern,
        password:userp
    };
    let resp = await fetch(url+'login',{
        method:"POST",
         body: JSON.stringify(user), //will take JS object and makes it into jason. user is JS object. body is JSON object.
        credentials:'include'
        // Credentials:include will ensure that they cookie is captured,
        // future fetch requests will also require this value in order to send
        // the cookie back.
    });
    console.log('resp='+resp);
    if(resp.status === 200){
        console.log('rs'+resp.status);
        let data1 = await resp.json();   // get json response and store in JS object call data.// data is JS array.
      //  for (let users of data1) {
        if(data1 == 1){

                 createMangerPage();        
                document.getElementById('login-row').innerText="Manager... LOGIN SUCCESSFUL.Welcome to Employee Reinbursement System";
                
                }else{
                       
                       createEmployeePage();
                        document.getElementById('login-row').innerText="Employee... LOGIN SUCCESSFUL.Welcome to Employee Reinbursement System";
                  }
        }
    else {
        
        document.getElementById('login-row').innerText="Login failed. Invalid Username or Password";
    }
}
    async function reimFunc() {
            let response = await fetch(url+'reimbursement', {credentials:'include'});

            if (response.status === 200) {

                console.log('response from reimbursement'+response);
                let data = await response.json();// get json response and store in JS object call data.// data is JS array.
           
            for (let reimbursement of data) {

            console.log(reimbursement);
            let row = document.createElement("tr");

            let cell = document.createElement("td");  //create the cell
            cell.innerHTML = reimbursement.r_id;   // fills the cell
            row.appendChild(cell);              // append the cell.

            let cell2 = document.createElement("td");  //create the cell
            cell2.innerHTML = reimbursement.r_amount;   // fills the cell
            row.appendChild(cell2);              // append the cell.

            let cell3 = document.createElement("td");  //create the cell
            cell3.innerHTML = reimbursement.d_submitted;   // fills the cell
            row.appendChild(cell3);              // append the cell.

            let cell4 = document.createElement("td");  //create the cell
            cell4.innerHTML = reimbursement.d_resolved;   // fills the cell
            row.appendChild(cell4);              // append the cell.

            let cell5 = document.createElement("td");  //create the cell
            cell5.innerHTML = reimbursement.r_description;   // fills the cell
            row.appendChild(cell5);              // append the cell.

            let cell6 = document.createElement("td");  //create the cell
            cell6.innerHTML = reimbursement.r_author;   // fills the cell
            row.appendChild(cell6);              // append the cell.

            let cell7 = document.createElement("td");  //create the cell
            cell7.innerHTML = reimbursement.r_resolver;   // fills the cell
            row.appendChild(cell7);              // append the cell.

            let cell8 = document.createElement("td");  //create the cell
            cell8.innerHTML = reimbursement.r_status_id;   // fills the cell
            row.appendChild(cell8);              // append the cell.

            let cell9= document.createElement("td");  //create the cell
            cell9.innerHTML = reimbursement.r_type_id;   // fills the cell
            row.appendChild(cell9);              // append the cell.


           
            document.getElementById("rbody").appendChild(row); 
            // adds the entire row to the tbody tag inside the table b/d of "avbody"
        }
    }


}
function createEmployeePage(){

    document.getElementById("NewReqButton").addEventListener('click', createNewRequest);
    
    document.getElementById("PastTicketsButton").addEventListener('click', employeePastTicketsFunc);
    
       
       
}
async function createNewRequest(){

    let reimbursementType = document.getElementById("reimbursementType").value;
    let reimbursementAmount = document.getElementById("ReimbursementAmount").value;
    let reimbursementDescription = document.getElementById("ReimbursementDescription").value;

    let newRequest = {
        r_type_id:reimbursementType,
        r_amount:reimbursementAmount,
        r_description:reimbursementDescription 
    };
    let respons = await fetch(url+'newRequest',{
        method:"POST",
        body: JSON.stringify(newRequest),      //will take JS object and makes it into jason. newRequest is JS object. body1 is JSON object.
        credentials:'include'
    });

}


function createMangerPage(){

        document.getElementById("viewAllReimbsButton").addEventListener('click', reimFunc);
        
       document.getElementById("StatusButton").addEventListener('click', reimStatusFunc);
        
}



async function reimStatusFunc(){

    let reimbursementStatus = document.getElementById("reimbursementStatus").value;
    let status = {

        r_status_id:reimbursementStatus
      
    };
    let resp = await fetch(url+'status',{
        method:"POST",
         body: JSON.stringify(status), //will take JS object and makes it into jason. user is JS object. body is JSON object.
        credentials:'include'
        // Credentials:include will ensure that they cookie is captured,
        // future fetch requests will also require this value in order to send
        // the cookie back.
    });
    if (resp.status === 200) {

        
        let data = await resp.json();// get json response and store in JS object call data.// data is JS array.
   
        for (let reimbursement of data) {



        console.log(reimbursement);
        let row = document.createElement("tr");

        let cell = document.createElement("td");  //create the cell
        cell.innerHTML = reimbursement.r_id;   // fills the cell
        row.appendChild(cell);              // append the cell.

        let cell2 = document.createElement("td");  //create the cell
        cell2.innerHTML = reimbursement.r_amount;   // fills the cell
        row.appendChild(cell2);              // append the cell.

        let cell3 = document.createElement("td");  //create the cell
        cell3.innerHTML = reimbursement.d_submitted;   // fills the cell
        row.appendChild(cell3);              // append the cell.

        let cell4 = document.createElement("td");  //create the cell
        cell4.innerHTML = reimbursement.d_resolved;   // fills the cell
        row.appendChild(cell4);              // append the cell.

        let cell5 = document.createElement("td");  //create the cell
        cell5.innerHTML = reimbursement.r_description;   // fills the cell
        row.appendChild(cell5);              // append the cell.

        let cell6 = document.createElement("td");  //create the cell
        cell6.innerHTML = reimbursement.r_author;   // fills the cell
        row.appendChild(cell6);              // append the cell.

        let cell7 = document.createElement("td");  //create the cell
        cell7.innerHTML = reimbursement.r_resolver;   // fills the cell
        row.appendChild(cell7);              // append the cell.

        let cell8 = document.createElement("td");  //create the cell
        cell8.innerHTML = reimbursement.r_status_id;   // fills the cell
        row.appendChild(cell8);              // append the cell.

        let cell9= document.createElement("td");  //create the cell
        cell9.innerHTML = reimbursement.r_type_id;   // fills the cell
        row.appendChild(cell9);              // append the cell.


       
        document.getElementById("rbody").appendChild(row); 
        // adds the entire row to the tbody tag inside the table b/d of "avbody"
   
}}}


async function employeePastTicketsFunc(){
    console.log("in empPastTickets");
    let response = await fetch(url+'empPastTickets', {credentials:'include'});

    if (response.status === 200) {

        
        let data = await response.json();// get json response and store in JS object call data.// data is JS array.
   
        for (let reimbursement of data) {



        console.log(reimbursement);
        let row = document.createElement("tr");

        let cell = document.createElement("td");  //create the cell
        cell.innerHTML = reimbursement.r_id;   // fills the cell
        row.appendChild(cell);              // append the cell.

        let cell2 = document.createElement("td");  //create the cell
        cell2.innerHTML = reimbursement.r_amount;   // fills the cell
        row.appendChild(cell2);              // append the cell.

        let cell3 = document.createElement("td");  //create the cell
        cell3.innerHTML = reimbursement.d_submitted;   // fills the cell
        row.appendChild(cell3);              // append the cell.

        let cell4 = document.createElement("td");  //create the cell
        cell4.innerHTML = reimbursement.d_resolved;   // fills the cell
        row.appendChild(cell4);              // append the cell.

        let cell5 = document.createElement("td");  //create the cell
        cell5.innerHTML = reimbursement.r_description;   // fills the cell
        row.appendChild(cell5);              // append the cell.

        let cell6 = document.createElement("td");  //create the cell
        cell6.innerHTML = reimbursement.r_author;   // fills the cell
        row.appendChild(cell6);              // append the cell.

        let cell7 = document.createElement("td");  //create the cell
        cell7.innerHTML = reimbursement.r_resolver;   // fills the cell
        row.appendChild(cell7);              // append the cell.

        let cell8 = document.createElement("td");  //create the cell
        cell8.innerHTML = reimbursement.r_status_id;   // fills the cell
        row.appendChild(cell8);              // append the cell.

        let cell9= document.createElement("td");  //create the cell
        cell9.innerHTML = reimbursement.r_type_id;   // fills the cell
        row.appendChild(cell9);              // append the cell.


       
        document.getElementById("rbody").appendChild(row); 
        // adds the entire row to the tbody tag inside the table b/d of "avbody"

}}}
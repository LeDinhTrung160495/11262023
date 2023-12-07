function changeSortBy(){
    let sortBy = document.getElementById("sortBy").value;
    //Gọi controller
    window.location="findBill?sortBy="+sortBy;
}
function changeDirection(){
    let direction = document.getElementById("direction").value;
    window.location="findBill?direction="+direction;
}
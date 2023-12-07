function changeSortBy(){
    let sortBy = document.getElementById("sortBy").value;
    //Gọi controller
    window.location="findBillDetail?sortBy="+sortBy;
}
function changeDirection(){
    let direction = document.getElementById("direction").value;
    window.location="findBillDetail?direction="+direction;
}
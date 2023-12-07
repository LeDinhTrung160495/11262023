function changeSortBy() {
    let sortBy = document.getElementById("sortBy").value;
    //Gọi controller
    window.location = "findCatalog?sortBy=" + sortBy;
}

function changeDirection() {
    let direction = document.getElementById("direction").value;
    window.location = "findCatalog?direction=" + direction;
}

// function getCatalogId(updateCatalogId) {
//     // let updateCatalogId = document.getElementById("updateCatalogId").value;
//     console.log("================",updateCatalogId);
//     window.location = "initUpdate?catalogId=" + updateCatalogId;
// }

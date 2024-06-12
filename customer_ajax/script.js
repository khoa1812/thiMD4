getAllTransaction();

function getAllTransaction() {
    $.ajax({
        url: "http://localhost:8080/api/transaction",
        method: "get",
        
        success: function (data){
            console.log(data);
            let arrTran = data.map((t,i,arr) =>{
                return `
                <tr>
                <td>${t.transId}</td>
                <td>${t.customer.name}</td>
                <td>${t.dot}</td>
                <td>${t.type}</td>
                <td>${t.price}</td>
                <td>${t.area}</td>
                <td>
                <a href="javascript:void(0)" onclick="showFormDelete(${t.id})">Delete</a>
                <a href="javascript:void(0)" onclick="showFormUpdate(${t.id})">Update</a>
                </td>
                </tr>
            `;
            });
            $("#tb-trans").html(arrTran.join(""));

        },
        error: function(jqXHR, status, e){
            console.log(e);
            
        }
    });
} 

function showTransByType() {
    let type = document.getElementById("search-trans").value;
    console.log(type);

    $.ajax({
        url: "http://localhost:8080/api/transaction?name=" + type,
        method: "get",

        success: function(data){
            console.log(data);

            let arrTrans = data.map((t, i, arr) => {
                return `
                <tr>
                <td>${t.transId}</td>
                <td>${t.customer.name}</td>
                <td>${t.dot}</td>
                <td>${t.type}</td>
                <td>${t.price}</td>
                <td>${t.area}</td>
                <td>
                <a href="javascript:void(0)" onclick="showFormDelete(${t.id})">Delete</a>
                <a href="javascript:void(0)" onclick="showFormUpdate(${t.id})">Update</a>
                </td>
                </tr>
                `;
            });
            $("#tb-trans").html(arrTrans.join(""));
        
        },
    })
}

function showTransByCustomerName() {
    let id = document.getElementById("cName-option").value;
    console.log(id);

    $.ajax({
        url: "http://localhost:8080/api/transaction/cName/" + id,
        method: "get",

        success: function(data){
            console.log(data);

            let arrTrans = data.map((p, i, arr) => {
                return `
                <tr>
                <td>${t.transId}</td>
                <td>${t.customer.name}</td>
                <td>${t.dot}</td>
                <td>${t.type}</td>
                <td>${t.price}</td>
                <td>${t.area}</td>
                <td>
                <a href="javascript:void(0)" onclick="showFormDelete(${t.id})">Delete</a>
                <a href="javascript:void(0)" onclick="showFormUpdate(${t.id})">Update</a>
                </td>
                </tr>
                `;
            });
            $("#tb-trans").html(arrTrans.join(""));
        },
    })
}

function showFormCreate(){
    $("#form-create").show();
    $("#tb-head").hide();
}

function createNewTrans() {
    let transId = $("#transId").val()
    let customer = $("#customer").val()
    let dot = $("#dot").val()
    let type = $("#type").val()
    let price = $("#price").val()
    let area = $("#area").val()
    

    $.ajax({
        method: "post",
        url: "http://localhost:8080/api/transaction",
        contentType: "application/json",
        data: JSON.stringify({
            "transId": transId,
            "customer": {
                "id": customer
            },
            "dot": dot,
            "type": type,
            "price": price,
            "area": area,
    
        }),
        success: function (data) {
            console.log(data);
            console.log("Transaction added successfully. Redirecting to index.html", data);
            window.location.href = "index.html";
        },
        error: function(jqXHR, status, e){
            console.log(e);
        }
    });
}

function showFormDelete(id){
    $.ajax({
        url: "http://localhost:8080/api/transaction/" + id,
        method: "get",
        
        success: function (data){
            console.log(data);
            $("#delete-trans-info").html(`
                <strong>Mã giao dịch:</strong> ${data.transId} <br>
                <strong>Tên khách hàng:</strong> ${data.customer.name} <br>
                <strong>Ngày giao dịch:</strong> ${data.dot} <br>
                <strong>Loại:</strong> ${data.type} <br>
                <strong>Đơn giá:</strong> ${data.price} <br>
                <strong>Diện tích:</strong> ${data.area} <br>
            `);

            $("#delete-confirmation").show();

            $("#confirm-delete-button").off("click").on("click", function() {
                confirmDelete(id);
            });

            $("#tb-head").hide();
        },
        
        error: function(jqXHR, status, e) {
            console.log(e);
        }
    });
}

function confirmDelete(id){
    console.log("Preparing to delete Transaction with id:", id);

    $.ajax({
        url: "http://localhost:8080/api/transaction/" + id,
        method: "delete",
        
        success: function () {
            console.log("Transaction deleted successfully. Redirecting to index.html");
            window.location.href = "index.html"; 
        },
        error: function(jqXHR, status, e) {
            console.log("Error deleting transaction:", e);
        }
    });
}
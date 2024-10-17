const baseUrl = "http://localhost:8082/springWebPos/";

// Generate Order ID
function generateOrderID() {
    $.ajax({
        url: baseUrl + "orders/generateOrderId",
        method: "GET",
        success: function (response) {
            $("#orderId").val(response.id);
        },
        error: function () {
            console.error("Error generating order ID");
        }
    });
}

// Load Customers
function loadCustomers() {
    $("#cmbCustomerId").empty();
    $.ajax({
        url: baseUrl + "customer",
        method: "GET",
        dataType: "json",
        success: function (customers) {
            customers.forEach(customer => {
                $("#cmbCustomerId").append(`<option value="${customer.id}">${customer.name}</option>`);
            });
        },
        error: function () {
            console.error("Error loading customers");
        }
    });
}

// Load Items
function loadItems() {
    $("#cmbItemCode").empty();
    $.ajax({
        url: baseUrl + "item",
        method: "GET",
        dataType: "json",
        success: function (items) {
            items.forEach(item => {
                $("#cmbItemCode").append(`<option value="${item.code}">${item.name}</option>`);
            });
        },
        error: function () {
            console.error("Error loading items");
        }
    });
}

// Add to Cart
$("#btnAddToCart").click(function () {
    const itemCode = $("#cmbItemCode").val();
    const itemName = $("#itemName").val();
    const itemPrice = parseFloat($("#itemPrice").val());
    const qty = parseInt($("#buyQty").val());
    const total = itemPrice * qty;

    let row = `<tr>
        <td>${itemCode}</td>
        <td>${itemName}</td>
        <td>${itemPrice.toFixed(2)}</td>
        <td>${qty}</td>
        <td>${total.toFixed(2)}</td>
    </tr>`;
    $("#tblAddToCart").append(row);
});

// Place Order
$("#btnPurchase").click(function () {
    let orderDetails = [];

    $("#tblAddToCart tr").each(function () {
        const itemCode = $(this).children().eq(0).text();
        const qty = $(this).children().eq(3).text();
        const price = $(this).children().eq(2).text();

        orderDetails.push({ itemCode, qty, price });
    });

    const order = {
        orderId: $("#orderId").val(),
        customerId: $("#cmbCustomerId").val(),
        date: $("#orderDate").val(),
        orderDetails: orderDetails
    };

    $.ajax({
        url: baseUrl + "orders",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(order),
        success: function () {
            alert("Order placed successfully");
            clearForm();
        },
        error: function () {
            console.error("Error placing order");
        }
    });
});

// Clear Form
function clearForm() {
    $("#orderForm")[0].reset();
    $("#tblAddToCart").empty();
}

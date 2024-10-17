# springboot-web-pos
 baseUrl = http://localhost:8082/springWebPos/

 #Orders
1.Create a New Order

Endpoint: /orders
Method: POST
Description: Creates a new order.
Request Body (JSON)

json

{
    "orderId": "ODI-001",
    "date": "2024-10-16",
    "customerId": "C001",
    "detail": [
        {
            "itemId": "I001",
            "qty": 2,
            "unitPrice": 1000
        },
        {
            "itemId": "I002",
            "qty": 1,
            "unitPrice": 1500
        }
    ]
}
Success Response

Status: 201 Created

json

{
    "message": "Order created successfully."
}

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to create the order due to an internal error."
}
son

{
    "message": "Failed to create the order due to an internal error."
}

2. Get All Orders

Endpoint: /orders
Method: GET
Description: Retrieves a list of all orders.
Success Response

Status: 200 OK

json

[
    {
        "orderId": "ODI-001",
        "date": "2024-10-16",
        "customerId": "C001",
        "detail": [
            {
                "itemId": "I001",
                "qty": 2,
                "unitPrice": 1000
            },
            {
                "itemId": "I002",
                "qty": 1,
                "unitPrice": 1500
            }
        ]
    },
    {
        "orderId": "ODI-002",
        "date": "2024-10-17",
        "customerId": "C002",
        "detail": [
            {
                "itemId": "I003",
                "qty": 3,
                "unitPrice": 500
            }
        ]
    }
]

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to retrieve orders due to an internal error."
}

3. Get Order by ID

Endpoint: /orders/{orderId}
Method: GET
Description: Retrieves the details of an order by its ID.
Path Parameter
Parameter	Type	     Description
orderId	   String	   The ID of the order.
Success Response

Status: 200 OK

json

{
    "orderId": "ODI-001",
    "date": "2024-10-16",
    "customerId": "C001",
    "detail": [
        {
            "itemId": "I001",
            "qty": 2,
            "unitPrice": 1000
        },
        {
            "itemId": "I002",
            "qty": 1,
            "unitPrice": 1500
        }
    ]
}

Error Response

Status: 404 Not Found

json

{
    "message": "Order with ID ODI-001 not found."
}

4. Update an Order

Endpoint: /orders/{orderId}
Method: PUT
Description: Updates an existing order by its ID.
Path Parameter
Parameter	Type	   Description
orderId	  String	     The ID of the order.
Request Body (JSON)

json

{
    "itemId": "I003",
    "qty": 5,
    "unitPrice": 500
}

Success Response

Status: 204 No Content
Error Response

Status: 404 Not Found

json

{
    "message": "Order with ID ODI-001 not found."
}

5. Delete an Order

Endpoint: /orders/{orderId}
Method: DELETE
Description: Deletes an order by its ID.
Path Parameter
Parameter	Type	Description
orderId	    String	The ID of the order.
Success Response

Status: 204 No Content
Error Response

Status: 404 Not Found

json

{
    "message": "Order with ID ODI-001 not found."
}

6. Generate a New Order ID

Endpoint: /orders/generateOrderId
Method: GET
Description: Generates a new unique order ID.
Success Response

Status: 200 OK

json

{
    "orderId": "ODI-002"
}

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to generate new order ID."
}

Customer
1. Create a New Customer

Endpoint: /customer
Method: POST
Description: Creates a new customer.
Request Body (JSON)

json

{
    "customerId": "C00-001",
    "customerName": "John Doe",
    "customerAddress": "123 Main St",
    "customerSalary": 25000
}

Success Response

Status: 201 Created

json

{
    "message": "Customer created successfully."
}

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to create the customer due to an internal error."
}

2. Get All Customers

Endpoint: /customer
Method: GET
Description: Retrieves a list of all customers.
Success Response

Status: 200 OK

json

[
    {
        "customerId": "C00-001",
        "customerName": "John Doe",
        "customerAddress": "123 Main St",
        "customerSalary": 25000
    },
    {
        "customerId": "C00-002",
        "customerName": "Jane Smith",
        "customerAddress": "456 Elm St",
        "customerSalary": 30000
    }
]

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to retrieve customers due to an internal error."
}

3. Get Customer by ID

Endpoint: /customer/{customerId}
Method: GET
Description: Retrieves the details of a customer by their ID.
Path Parameter
Parameter	Type	Description
customerId	String	The ID of the customer.
Success Response

Status: 200 OK

json

{
    "customerId": "C00-001",
    "customerName": "John Doe",
    "customerAddress": "123 Main St",
    "customerSalary": 25000
}

Error Response

Status: 404 Not Found

json

{
    "message": "Customer with ID C001 not found."
}

4. Update Customer

Endpoint: /customer/{customerId}
Method: PUT
Description: Updates an existing customer by their ID.
Path Parameter
Parameter	Type	Description
customerId	String	The ID of the customer.
Request Body (JSON)

json

{
    "customerName": "John Doe Updated",
    "customerAddress": "789 Oak St",
    "customerSalary": 28000
}

Success Response

Status: 204 No Content
Error Response

Status: 404 Not Found

json

{
    "message": "Customer with ID C00-001 not found."
}

5. Delete a Customer

Endpoint: /customer/{customerId}
Method: DELETE
Description: Deletes a customer by their ID.
Path Parameter
Parameter	Type	Description
customerId	String	The ID of the customer.
Success Response

Status: 204 No Content
Error Response

Status: 404 Not Found

json

{
    "message": "Customer with ID C001 not found."
}

6. Generate a New Customer ID

Endpoint: /customer/generateCustomerId
Method: GET
Description: Generates a new unique customer ID.
Success Response

Status: 200 OK

json

{
    "id": "C00-002"
}

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to generate new customer ID."
}

Item

1. Create a New Item

Endpoint: /item
Method: POST
Description: Creates a new item.
Request Body (JSON)

json

{
    "itemId": "I00-001",
    "itemName": "Laptop",
    "itemQty": 10,
    "itemPrice": 1500.00
}

Success Response

Status: 201 Created

json

{
    "message": "Item created successfully."
}

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to create the item due to an internal error."
}

2. Get All Items

Endpoint: /item
Method: GET
Description: Retrieves a list of all items.
Success Response

Status: 200 OK

json

[
    {
        "itemId": "I00-001",
        "itemName": "Laptop",
        "itemQty": 10,
        "itemPrice": 1500.00
    },
    {
        "itemId": "I00-002",
        "itemName": "Smartphone",
        "itemQty": 20,
        "itemPrice": 800.00
    }
]

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to retrieve items due to an internal error."
}

3. Get Item by ID

Endpoint: /item/{itemId}
Method: GET
Description: Retrieves the details of an item by its ID.
Path Parameter
Parameter	Type	Description
itemId	String	The ID of the item.
Success Response

Status: 200 OK

json

{
    "itemId": "I00-001",
    "itemName": "Laptop",
    "itemQty": 10,
    "itemPrice": 1500.00
}

Error Response

Status: 404 Not Found

json

{
    "message": "Item with ID I00-001 not found."
}

4. Update an Item

Endpoint: /item/{itemId}
Method: PUT
Description: Updates an existing item by its ID.
Path Parameter
Parameter	Type	Description
itemId	String	The ID of the item.
Request Body (JSON)

json

{
    "itemName": "Laptop Pro",
    "itemQty": 15,
    "itemPrice": 1600.00
}

Success Response

Status: 204 No Content
Error Response

Status: 404 Not Found

json

{
    "message": "Item with ID I00-001 not found."
}

5. Delete an Item

Endpoint: /item/{itemId}
Method: DELETE
Description: Deletes an item by its ID.
Path Parameter
Parameter	Type	Description
itemId	String	The ID of the item.
Success Response

Status: 204 No Content
Error Response

Status: 404 Not Found

json

{
    "message": "Item with ID I00-001 not found."
}

6. Generate a New Item ID

Endpoint: /item/generateItemId
Method: GET
Description: Generates a new unique item ID.
Success Response

Status: 200 OK

json

{
    "id": "I00-002"
}

Error Response

Status: 500 Internal Server Error

json

{
    "message": "Failed to generate new item ID."
}

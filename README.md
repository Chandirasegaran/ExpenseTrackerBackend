# Expense Tracker Backend API Documentation

## Base URL
```
http://localhost:8080/api/expense
```

## Endpoints

### 1. **Index**
**Description:** Check if the backend service is running.
- **URL:** `/`
- **Method:** `GET`
- **Response:**
    - `200 OK`: "Hello World! You are Successfully up and Running Expense Tracker Backend"

### 2. **Add Expense**
**Description:** Add a new expense.
- **URL:** `/addExpense`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
      "itemName": "Groceries",
      "amount": 200.5,
      "date": "2025-01-12",
      "userEmail": "test@example.com"
  }
  ```
- **Response:**
    - `200 OK`: The created expense object.

### 3. **Get Expense by ID**
**Description:** Retrieve an expense by its ID.
- **URL:** `/getExpense/{id}`
- **Method:** `GET`
- **Path Parameters:**
    - `id` (Integer): Expense ID.
- **Response:**
    - `200 OK`: The expense object.
    - `404 Not Found`: "No Expense Found"

### 4. **Get All Expenses**
**Description:** Retrieve all expenses.
- **URL:** `/getAllExpenses`
- **Method:** `GET`
- **Response:**
    - `200 OK`: A list of all expenses.
    - `404 Not Found`: "No Expenses Found"

### 5. **Delete Expense by ID**
**Description:** Delete an expense by its ID.
- **URL:** `/deleteExpense/{id}`
- **Method:** `DELETE`
- **Path Parameters:**
    - `id` (Integer): Expense ID.
- **Response:**
    - `200 OK`: The deleted expense object.
    - `404 Not Found`: "No Expense Found"

### 6. **Update Expense by ID**
**Description:** Update an existing expense by its ID.
- **URL:** `/updateExpense/{id}`
- **Method:** `PUT`
- **Path Parameters:**
    - `id` (Integer): Expense ID.
- **Request Body:**
  ```json
  {
      "itemName": "Updated Item",
      "amount": 300.0,
      "date": "2025-01-12",
      "userEmail": "test@example.com"
  }
  ```
- **Response:**
    - `200 OK`: The updated expense object.
    - `404 Not Found`: "No Expense Found"

### 7. **Get Expenses by Email**
**Description:** Retrieve all expenses for a specific user email.
- **URL:** `/getExpensesByEmail/{email}`
- **Method:** `GET`
- **Path Parameters:**
    - `email` (String): User email.
- **Response:**
    - `200 OK`: A list of expenses for the user.
    - `404 Not Found`: "No Expense Found"

### 8. **Get Expense by Date**
**Description:** Retrieve all expenses for a specific date.
- **URL:** `/getExpenseByDate/{date}`
- **Method:** `GET`
- **Path Parameters:**
    - `date` (String, format: `yyyy-MM-dd`): The date to filter by.
- **Response:**
    - `200 OK`: A list of expenses for the specified date.
    - `404 Not Found`: "No Expense Found"

### 9. **Get Expenses by Date and Email**
**Description:** Retrieve all expenses for a specific date and user email.
- **URL:** `/getExpensesByDateAndEmail/{date}/{email}`
- **Method:** `GET`
- **Path Parameters:**
    - `date` (String, format: `yyyy-MM-dd`): The date to filter by.
    - `email` (String): User email.
- **Response:**
    - `200 OK`: A list of expenses for the specified date and user email.
    - `404 Not Found`: "No Expense Found"

### 10. **Get Expenses by Month, Year, and Email**
**Description:** Retrieve all expenses for a specific month, year, and user email.
- **URL:** `/getExpensesByMonthAndEmail/{month}/{year}/{email}`
- **Method:** `GET`
- **Path Parameters:**
    - `month` (Integer): The month to filter by (1-12).
    - `year` (Integer): The year to filter by.
    - `email` (String): User email.
- **Response:**
    - `200 OK`: A list of expenses for the specified month, year, and user email.
    - `404 Not Found`: "No Expense Found"

---

## Notes
1. All dates in the request must follow the format `yyyy-MM-dd`.
2. The responses return HTTP status codes and relevant messages to indicate success or failure.
3. Ensure that your database is properly seeded with test data to verify the endpoints.
4. The API supports operations for creating, reading, updating, and deleting (CRUD) expenses, along with advanced filtering options by date, email, and month-year combinations.


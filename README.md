# user-validation

Validating the user details

# user-validation

Validating the user details

##Sample Request and Response
URL1 :
curl --location 'http://localhost:8080/api/auth/save' \
--header 'Content-Type: application/json' \
--data-raw '{
"username" : "karthik1234",
"password" : "karthik1234",
"email" : "karhtik1234@gmail.com"
}
'

URL2 :
curl --location 'http://localhost:8080/api/auth/login' \
--header 'Content-Type: application/json' \
--data '{
"username" : "karthik1234",
"password" : "karthik1234"
}'

URL3 :
curl --location 'http://localhost:8080/api/transactions/save' \
--header 'Content-Type: application/json' \
--data '{
"username": "karthik1234",
"description": "Purchase at ABC Store",
"transactionDate": "2023-12-15",
"amount": 25.50,
"currency": "INR",
"status": "completed"
}'

URL4 :
curl --location 'http://localhost:8080/api/transactions' \
--header 'Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYXJ0aGlrMTIzNCJ9.wbKvXLtK5q0BR9hQJPzpfYTmL81EmL69zMkYPBGxTc8'

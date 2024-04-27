##########					##########
     STOCKINVENTORY PROJECT
##########					##########

Project Description:
   ## StockInventory Project is doing the below task which execute when the API call.
   (1) Register and Authenticate:
       (i)Register the User:
          APICurl:
                 curl --location --request POST 'http://localhost:8080/auth/signup' \
				 --header 'Content-Type: application/json' \
				 --data-raw '{
    			 "email":"xxxxxxx@gmail.com",
    			 "password":"xxxxxxx",
    			 "fullName":"xxxxxxx"
                 }'
       (ii)Authenticate the User:
          APICurl:
                 curl --location --request POST 'http://localhost:8080/auth/login' \
				 --header 'Content-Type: application/json' \
				 --data-raw '{
    			 "email":"xxxxxxxx@gmail.com",
    			 "password":"xxxxxxxx"
				}'
	   (iii)Create Stock:
          APICurl:
                 curl --location --request POST 'http://localhost:8080/api/v1/stock' \
                 --header 'Authorization: Bearer 			 eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1AZ21haWwuY29tIiwiaWF0IjoxNzEzOTg0MzI1LCJleHAiOjE3MTQwNzA3MjV9.x9fEu2zvOb6XfZjDZcRlX2C0-4B3TcaY_dHmL2XKMDw' \
				--header 'Content-Type: application/json' \
				--data-raw '{
    			"stockName":"Clothes",
    			"stockDescription":"Slik Dress",
    			"stockSize":100
				}'
       (iv)Get Stock:
          APICurl:
                curl --location --request GET 'http://localhost:8080/api/v1/stock/56' \
				--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1AZ21haWwuY29tIiwiaWF0IjoxNzEzOTg0MzI1LCJleHAiOjE3MTQwNzA3MjV9.x9fEu2zvOb6XfZjDZcRlX2C0-4B3TcaY_dHmL2XKMDw'
	   (v)Get All Stock:
	      APICurl:
	            curl --location --request GET 'http://localhost:8080/api/v1/stock' \
				--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1AZ21haWwuY29tIiwiaWF0IjoxNzEzOTg0MzI1LCJleHAiOjE3MTQwNzA3MjV9.x9fEu2zvOb6XfZjDZcRlX2C0-4B3TcaY_dHmL2XKMDw'
	   (vi)Update Stock:
	      APICurl:
	      curl --location --request PUT 'http://localhost:8080/api/v1/stock/102' \
		  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1AZ21haWwuY29tIiwiaWF0IjoxNzEzOTg0MzI1LCJleHAiOjE3MTQwNzA3MjV9.x9fEu2zvOb6XfZjDZcRlX2C0-4B3TcaY_dHmL2XKMDw' \
		--header 'Content-Type: application/json' \
		--data-raw '    {
        "stockName": "ClothesSilkNylon",
        "stockDescription": "Nylon Cotton Best",
        "stockSize": 200
    }'
       (vii)Delete Stock:
           APICurl:
           curl --location --request DELETE 'http://localhost:8080/api/v1/stock/52' \
		   --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1AZ21haWwuY29tIiwiaWF0IjoxNzEzOTg0MzI1LCJleHAiOjE3MTQwNzA3MjV9.x9fEu2zvOb6XfZjDZcRlX2C0-4B3TcaY_dHmL2XKMDw'
	  (viii)SaleInventory Stock Update:
		    APICurl:
		    curl --location --request POST 'http://localhost:8080/api/v1/inventory/sale' \
			--header 'Authorization: Bearer 			eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1wQGdtYWlsLmNvbSIsImlhdCI6MTcxNDA3MDk4OCwiZXhwIjoxNzE0MTU3Mzg4fQ.Q1psbQfdjZ62oaHef9QWRTYWMe8cx7r_12vyYmI7uZM' \
			--header 'Content-Type: application/json' \
			--data-raw '{
    		"inventoryStockname":"Shoes",
    		"inventorySaleStockCurrentsize":200
			}'
	  (ix)OrderInventory Stock Update:
			 APICurl:
			 curl --location --request POST 'http://localhost:8080/api/v1/inventory/order' \
			 --header 'Authorization: Bearer 			eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnVwYW1wQGdtYWlsLmNvbSIsImlhdCI6MTcxNDA3MDk4OCwiZXhwIjoxNzE0MTU3Mzg4fQ.Q1psbQfdjZ62oaHef9QWRTYWMe8cx7r_12vyYmI7uZM' \
			--header 'Content-Type: application/json' \
			--data-raw '{
    		"inventoryStockname":"Shoes",
    		"inventoryOrderStockCurrentsize":200
			}'
	############
	     (1)For Some Exception for Negative Case
	        (i)Stock Alreday Exist
	        (ii)Not Stock Found
	        (iii)Negative Stock Found
	        
				
		
  
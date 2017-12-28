1. Run dbscripts.sql on your msql database
1. Configure src/main/resources/application.properties

   1. MySQL db details where #1 was run
   1. Provided user should have select/create/update/delete permission on both drivers and orders table
   
1. Execute `mvn spring-boot:run`
1. Service should be up on port 8080 if all went well
1. `GET http://localhost:8080/drivers/` should get details of all drivers
   
       curl -X GET \
       http://localhost:8080/drivers/
          
1. `POST http://localhost:8080/orders/` with appropriate order details to book a driver

       curl -X POST \
          http://localhost:8080/orders/ \
          -H 'content-type: application/json' \
          -d '{
            "customerName": "C3",
            "position":{
                "latitude": 0.1,
                "longitude": 0.2
            }
       }'

1. `GET http://localhost:8080/drivers/available` should get details of all available drivers
   
       curl -X GET \
       http://localhost:8080/drivers/available
          
1. `DELETE http://localhost:8080/orders/` to clear up all orders and free up all drivers

       curl -X DELETE \
       http://localhost:8080/orders/     
          
       
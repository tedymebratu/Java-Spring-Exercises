I Have implemented the following URIs.
I have modified two request methods from the given API (Swagger): 1 and 2

Dataset
1. Post: /api/{datasetId}    -- in API given as Get
2. Get: /api/{datasetId}     -- in API given as Post

Dealers
3. Get: /api/{datasetId}/dealers/{dealerId}

Vehicles
4. Get: /api/{datasetId}/vehicles
5. Get: /api/{datasetId}/vehicles/{vehicleId}



curl command:
1. Post: /api/{datasetId}
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"username":"xyz","password":"xyz"}' \
  http://localhost:8080/api/abc


2. Get: /api/{datasetId} 
curl -v http://localhost:8080/api/abc


3. Get: /api/{datasetId}/dealers/{dealerId}
curl -v http://localhost:8080/api/abc/delaers/1


4. Get: /api/{datasetId}/vehicles
curl -v http://localhost:8080/api/abc/vehicles


5. Get: /api/{datasetId}/vehicles/{vehicleId}
curl -v http://localhost:8080/api/abc/vehicles/1







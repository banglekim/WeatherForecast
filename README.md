# Weather
Demo project to get weather forecast for tomorrow for a specific city/location provided by zip code and other features (maybe)
1. General guideline:
- Download source code and build from IntelliJ or run the executable file weather-0.0.1-SNAPSHOT.jar 
uploaded into this repository.

- API documentation via swagger: http://{host}:8080/swagger-ui.html#/

- Test Restful API via browser or postman via: http://{host}:8080/api/weather/tomorrow/{zipCode}

- Test Web interface: http://{host}:8080/weather/tomorrow/{zipCode}

2. Security guidelines:
- Accounts can be used for testing:
    + user with (username, password) = ("user","password") can access webapp but not for API link
    + user with (username, password) = ("admin","password") can access webapp and API link
FROM amazoncorretto:17
LABEL authors="khanm"
COPY target/order-0.0.1.jar order-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/order-0.0.1.jar"]
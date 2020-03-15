FROM openjdk:11
COPY ./target/seMethodsCoursework.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods.jar","db:3306"]

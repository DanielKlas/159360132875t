FROM openjdk:11
COPY ./target/course_work-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CourseWork-1.0-SNAPSHOT-jar-with-dependencies.jar"]

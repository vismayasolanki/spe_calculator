FROM openjdk
COPY ./target/SPE_MINI_PROJECT-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "SPE_MINI_PROJECT-1.0-SNAPSHOT-jar-with-dependencies.jar"]


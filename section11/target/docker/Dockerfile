FROM openjdk:netcat
RUN mkdir -p /usr/local/cargoservice
ADD  section11-1.0-SNAPSHOT.jar /usr/local/cargoservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh

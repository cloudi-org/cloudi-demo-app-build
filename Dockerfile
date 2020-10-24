FROM registry.access.redhat.com/ubi8/openjdk-11

#COPY target/quarkus-app /deployments/
COPY target/*.jar /deployments/
COPY target/lib/ /deployments/lib/

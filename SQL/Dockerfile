# This is a comment line! The docker build will FAIL if you put any code above the FROM command.
# The FROM command MUST be the first thing to get executed!
#FROM openjdk:latest
# Troubleshooting:
#     Ensure that docker desktop is running on your PC, eg. in the Taskbar
#     Build your project before running this dockerfile.
#     Delete existing docker containers.
#COPY target/classes /tmp
#COPY ./target/seMethods-0.1.0.1-jar-with-dependencies.jar /tmp
#WORKDIR /tmp
#CMD ["echo", "-----------------------------------------> Running TestJavaProject_JBT..."]
#ENTRYPOINT ["java", "com.napier.sem.App"]
#ENTRYPOINT ["java", "-jar", "TestJavaProject_JBT-0.1.0.1-jar-with-dependencies.jar"]
#CMD ["echo", "-----------------------------------------> ...Finished Dockerfile commands."]


# Use the latest MySQL image
FROM mysql
# Set the working directory
WORKDIR /tmpSQL
# Copy all the files to the working directory of the container
COPY ./SQL/*.sql /tmp/
COPY ./SQL/*.dump /tmp/
# Copy the main SQL file to docker-entrypoint-initdb.d.
# Scripts and SQL files in this folder are executed on container startup.
# This is specific to MySQL.
COPY ./SQL/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD example
#This is a comment line! The docker build will FAIL if you put any code above the FROM command.
#The FROM command MUST be the first thing to get executed!
FROM openjdk:latest
COPY target/classes /tmp
WORKDIR /tmp
CMD ["echo", "-----------------------------------------> Running TestJavaProject_JBT..."]
ENTRYPOINT ["java", "com.napier.sem.App"]
CMD ["echo", "-----------------------------------------> ...Finished Dockerfile commands."]

FROM secdim/play-java:latest

LABEL vendor="SecDim"
LABEL copyright="Security Dimension Pty Ltd. All rights reserved"
LABEL description="SecDim Java Challenge"
LABEL version="1.0.0"

COPY --chown=gradle:gradle ./build.gradle /home/gradle
COPY --chown=gradle:gradle ./src /home/gradle/src
COPY --chown=gradle:gradle ./test /home/gradle/test
RUN gradle --no-daemon --info build -g/home/gradle
CMD ["java","-jar","/home/gradle/build/libs/gradle.jar"]

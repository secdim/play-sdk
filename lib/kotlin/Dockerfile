FROM secdim/play-kt:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim Kotlin Challenge" \
 version="1.0.0"

COPY --chown=gradle:gradle ./build.gradle /home/gradle
COPY --chown=gradle:gradle ./src /home/gradle/src
RUN gradle --no-daemon clean bootJar -x test
CMD ["java","-jar","/home/gradle/build/libs/app.jar"]

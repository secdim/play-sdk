FROM secdim/play-scala:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim Scala Challenge" \
 version="1.0.0"

COPY --chown=sbtuser:sbtuser ./build.sbt /home/sbtuser
COPY --chown=sbtuser:sbtuser ./project /home/sbtuser/project
COPY --chown=sbtuser:sbtuser ./src /home/sbtuser/src
RUN sbt compile
CMD ["sbt", "run"]

FROM secdim/play-c:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim C Challenge" \
 version="1.0.0"

ENV APP_HOME /app
WORKDIR $APP_HOME
COPY ./src ./

RUN gcc main.c name.c name.h -o main

CMD ["./main"]

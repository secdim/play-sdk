FROM secdim/play-rb:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim Ruby Challenge" \
 version="1.0.0"

ENV APP_HOME /app
ENV PORT 8080

WORKDIR $APP_HOME
COPY ./src ./

CMD ruby main.rb -p $PORT -o 0.0.0.0

FROM secdim/play-cs:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim C# Challenge" \
 version="2.0.0"

ENV APP_HOME /app
ENV PORT 8080
ENV ASPNETCORE_URLS http://0.0.0.0:${PORT}

WORKDIR ${APP_HOME}
COPY src src
COPY test test
RUN dotnet publish -c debug -o /app --no-restore

CMD dotnet ${APP_HOME}/program.dll

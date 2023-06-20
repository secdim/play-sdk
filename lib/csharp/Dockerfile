FROM secdim/play-cs:6.0

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim C# Challenge" \
 version="2.0.0"

WORKDIR /app

COPY src src
COPY test test
RUN dotnet publish -c debug -o /app --no-restore
EXPOSE 5000
CMD ["dotnet", "/app/program.dll"]

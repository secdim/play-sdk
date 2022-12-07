FROM secdim/play-cs:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim C# Challenge" \
 version="1.0.0"

COPY src src
COPY test test
RUN dotnet publish -c debug -o /app --no-restore
CMD ["dotnet", "/app/program.dll"]

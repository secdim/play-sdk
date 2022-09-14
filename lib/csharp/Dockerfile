FROM secdim/play-cs:latest

LABEL vendor="SecDim"
LABEL copyright="Security Dimension Pty Ltd. All rights reserved"
LABEL description="SecDim C# Challenge"
LABEL version="1.0.0"

COPY src src
COPY test test
RUN dotnet publish -c debug -o /app --no-restore
CMD ["dotnet", "/app/program.dll"]

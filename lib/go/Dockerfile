FROM secdim/play-go
LABEL vendor="SecDim"
LABEL copyright="Security Dimension Pty Ltd. All rights reserved"
LABEL description="SecDim Go Challenge"
LABEL version="1.0.0"
WORKDIR /app
COPY src ./
RUN ["go","build","-o","main","."]
CMD ["/app/main"]
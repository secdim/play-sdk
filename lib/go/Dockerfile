FROM secdim/play-go

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim Go Challenge" \
 version="1.0.0"

WORKDIR /app
COPY src ./
RUN ["go","build","-o","main","."]
CMD ["/app/main"]

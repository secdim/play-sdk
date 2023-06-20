FROM secdim/play-go:1.17

LABEL vendor="SecDim" \
    copyright="Security Dimension Pty Ltd. All rights reserved" \
    description="SecDim Go Challenge" \
    version="2.0.0"

WORKDIR /app
ENV PORT 8080
EXPOSE 8080
COPY src ./
RUN ["go","build","-o","main","."]
CMD ["/app/main"]

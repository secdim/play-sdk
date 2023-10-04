FROM secdim/play-sol:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim dApp Challenge" \
 version="1.0.0"

WORKDIR /app

COPY src ./
RUN forge build
CMD ["sh"]

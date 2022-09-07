FROM secdim/play-js:latest

LABEL vendor="SecDim"
LABEL copyright="Security Dimension Pty Ltd. All rights reserved"
LABEL description="SecDim JavaScript Challenge"
LABEL version="1.0.0"

WORKDIR /app
ENV PORT 8080
COPY src ./
EXPOSE 8080
CMD ["npm", "start"]

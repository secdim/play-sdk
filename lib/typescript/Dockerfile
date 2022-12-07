FROM secdim/play-ts:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim TypeScript Challenge" \
 version="1.0.0"

WORKDIR /app
ENV PORT 8080
COPY src ./
EXPOSE 8080
CMD ["npm", "start"]

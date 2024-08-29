FROM secdim/play-php:latest

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim PHP Challenge" \
 version="1.0.0"

WORKDIR /app
ENV PORT=8080
ENV APP_ENV="local"
ENV APP_URL="http://localhost"
ENV LOG_CHANNEL="stack"
COPY ./src ./
COPY ./src/database.sqlite /tmp
EXPOSE 8080
CMD ["php", "artisan", "serve", "--host=0.0.0.0", "--port=8080"]

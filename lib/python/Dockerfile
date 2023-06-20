FROM secdim/play-py

LABEL vendor="SecDim" \
 copyright="Security Dimension Pty Ltd. All rights reserved" \
 description="SecDim Python Challenge" \
 version="2.0.0"

WORKDIR /app
ENV PORT 8080
ENV PYTHONUNBUFFERED 1
COPY ./src ./
EXPOSE 8080
CMD [ "python", "manage.py", "runserver", "0.0.0.0:8080" ]

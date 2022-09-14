FROM secdim/play-py

LABEL vendor="SecDim"
LABEL copyright="Security Dimension Pty Ltd. All rights reserved"
LABEL description="SecDim Python Challenge"
LABEL version="1.0.0"

WORKDIR /app
ENV PORT 8080
ENV PYTHONUNBUFFERED 1
COPY ./src ./
EXPOSE 8080
CMD [ "python", "manage.py", "runserver", "0.0.0.0:8080" ]

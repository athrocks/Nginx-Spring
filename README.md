# Nginx with SSL/TLS Configuration

This repository contains a setup for running Nginx as a reverse proxy with SSL/TLS for secure communication. It includes configuration files, Docker integration, and steps for setting up and testing the environment locally or in production.

## Directory Structure
```plaintext
project
|
|-- nginx
|   |-- ssl
|   |   |-- nginx.crt        # SSL Certificate
|   |   |-- nginx.key        # SSL Private Key
|   |
|   |-- nginx.conf           # Nginx Configuration File
|
|-- docker-compose.yaml      # Docker Compose Configuration
|
|-- Dockerfile               # Dockerfile for Spring Boot application
```

## Features
- Reverse proxy setup using Nginx.
- Load balancing across multiple backend services.
- SSL/TLS encryption for secure communication.

## Prerequisites
1. **Docker & Docker Compose**
   - Install Docker: [Get Docker](https://docs.docker.com/get-docker/)
   - Install Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

2. **Generate SSL Certificates**
   - Generate a self-signed certificate for testing:
     ```bash
     openssl req -x509 -newkey rsa:4096 -sha256 -days 365 -nodes \
       -keyout nginx/ssl/nginx.key -out nginx/ssl/nginx.crt \
       -subj "/CN=localhost"
     ```

## How to Run
### 1. Build and Start the Services
```bash
mvn clean install # to install .jar files
```

```bash
docker-compose up --build
```

### 2. Access the Application
- HTTP: [http://localhost](http://localhost) (Redirects to HTTPS)
- HTTPS: [https://localhost](https://localhost)

### 3. Verify SSL
- Use a browser to confirm HTTPS works and verify the certificate details.
- Use `curl` to check:
  ```bash
  curl -k https://localhost
  ```

## Notes
1. **For Production**: Obtain SSL certificates from a trusted Certificate Authority (e.g., Let's Encrypt).

## Troubleshooting
1. **Check Nginx Logs**
   ```bash
   docker logs nginx-load-balancer
   ```
2. **Reload Nginx Configuration** (if running locally):
   ```bash
   nginx -s reload
   ```
3. **Test Certificate**:
   ```bash
   openssl x509 -in nginx/ssl/nginx.crt -text -noout
   

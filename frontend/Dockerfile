# syntax=docker/dockerfile:1

# Comments are provided throughout this file to help you get started.
# If you need more help, visit the Dockerfile reference guide at
# https://docs.docker.com/go/dockerfile-reference/

# Want to help us make this template better? Share your feedback here: https://forms.gle/ybq9Krt8jtBL3iCk7

ARG NODE_VERSION=22.9.0

################################################################################
# Use node image for base image for all stages.
FROM node:${NODE_VERSION}-alpine AS base

# Set working directory for all build stages.
WORKDIR /usr/src/app

COPY package*.json ./

# Install dependencies
RUN npm install

# Now copy the rest of the application files
COPY . .

# Build the Angular app
RUN npm run build

# Expose the port that the application listens on.
EXPOSE 4200

# Run the application.
CMD ["npm", "start"]

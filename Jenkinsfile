pipeline {
    agent any

    environment {
        // Name for your local Docker image and container
        IMAGE_NAME = "my-spring-app"
        IMAGE_TAG = "latest"
        CONTAINER_NAME = "spring-boot-container"
        APP_PORT = "8080"
        def BUILD_NUMBER="1"
        WORKSPACE = "/var/lib/jenkins/workspace/dockerME"
        dockerImageTag = "dockerME${env.BUILD_NUMBER}"
        // The secret is bound to an environment variable named 'GLOBAL_TOKEN'
        //MY_API_TOKEN_ID = credentials('MY_API_TOKEN_ID')
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                  git url: 'https://gitlab.com/baali-boudjemaa/dockerME.git',
                  credentialsId:  "gitlab-access"
                  branch: 'master'
                        }
            }
        }

        stage('Build JAR') {
            steps {
                // Ensure Maven is installed in Jenkins Tools or use ./mvnw
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Builds image using the Dockerfile in root
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Local Deploy') {
            steps {
                script {
                    // Stop and remove existing container if it's already running
                    sh "docker stop ${CONTAINER_NAME} || true"
                    sh "docker rm ${CONTAINER_NAME} || true"

                    // Start the new container on local port 8080
                    sh "docker run -d --name ${CONTAINER_NAME} -p ${APP_PORT}:${APP_PORT} ${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }
    }
}

/*
pipeline  {
agent any

    environment {
          def BUILD_NUMBER="1"
          WORKSPACE = "/var/lib/jenkins/workspace/dockerME"
           dockerImageTag = "dockerME${env.BUILD_NUMBER}"
            // The secret is bound to an environment variable named 'GLOBAL_TOKEN'
            //MY_API_TOKEN_ID = credentials('MY_API_TOKEN_ID')
        }
stages{
    
    stage('Clone Repo') {

       steps{ // for display purposes
        // Get some code from a GitHub repository
        script {
                 //echo "Using token in Stage 1: ${env.MY_API_TOKEN_ID}"
                 git url: 'https://gitlab.com/baali-boudjemaa/dockerME.git',
                 credentialsId:  "gitlab-access"
                 branch: 'master'
                }
            }
     }
    stage('Build docker') {
          steps{
            script {
                   sh "docker build -t my-spring-app ."
           }
          }
    }
    stage('Deploy docker'){
          steps{
                script {
                     echo "Docker Image Tag Name: ${env.dockerImageTag}"
                     //sh "docker stop dockerme || true && docker rm dockerme || true"
                     sh "docker run -p 8081:8080 -e PORT=8081 my-spring-app"
            }
          }
    }
}
}*/



pipeline {
    agent any

    environment {
        // Define Docker image name and tag
        DOCKER_IMAGE = "baaliboudjemaa/baaliboudjemaa"
        IMAGE_TAG = "latest"
        // ID of Docker Hub credentials stored in Jenkins
        DOCKER_CRED_ID = "docker-hub-credentials-id"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'git@gitlab.com:baali-boudjemaa/dockerME.git', credentialsId: 'MY_API_TOKEN_ID', branch: 'master'
            }
        }

        stage('Build Application & Docker Image') {
            steps {
                // Build the application and the Docker image using the Dockerfile
                sh 'docker build -t $DOCKER_IMAGE:$IMAGE_TAG .'
            }
        }

        stage('Push Docker Image') {
            steps {
                // Log in to Docker Hub using stored Jenkins credentials
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CRED_ID}", passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker push $DOCKER_IMAGE:$IMAGE_TAG'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                // Stop and remove existing container, then run a new one
                sh 'docker stop spring-app-container || true'
                sh 'docker rm spring-app-container || true'
                sh 'docker run -d --name spring-app-container -p 8080:8080 $DOCKER_IMAGE:$IMAGE_TAG'
            }
        }
    }
}


/*
pipeline  {
agent any



    environment {
      WORKSPACE = "/var/lib/jenkins/workspace/dockerME"
       dockerImageTag = "dockerME${env.BUILD_NUMBER}"
            // The secret is bound to an environment variable named 'GLOBAL_TOKEN'
            //kjkjlj
            MY_API_TOKEN_ID= "${MY_API_TOKEN_ID}"
        }
try{
    
    stage('Clone Repo') {

        // for display purposes
        // Get some code from a GitHub repository
        echo "Using token in Stage 1: ${env.MY_API_TOKEN_ID}"
        git url: 'git@gitlab.com:baali-boudjemaa/dockerME.git',
            credentialsId:  ${env.MY_API_TOKEN_ID}
            branch: 'master'
     }
    stage('Build docker') {
          def dockerImage = docker.build("dockerME")
    }
    stage('Deploy docker'){
          echo "Docker Image Tag Name: ${dockerImageTag}"
          sh "docker stop dockerME || true && docker rm dockerME || true"
          sh "docker run --name dockerME -d -p 8081:8081 dockerME"
    }
}catch(e){
    currentBuild.result = "FAILED"
    throw e
}
}

*/


/* pipeline {
    agent any
    environment {
        WORKSPACE = 'C:/ProgramData/Jenkins/.jenkins/workspace/dockerME'
        DOCKER_IMAGE_TAG = "dockerME${env.BUILD_NUMBER}"
        MY_API_TOKEN_ID = credentials('MY_API_TOKEN_ID')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                //sh 'mvn -B -DskipTests clean package'
                sh './mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
} */
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
                     sh "docker run -p 8081:8080 -e PORT=8080 my-spring-app"
            }
          }
    }
}
}
*/

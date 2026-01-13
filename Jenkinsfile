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

pipeline  {
agent any

    environment {
          WORKSPACE = "/var/lib/jenkins/workspace/dockerME"
           dockerImageTag = "dockerME${env.BUILD_NUMBER}"
            // The secret is bound to an environment variable named 'GLOBAL_TOKEN'
            MY_API_TOKEN_ID = credentials('MY_API_TOKEN_ID')
        }
stages{
    
    stage('Clone Repo') {

       steps{ // for display purposes
        // Get some code from a GitHub repository
        echo "Using token in Stage 1: ${env.MY_API_TOKEN_ID}"
        git url: 'git@gitlab.com:baali-boudjemaa/dockerME.git',
            credentialsId:  "${env.MY_API_TOKEN_ID}"
            branch: 'master'
            }
     }
    stage('Build docker') {
          steps{
           dockerImage = docker.build("dockerME:${env.BUILD_NUMBER}")
          }
    }
    stage('Deploy docker'){
          steps{echo "Docker Image Tag Name: ${dockerImageTag}"
          sh "docker stop dockerME || true && docker rm dockerME || true"
          sh "docker run --name dockerME -d -p 8081:8081 dockerME:${env.BUILD_NUMBER}"
          }
    }
}
}






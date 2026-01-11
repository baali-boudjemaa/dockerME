pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
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
}
/*
pipeline  {
agent any
    def WORKSPACE = "C:/ProgramData/Jenkins/.jenkins/workspace/dockerME"
    def dockerImageTag = "dockerME${env.BUILD_NUMBER}"
    environment {
            // The secret is bound to an environment variable named 'GLOBAL_TOKEN'
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
          def dockerImage = docker.build("dockerME:${env.BUILD_NUMBER}")
    }
    stage('Deploy docker'){
          echo "Docker Image Tag Name: ${dockerImageTag}"
          sh "docker stop dockerME || true && docker rm dockerME || true"
          sh "docker run --name dockerME -d -p 8081:8081 dockerME:${env.BUILD_NUMBER}"
    }
}catch(e){
    currentBuild.result = "FAILED"
    throw e
}
}




 */

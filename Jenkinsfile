pipeline {
    agent any // Allocates an available agent/node to run the pipeline
    stages {
        stage('Build') { // A logical section of the pipeline
            steps { // Actions/steps to perform in this stage
                echo 'Building the application...'
                // Example build command: sh 'make' or sh 'dotnet build'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Example test command: sh './jenkins/scripts/test.sh' or sh 'dotnet test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying to environment...'
                // Example deploy command: sh './jenkins/scripts/deploy.sh'
            }
        }
    }
}

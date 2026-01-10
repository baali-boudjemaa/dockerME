node {
    def WORKSPACE = "C:/ProgramData/Jenkins/.jenkins/workspace/dockerME"
    def dockerImageTag = "dockerME${env.BUILD_NUMBER}"
    environment {
            // The secret is bound to an environment variable named 'GLOBAL_TOKEN'
            GLOBAL_TOKEN = credentials('MY_API_TOKEN_ID')
        }
try{
    notifyBuild('STARTED')
    stage('Clone Repo') {
        // for display purposes
        // Get some code from a GitHub repository
        git url: 'git@gitlab.com:baali-boudjemaa/dockerME.git',
            credentialsId: (${{ secrets.CredentialId }})
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
}finally{
    notifyBuild(currentBuild.result)
 }
}


def notifyBuild(String buildStatus = 'STARTED'){

  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def now = new Date()

  // message
  def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
  def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
  def subject_email = "Spring boot Deployment"
  def details = """<p>${buildStatus} JOB </p>
    <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""

  // Email notification
  emailext (
     to: "baaliboudjemaaens@gmail.com",
     subject: subject_email,
     body: details,
     recipientProviders: [[$class: 'DevelopersRecipientProvider']]
  )

}

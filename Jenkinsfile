node {
    def WORKSPACE = "C:/ProgramData/Jenkins/.jenkins/workspace/dockerME"
    def dockerImageTag = "dockerME${env.BUILD_NUMBER}"
try{
    notifyBuild('STARTED')
    stage('Clone Repo') {
        // for display purposes
        // Get some code from a GitHub repository
        git url: 'git@gitlab.com:baali-boudjemaa/dockerME.git',
            credentialsId: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQCx9A5UfoGrrD58uJwJkCLl2Zcm5Kg7ceYrOH8kTGfRE3FibLp7+d0zC1/BaZxLfhCNEZb89tTo/DwTQvXAZUd5517H5AwR9sGIT0N6ghNmDYjDTlFXSoL1+uKXmCGV64C5O+WfpY+WuaG1iEX1kd2C9n9hqPTF9mAPGsG98b57WVqvDaXsI1hqcbZnuLsGGn6dpkFhfxS7m71YS2T7MtJrxqj2AQrbfjXDSZm4R6l+SDT0NFVzvOaYqjnsdVIzlBemDMhe+c3o7mBLGgLBW3Pi2vpfCsTdeUYzG1Wb/6DXXIusIZ7SX75Yn2AfwVPLQFzVgXWICo8ZLpbdOajrw+ZZ6AGwAGmpPLkn0Azf+W2OmcFD7s+btZVgxGlMW11FNHDZpiCyOs9wZO8vdCvtvl5mQYfTFCS4P/lPSfZQcILrwx9adfU7ADEqtSYH9lPz+EFMiTEJcbfoGmS7IFpQdIjVszI3Eis8HHtUsCEzClPtKeDZh53IL8rWX35RHwk5F8F2vzBIg+H029Fx2/4Du+/pL3KSX0IENNRGBxglL6dnx37s2vrme0IgKQdpyRCMp/A53CpZek4MIYG+00NTInYpQin4HU9DW5RHzh9NLZwO37uNHnyQ0sNT+h+kofn7ZjuV18BKbTF3bXqL14E3Bwz4fKJSCLYzYwz+p7ABjSwljw== baaliboudjemaaens@gmail.com',
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

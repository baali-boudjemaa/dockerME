node {
    def WORKSPACE = "C:/ProgramData/Jenkins/.jenkins/workspace/dockerME"
    def dockerImageTag = "dockerME${env.BUILD_NUMBER}"
try{
    notifyBuild('STARTED')
    stage('Clone Repo') {
        // for display purposes
        // Get some code from a GitHub repository
        git url: 'git@gitlab.com:baali-boudjemaa/dockerME.git',
            credentialsId: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCtJwIsMLNfcYXh5N8RwtBJ+V5DNuZYfoeDbqVrWdzsjRG01bgOuO9/0o9gf/dcKUCyuO28dVGU/+NnnKPERJjXFoAGSvFXUpzUMBdwWzv08nHYbtBUyACAOhfkMg43BIJRjPkG8cKKpme5z4zhTBv/ET7P0yf8EYx/74DkrjRFBgAEOuSwLekLriO3uUXUueGZ3TdvSyO2QHXoyzh+IHZdYSP0B+V17gehiZJtq9ruJgUFZevNW4UE2i8SbnDR0ESNvwsf9UrOHU2/f32Ra/TlYxWI5MzDCZdL07FeMU98SiJgwRXmpQ2QLG0Zt+1muUgyZ+AwXV/npwQK8Na+iPpa8z32bAwMZZnHwD7Uz9JOTtIXFm3aLU2lqqFFSoOCqCSiz59WNbFGUcAKiAPxA7AylLYQKqWZWM+Dlu0fhsvqz7jqcEoUTsx4425SphVWuuU9JD5sTJVOx8LmTsjdWQ4ePTC0f+Td6tzlbu0WCUjAKAobst6LmoFPTuDR0VDCKPc= docker@DESKTOP-FSM1NH9'
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

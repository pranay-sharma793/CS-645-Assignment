@NonCPS
def generateTag() {
    return "build-" + new Date().format("yyyyMMdd-HHmmss")
}

pipeline {
    environment {
        registry = "pranaysharma793/surveyformcd"
        registryCredential = 'dockercred'
    }
    agent any

    stages{

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                    sh 'echo ${BUILD_TIMESTAMP}'
//                     echo "Prakhar@79" | docker login --username pranaysharma793 --password-stdin
                    tag = generateTag()
                    docker.withRegistry('',registryCredential){
                      def customImage = docker.build("pranaysharma793/surveyformcd:"+tag)
                   }
               }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    sh 'echo ${BUILD_TIMESTAMP}'
//                     echo "Prakhar@79" | docker login --username pranaysharma793 --password-stdin
                    docker.withRegistry('',registryCredential) {
                        def image = docker.build('pranaysharma793/surveyformcd:'+tag, '.')
                        docker.withRegistry('',registryCredential) {
                            image.push()
                        }
                    }
                }
            }
        }

      stage('Deploying Rancher to single node') {
         steps {
            script{
               sh 'kubectl set image deployment/surveyform container-0=pranaysharma793/surveyformcd:'+tag
            }
         }
      }

    stage('Deploying Rancher to Load Balancer') {
       steps {
          script{
             sh 'kubectl set image deployment/surveyformlb container-0=pranaysharma793/surveyformcd:'+tag
          }
       }
    }


    }
}

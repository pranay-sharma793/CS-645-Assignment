pipeline {
    @NonCPS
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
//                     echo "Prakhar@79" | docker login --username pranaysharma793 --password-stdin
                    docker.withRegistry('',registryCredential){
                      def customImage = docker.build("pranaysharma793/surveyformcd:${BUILD_TIMESTAMP}")
                   }
               }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
//                     echo "Prakhar@79" | docker login --username pranaysharma793 --password-stdin
                    docker.withRegistry('',registryCredential) {
                        def image = docker.build('pranaysharma793/surveyformcd:${BUILD_TIMESTAMP}', '.')
                        docker.withRegistry('',registryCredential) {
                            image.push()
                        }
                    }
                }
            }
        }


        // stage('Deploy to Rancher') {
        //     steps {
        //         withCredentials([string(credentialsId: 'RANCHER-URL-CREDENTIALS-ID', variable: 'RANCHER_URL'),
        //                           string(credentialsId: 'RANCHER-API-TOKEN-CREDENTIALS-ID', variable: 'RANCHER_API_TOKEN')]) {
        //             sh "rancher login $RANCHER_URL -t $RANCHER_API_TOKEN --context $RANCHER_CONTEXT"
        //             sh "rancher kubectl set image deployment/YOUR-DEPLOYMENT-NAME YOUR-CONTAINER-NAME=YOUR-DOCKER-USERNAME/YOUR-IMAGE-NAME:$BUILD_NUMBER --namespace YOUR-NAMESPACE"
        //         }
        //     }
        // }

      stage('Deploying Rancher to single pod') {
         steps {
            script{
               sh 'kubectl set image deployment/deploymentone container-0=19982707/studentsurvey645:0.1'
            }
         }
      }
    }
}

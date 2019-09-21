pipeline {
    agent any
    tools {
        maven 'Maven' 
        jdk 'JDK'
    }  
    stages {
        stage('build') {
//            steps {
  //              sh 'mvn clean install'
    //        }
            steps {
                script {
                    withDockerServer([uri: "tcp://10.152.0.21:2377"]) {
                       withDockerRegistry([credentialsId: 'wgmartinez', url: "https://hub.docker.com/"]) {
                            // we give the image the same version as the .war package
//                          def image = docker.build("<myDockerRegistry>/<myDockerProjectRepo>:${branchVersion}", "--build-arg PACKAGE_VERSION=${branchVersion} ./tmp-docker-build-context")
                            //def image = docker.build("https://hub.docker.com/camel-order-api:master", "--build-arg PACKAGE_VERSION=master ./tmp-docker-build-context").inside("--volume=/var/run/docker.sock:/var/run/docker.sock")
                            def image = docker.build("my-image:${env.BUILD_ID}", "-f ${dockerfile} ./dockerfiles")  
                            //image.push(message: "test")
                        }   
                    }
                }
            }
        }
    }
}

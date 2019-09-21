pipeline {
    agent any
    tools {
        maven 'Maven' 
        jdk 'JDK'
    }  
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
                
                withDockerServer([uri: "tcp://10.152.0.2:2376"]) {
                    withDockerRegistry([credentialsId: 'wgmartinez', url: "https://hub.docker.com/"]) {
                        // we give the image the same version as the .war package
//                        def image = docker.build("<myDockerRegistry>/<myDockerProjectRepo>:${branchVersion}", "--build-arg PACKAGE_VERSION=${branchVersion} ./tmp-docker-build-context")
                          //def image = docker.build("<myDockerRegistry>/<myDockerProjectRepo>:master", "--build-arg PACKAGE_VERSION=master ./tmp-docker-build-context")
                        
                        docker.build('my-build-image').inside("--volume=/var/run/docker.sock:/var/run/docker.sock") {
   // The build here
}
                          image.push()
                    }   
                }
            }
        }
    }
}

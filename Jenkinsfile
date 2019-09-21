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
                
                withDockerServer([uri: "tcp://<my-docker-socket>"]) {
                    withDockerRegistry([credentialsId: 'docker-registry-credentials', url: "https://<my-docker-registry>/"]) {
                        // we give the image the same version as the .war package
                        def image = docker.build("<myDockerRegistry>/<myDockerProjectRepo>:${branchVersion}", "--build-arg PACKAGE_VERSION=${branchVersion} ./tmp-docker-build-context")
                    image.push()
                    }   
                }
            }
        }
    }
}

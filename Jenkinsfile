pipeline {
    agent any
    tools {
        maven 'Maven' 
        jdk 'JDK'
        org.jenkinsci.plugins.docker.commons.tools.DockerTool 'docker'
    }  
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
                sh 'docker -version'
            }
        }
    }
}

pipeline {
    agent any
    tools {
        maven 'Maven' 
        jdk 'JDK'
        docker 'docker'
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

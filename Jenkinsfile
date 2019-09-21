pipeline {
    agent any
    tools {
        maven 'Maven' 
        jdk 'JDK'
    }  
    stages {
        stage('build') {
            sh 'mvn clean install'
        }
    }
}

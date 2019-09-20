pipeline {
    agent any
    tools {
        maven 'Maven' 
        java 'JDK'
    }  
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}

pipeline {
    agent any
    tools {
        maven 'Maven' 
        jdk 'JDK'
    }  
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}

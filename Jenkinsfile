#!/usr/bin/env groovy

pipeline {
    tools {
        maven 'Maven'
        jdk 'JDK'
        docker 'Docker'
    } 
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

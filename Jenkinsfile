#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK' 
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
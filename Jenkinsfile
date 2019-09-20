#!/usr/bin/env groovy

pipeline {
    /*
    agent any
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
    }*/
    agent {
        docker {
            image 'ubuntu'
        }
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
    }
}

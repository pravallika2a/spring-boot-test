pipeline {
    agent any
    tools {
        maven 'maven_latest'
        // jdk ''
    }
    stages {
        stage('Build') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/pravallika2a/spring-boot-test.git']]])
                    sh "mvn clean install"
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    sh "docker build -t sbt:v1.0.0 ."
                }
            }
        }
        stage('Post Image') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
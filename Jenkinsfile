pipeline {
    agent any
    toosl {
        maven 'maven_3_5_0'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/pravallika2a/spring-boot-test.git']]])
                }
            }
        }
        stage('Build Image') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Post Image') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
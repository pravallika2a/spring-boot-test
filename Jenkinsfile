pipeline {
    agent any
    tools {
        maven 'maven_latest'
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
                    sh "docker build -t edaraanand/sbt:v1.0.0 ."
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerHubPwd')]) {
                        sh "docker login -u edaraanand -p ${dockerHubPwd}"
                        sh "docker push edaraanand/sbt:v1.0.0"
                    }
                }
            }
        }
        stage('Deploy App') {
            steps {
                script {
                    def remote = [:]
                    remote.name = 'guntur'
                    remote.host = '192.168.1.72'
                    remote.allowAnyHosts = true
                    withCredentials([sshUserPrivateKey(credentialsId: 'gunturSshKey', keyFileVariable: 'sshKey', passphraseVariable: '', usernameVariable: 'sshUser')]) {
                        remote.user = sshUser
                        remote.identityFile = sshKey
                        sshCommand remote: remote, command: "docker stop hello-app || true && docker container prune -f && docker rmi edaraanand/sbt:v1.0.0 -f"
                        // sshCommand remote: remote, command: "docker container prune -f"
                        // sshCommand remote: remote, command: "docker edaraanand/sbt:v1.0.0 -f"
                        sshCommand remote: remote, sudo: true, command: "docker run -d --name hello-app -p 8085:8080 edaraanand/sbt:v1.0.0"
                    }
                }
            }
        }
    }
}

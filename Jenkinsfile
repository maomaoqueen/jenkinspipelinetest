pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    environment {
        PROJECT_NAME = 'pipelinetest'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-test', url: 'https://github.com/maomaoqueen/jenkinspipelinetest.git']]])
            }
        }
        stage('MavenCleanAndBuild') {
            tools {
                maven 'apache-maven-3.6.0'
            }
            steps {
                dir('pipelinetest/demo') {
                    echo 'Clean'
                    sh 'mvn clean'
                    echo 'Build'
                    sh 'mvn package'
                }   
            }
        }
        stage('DockerBuild') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    label 'docker'
                    args  '-v /tmp:/tmp'
                }
            }
            steps {
                sh 'docker ps'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker -v'
            }
        }
    }
}
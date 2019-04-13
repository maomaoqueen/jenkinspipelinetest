pipeline {
    agent any
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
                dockerfile {
                    dir 'pipelinetest/demo'
                    registryUrl '10.10.200.135:5000'
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
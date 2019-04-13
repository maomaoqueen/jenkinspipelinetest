pipeline {
    agent any
    environment {
        PROJECT_NAME = 'pipelinetest'
    }
    stages {
        stage('checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-test', url: 'https://github.com/maomaoqueen/jenkinspipelinetest.git']]])
            }
        }
        stage('CleanAndBuild') {
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
            steps {
                agent {
                    dockerfile {
                        dir 'pipelinetest/demo'
                        additionalBuildArgs "--build-arg ${BUILD_NUMBER}"
                        registryUrl '10.10.200.135:5000'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker -v'
            }
        }
    }
}
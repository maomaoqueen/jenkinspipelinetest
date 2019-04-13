pipeline {
    agent any
    options {
        // 设置保留的最大历史构建数为10
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    environment {
        PROJECT_NAME = 'pipelinetest'
        DOCKER_REGISTRY_URL = "10.10.200.135:5000"
    }
    stages {
        stage('Maven clean and build') {
            echo '111'
        }
        stage('Docker build') {
            echo '222'
        }
        stage('Deploy') {
            echo '333'
        }
    }
}
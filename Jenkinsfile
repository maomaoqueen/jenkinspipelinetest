pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    parameters {
        string(name: 'projectName', defaultValue: 'pipelinetest', description: '应用名称')
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
            steps {
                echo 'Staring to build docker image'
                dir('pipelinetest/demo') {
                    // 由于现阶段jenkins版本不支持声明式语法构建和推送docker镜像命令所以修改为脚本式语法
                    script {
                        docker.withRegistry('http://10.10.200.135:5000')
                        def appImage = docker.build("${projectName}:${env.BUILD_ID}")
                        appImage.push()
                    }
                }
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
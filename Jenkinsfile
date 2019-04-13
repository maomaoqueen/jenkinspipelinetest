pipeline {
    agent any
    options {
        // 设置保留的最大历史构建数为10
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    environment {
        PROJECT_NAME = 'pipelinetest'
    }
    stages {
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
                script {
                    dir('pipelinetest/demo'){
                        def appImage = docker.build("10.10.200.135:5000/${env.PROJECT_NAME}:${env.BUILD_ID}")
                        appImage.push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    def remote = [:]
                    remote.name = 'node-135'
                    remote.host = '10.10.200.135'
                    remote.allowAnyHosts = true

                    withCredentials([sshUserPrivateKey(credentialsId: '13752d77-c1e4-4eaa-90a7-175a5ec7608a', passwordVariable: 'password', usernameVariable: 'username')]) {
                        remote.user = username
                        remote.password = password

                        sshCommand remote: remote, command: "/usr/local/docker/build.sh --replication 2 --tag $BUILD_NUMBER --inner-port=6000 --outer-port=6000 --entrypoint=\"-Xmn512m -Xms1024m -Xmx2048m -Duser.timezone=GMT+08\"  10.10.200.135:5000/${PROJECT_NAME}"
                    }


                }
            }
        }
    }
}
pipeline {
    agent any
    options {
        // 设置保留的最大历史构建数为10
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    environment {
        PROJECT_NAME = 'pipelinetest'
        REGISTRY_URL = '10.10.200.135:5000'
    }
    stages {
        stage('clean and build') {
//            tools {
//                maven 'apache-maven-3.6.0'
//            }
            steps {
                echo '111'
//                dir('pipelinetest/demo') {
//                    echo 'Clean'
//                    sh 'mvn clean'
//                    echo 'Build'
//                    sh 'mvn package'
//                }
            }
            steps {
                echo '222'
            }
        }
        stage('xxxxxx') {
            steps {
                echo '333'
//                echo 'Staring to build docker image'
//
//                dir('pipelinetest/demo') {
//                    def appImage = docker.build("${REGISTRY_URL}/${env.PROJECT_NAME}:${env.BUILD_ID}")
//                    appImage.push()
//                }
//
//                sh "docker rmi ${REGISTRY_URL}/${env.PROJECT_NAME}:${env.BUILD_ID}"
            }
            steps {
                echo '444'
            }
        }
//        stage('Deploy') {
//            steps {
//                script {
//                    if (env.BRANCH_NAME != 'master') {
//                        def remote = [:]
//                        remote.name = 'node-135'
//                        remote.host = '10.10.200.135'
//                        remote.allowAnyHosts = true
//
//                        withCredentials([usernamePassword(credentialsId: '29126132-7287-498c-a9c2-f77b9e384ac3', passwordVariable: 'password', usernameVariable: 'username')]) {
//                            remote.user = username
//                            remote.password = password
//
//                            sshCommand remote: remote, command: "/usr/local/docker/build.sh --replication 2 --tag $BUILD_NUMBER --inner-port=6000 --outer-port=6000 --entrypoint=\"-Xmn512m -Xms1024m -Xmx2048m -Duser.timezone=GMT+08\"  ${REGISTRY_URL}/${PROJECT_NAME}"
//                        }
//                    } else {
//                        echo "branch name is ${env.BRANCH_NAME}"
//                        echo 'no need to deploy'
//                    }
//                }
//            }
//        }
    }
}
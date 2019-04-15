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
        stage('Clean and build') {
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

                script {
                    if (env.BRANCH_NAME != 'master') {
                        echo 'Staring to build docker image'
                        script {
                            dir('pipelinetest/demo') {
                                def appImage = docker.build("10.10.200.135:5000/${env.PROJECT_NAME}:${env.BUILD_ID}")
                                appImage.push()
                            }
                        }
                        echo 'delete current docker image'
                        echo "docker rmi 10.10.200.135:5000/${env.PROJECT_NAME}:${env.BUILD_ID}"
                        sh "docker rmi 10.10.200.135:5000/${env.PROJECT_NAME}:${env.BUILD_ID}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    if (env.BRANCH_NAME == 'develop') {
                        def remote = [:]
                        remote.name = 'node-135'
                        remote.host = '10.10.200.135'
                        remote.allowAnyHosts = true

                        withCredentials([usernamePassword(credentialsId: '29126132-7287-498c-a9c2-f77b9e384ac3', passwordVariable: 'password', usernameVariable: 'username')]) {
                            remote.user = username
                            remote.password = password

                            sshCommand remote: remote, command: "/usr/local/docker/build.sh --replication 2 --tag $BUILD_NUMBER --inner-port=6000 --outer-port=6000 --entrypoint=\"-Xmn512m -Xms1024m -Xmx2048m -Duser.timezone=GMT+08\"  ${DOCKER_REGISTRY_URL}/${PROJECT_NAME}"
                        }
                    } else if (env.BRANCH_NAME == 'test') {
                        echo "branch name is ${env.BRANCH_NAME}"
                        echo 'no need to deploy'
                    } else if (env.BRANCH_NAME == 'master') {
                        dir('pipelinetest/demo/target') {
                            sshPublisher(publishers: [sshPublisherDesc(configName: '10.10.200.133-SSH', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'ls -l', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'test.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                        }
                    }
                }
            }
        }
    }
}
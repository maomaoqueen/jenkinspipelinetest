pipeline {
    agent any
    stages {
		stage('checkout') {
		    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-test', url: 'https://github.com/maomaoqueen/jenkinspipelinetest.git']]])
		}
        stage('Clean&Build') {
            tools { 
                maven 'apache-maven-3.6.0'
            }
			steps {
				dir ('pipelinetest/demo'){
					echo 'Clean'
					sh 'mvn clean'
				}
			}
			steps {
				dir ('pipelinetest/demo'){
					echo 'Build'
					sh 'mvn package'
				}
			}
        }
		stage('Deploy') {
		    
		    sh 'docker -version'
		}
    }
}
pipeline {
    agent any
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
			    mvn -v
			}
		}
		stage('Deploy') {
		    steps {
				sh 'docker -v'
			}
		}
    }
}
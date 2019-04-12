pipeline {
    agent any
    stages {
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
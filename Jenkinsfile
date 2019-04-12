pipeline {
    agent any
    stages {
        stage('Clean&Build') {
            tools { 
                maven 'apache-maven-3.6.0'
            }
			dir ('pipelinetest/demo') {
				steps {
					echo 'Clean'
					sh 'mvn clean'
				}
				steps {
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
pipeline {
  agent any
  stages {
    stage('Stage 1') {
      parallel {
        stage('') {
          steps {
            echo 'Hello world!'
          }
        }
        stage('Clean&Build') {
          steps {
            tool(name: 'apache-maven-3.6.0', type: 'maven')
            dir(path: 'pipelinetest/demo') {
              sh '''echo \'Clean\'
sh \'mvn clean\''''
              sh '''echo \'Build\'
sh \'mvn package\''''
            }

          }
        }
      }
    }
  }
}
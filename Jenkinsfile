pipeline {
    agent any
    
    def mvnHome = tool name: 'maven-3-6', type: 'maven'
    
    stages {
        stage('Clean') {
            steps {
                sh("${mvnHome}/bin/mvn clean")
            }
        }
        stage('Tests') {
            steps {
                sh("${mvnHome}/bin/mvn test")
            }
        }
        stage('Package') {
            steps {
                sh("${mvnHome}/bin/mvn package")
            }
        }
    }
}

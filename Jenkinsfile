node {
    def mvnHome = tool name: 'maven', type: 'maven'
    
    stage ('Clear dependencies'){
        sh("mvn clean")
    }
    
    stage ('Running Tests'){
        sh("mvn test")
    }
    
    stage ('Packaging JAR'){
        sh("mvn package")
    }
}

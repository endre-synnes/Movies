node {
    def mvnHome = tool name: 'maven', type: 'maven'
    
    stage ('Clear dependencies'){
        sh("${mvnHome}/bin/mvn clean")
    }
    
    stage ('Running Tests'){
        sh("${mvnHome}/bin/mvn test")
    }
    
    stage ('Packaging JAR'){
        sh("${mvnHome}/bin/mvn package")
    }
}

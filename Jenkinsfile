node {
    def mvnHome = tool name: 'maven', type: 'maven'
    
    stage ('Clear dependencies'){
        sh("${mvnHome}/bin/mvn clean")
    }
}

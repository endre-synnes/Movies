node {
    
    stage ('Maven build'){
        def mvnHome = tool name: 'maven', type: 'maven'
        sh("${mvnHome}/bin/mvn package")
    }
}

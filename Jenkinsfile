node {
    
    stage ('Maven build'){
        steps {
            def mvnHome = tool name: 'maven', type: 'maven'
            sh("${mvnHome}/bin/mvn package")
        }
    }
}

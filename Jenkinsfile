node {
    
    stage 'Maven build'
    def mvnHome = tool name: 'maven-3-6', type: 'maven'
    sh("${mvnHome}/bin/mvn package")
}

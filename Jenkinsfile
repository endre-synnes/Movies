pipeline 
 {
  agent any

  tools {
    maven 'maven'
    jdk 'openjdk-11'
  }
  
  stages { 
    stage ('Clear dependencies'){
     steps {
       sh 'mvn clean'
     }
    }
   
   stage ('Running tests'){
     steps {
       sh 'mvn test'
     }
    }
   
   stage ('Packaging JAR'){
     steps {
       sh 'mvn package'
     }
    }
  }
     
}

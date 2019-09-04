pipeline 
 {
  agent any

  tools {
    maven 'maven'
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

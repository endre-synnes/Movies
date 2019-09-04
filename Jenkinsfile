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
  }
     
}

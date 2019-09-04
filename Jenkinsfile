pipeline 
 {
  agent any

  tools {
    maven 'maven'
  }
  
  stages { 
    stage ('Clear dependencies'){
      sh("mvn clean")
    }
  }
     
}

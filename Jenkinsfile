pipeline {
    agent any
   
    stages {
        stage('Build') {
            steps {
              
              
                bat 'mvn compile' 
                echo 'Compiled Successfully'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
                echo 'Tested Successfully'
            }
        }
        
           stage('Building Jar File') {
             steps {
                 bat 'mvn package'
                 echo 'JAR file  Successfully created'
             }
         }
        
      
    }
}

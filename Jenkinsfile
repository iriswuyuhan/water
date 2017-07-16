pipeline {
    agent any 
    tools {
        maven 'Maven'}
    stages {
        stage('Test') { 
            steps { 
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean sonar:sonar'}}}
        stage('Build') {
            steps {
                sh 'mvn package' 
                archive 'target/Water.war'}}
        stage('Deploy') {
            steps { 
                sh 'docker stop NoahsArk_Water || true' 
                sh 'docker rm NoahsArk_Water || true'
                sh 'docker run --name NoahsArk_Water -p 15432:8080 -d dordoka/tomcat'
                sh 'docker cp target/Water.war NoahsArk_Water:/opt/tomcat/webapps/'}}}}

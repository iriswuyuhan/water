pipeline {
    agent any 
    tools {
        maven ¡®Maven¡¯}
    stages {
        stage(¡®Test¡¯) { 
            steps { 
                withSonarQubeEnv(¡®SonarQube¡¯) {
                    sh ¡®mvn clean sonar:sonar¡¯}}}
        stage('Build') {
            steps {
                sh ¡®mvn package¡¯ 
                archive ¡®target/Water.war¡¯}}
        stage('Deploy') {
            steps { 
                sh ¡®docker stop Noah's Ark_Water || true¡¯ 
                sh ¡®docker rm Noah's Ark_Water || true¡¯ 
                sh ¡®docker run --name Noah's Ark_Water -p 11111:8080 -d dordoka/tomcat¡¯
                sh ¡®docker cp target/Water.war Noah's Ark_Water:/opt/tomcat/webapps/¡¯}}}}

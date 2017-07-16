pipeline {
    agent any //使用的执行节点
    tools {
        //定义工具，引号里的名字不能改，这个是管理员配置的名字
        maven ‘Maven’}
    stages {
        stage(‘Test’) { //stage表示一个阶段
            steps { //steps包含执行步骤
                //使用SonarQube环境，引号里的名字也不能改
                withSonarQubeEnv(‘SonarQube’) {
                    //执行Maven命令，清理后进行代码测试
                    sh ‘mvn clean sonar:sonar’}}}
        stage('Build') {
            steps {
                sh ‘mvn package’ //使用Maven打包
                //归档制品，可以在Jenkins项目主页看到并可以下载
                //需要修改制品的相对目录
                archive ‘target/Demo.war’}}
        stage('Deploy') {
            steps { //key是各自的项目ID
                sh ‘docker stop Water || true’ //停止之前的容器
                sh ‘docker rm Water || true’ //删除之前的容器
                //启动容器，冒号前面的端口号每个组要不同
                //dordoka/tomcat是镜像名
                sh ‘docker run --name Water -p 11111:8080 -d dordoka/tomcat’
                //将制品复制到容器内
                sh ‘docker cp target/Demo.war Water:/opt/tomcat/webapps/’}}}}

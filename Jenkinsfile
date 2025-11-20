pipeline {
    agent any

    environment {
        SONAR_HOST_URL = 'http://sonarqube:9000'
        SONAR_TOKEN = credentials('sonar') 
    }

    stages {
        stage('Stage 1: Hello') {
            steps {
                echo "Hello World from Stage 1!"
            }
        }

        stage('Stage 2: Build') {
            steps {
                // Compile Java project (Maven)
                sh "mvn clean compile"
            }
        }

        stage('Stage 3: SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                        sh """
                            ${tool 'SonarScanner'}/bin/sonar-scanner \
                            -Dsonar.projectKey=soanrQube \
                            -Dsonar.sources=. \
                            -Dsonar.java.binaries=target/classes \
                            -Dsonar.host.url=${SONAR_HOST_URL} \
                            -Dsonar.login=${SONAR_TOKEN}
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline finished!"
        }
    }
}

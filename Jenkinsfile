pipeline {
    agent any

    environment {
        // SonarQube server URL inside Docker Compose network
        SONAR_HOST_URL = 'http://sonarqube:9000'
        // Jenkins Credential ID for SonarQube token
        SONAR_TOKEN = credentials('sonar') 
    }

    stages {
        stage('Stage 1: Hello') {
            steps {
                echo "Hello World from Stage 1!"
            }
        }

        stage('Stage 2: SonarQube Analysis') {
            steps {
                script {
                    // Must match the name of your SonarQube installation in Jenkins
                    withSonarQubeEnv('SonarQube') {
                        // Use the SonarScanner tool installed automatically by Jenkins
                        sh """
                            ${tool 'SonarScanner'}/bin/sonar-scanner \
                            -Dsonar.projectKey=soanrQube \
                            -Dsonar.sources=. \
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

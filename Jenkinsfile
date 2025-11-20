pipeline {
    agent any

    environment {
        // SonarQube server URL (inside Docker Compose network)
        SONAR_HOST_URL = 'http://sonarqube:9000'
        // Jenkins credential ID for your SonarQube token
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
                    // Use the SonarQube environment configured in Jenkins
                    withSonarQubeEnv('SonarQube') { 
                        sh """
                            sonar-scanner \
                            -Dsonar.projectKey=my-project \
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


pipeline {
    agent any

    environment {
        SONAR_HOST_URL = 'http://sonarqube:9000'
        SONAR_TOKEN = credentials('sonar') // 'sonar' = the Jenkins credential ID you created
    }

    stages {
        stage('Hello') {
            steps {
                echo "Hello World from Stage 1!"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // must match the SonarQube server name in Jenkins
                    sh "sonar-scanner -Dsonar.projectKey=my-project -Dsonar.sources=. -Dsonar.host.url=${SONAR_HOST_URL} -Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline!!! finished!"
        }
    }
}


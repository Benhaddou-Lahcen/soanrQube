pipeline {
    agent any

    environment {
        // SonarQube server URL (dans ton réseau Docker Compose)
        SONAR_HOST_URL = 'http://sonarqube:9000'
        // Jenkins credential ID pour le jeton SonarQube
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
                // Utiliser Maven installé via Jenkins
                sh "${tool 'Maven'}/bin/mvn clean compile"
            }
        }

        stage('Stage 3: SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                        sh """
                            ${tool 'Maven'}/bin/mvn sonar:sonar \
                            -Dsonar.projectKey=soanrQube \
                            -Dsonar.host.url=$SONAR_HOST_URL \
                            -Dsonar.login=$SONAR_TOKEN
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline finished!!!!"
        }
    }
}

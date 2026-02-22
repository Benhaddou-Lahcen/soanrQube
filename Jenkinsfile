pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Stage 1: Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Stage 2: Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Stage 3: SonarQube Analysis') {
            steps {
                // Jenkins utilise ici l'URL 'http://sonarqube:9000' du menu System
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=soanrQube'
                }
            }
        }
    }

    post {
        always {
            echo "Analyse terminée pour Lahcen !"
        }
    }
}

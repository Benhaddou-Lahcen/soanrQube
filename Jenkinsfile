pipeline {
    agent any

    environment {
        // URL interne Docker (SANS ESPACE)
        SONAR_HOST_URL = 'http://sonarqube:9000'
        // Récupération de ton credential 'sonar'
        SONAR_TOKEN = credentials('sonar')
    }

    stages {
        stage('Stage 1: Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Stage 2: Build') {
            steps {
                echo 'Compilation du projet...'
                sh "${tool 'Maven'}/bin/mvn clean compile"
            }
        }

        stage('Stage 3: SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                        // COMMANDE CRITIQUE : Zéro espace après le signe '='
                        sh """
                            ${tool 'Maven'}/bin/mvn sonar:sonar \
                            -Dsonar.projectKey=soanrQube \
                            -Dsonar.host.url=${SONAR_HOST_URL} \
                            -Dsonar.token=${SONAR_TOKEN}
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline terminé pour le projet de Lahcen !"
        }
    }
}

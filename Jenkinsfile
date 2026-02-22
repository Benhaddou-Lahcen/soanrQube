pipeline {
    agent any

    environment {
        // URL interne du conteneur SonarQube dans ton réseau Docker
        SONAR_HOST_URL = 'http://sonarqube:9000'
        // Récupération sécurisée du jeton créé dans Jenkins
        SONAR_TOKEN = credentials('sonar')
    }

    stages {
        stage('Stage 1: Checkout') {
            steps {
                // Récupération de ton code depuis GitHub
                checkout scm
            }
        }

        stage('Stage 2: Build') {
            steps {
                echo 'Compilation du projet avec Maven...'
                // Utilise l'outil Maven 3.9.12 configuré dans Jenkins
                sh "${tool 'Maven'}/bin/mvn clean compile"
            }
        }

        stage('Stage 3: SonarQube Analysis') {
            steps {
                script {
                    // Injection de la configuration système SonarQube
                    withSonarQubeEnv('SonarQube') {
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

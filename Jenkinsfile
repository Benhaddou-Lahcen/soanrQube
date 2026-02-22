pipeline {
    agent any

    tools {
        // Doit correspondre au nom configuré dans Administrer Jenkins > Tools
        maven 'Maven'
    }

    stages {
        stage('Stage 1: Checkout') {
            steps {
                // Récupère le code depuis ton repo GitHub soanrQube
                checkout scm
            }
        }

        stage('Stage 2: Build') {
            steps {
                echo 'Compilation en cours...'
                sh 'mvn clean compile'
            }
        }

        stage('Stage 3: SonarQube Analysis') {
            steps {
                // Utilise la configuration "SonarQube" définie dans le menu System
                // (URL: http://sonarqube:9000)
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=soanrQube'
                }
            }
        }
    }

    post {
        always {
            // S'exécute après chaque build, quel que soit le résultat
            echo "Analyse terminée pour Lahcen !"
        }
        success {
            // Notifie le chef de projet (toi) seulement si tout est vert
            mail to: 'lahcenbenhaddou282@gmail.com',
                 subject: "Le projet de Lahcen est prêt pour revue (#${env.BUILD_NUMBER})",
                 body: """L'analyse SonarQube pour le projet tp-sonar est terminée avec succès.

Détails du build :
- Numéro : ${env.BUILD_NUMBER}
- Statut : SUCCESS
- Lien Jenkins : ${env.BUILD_URL}
- Lien SonarQube : https://sonar.lahcenbenhaddou.me/dashboard?id=soanrQube"""
        }
    }
}

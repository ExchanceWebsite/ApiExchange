pipeline {
    agent any

    stages {
        stage('Acessar Máquina Externa e Atualizar o Repositório') {
            steps {
                script {
                    sh "ssh -i /home/ubuntu/key-2210.pem ubuntu@ec2-3-221-247-133.compute-1.amazonaws.com"
                    sh "'cd /home/ubuntu/VmConfig/ && git pull'"
                }
            }
        }

        stage('Buildando imagen da API') {
            steps {
                script {
                       echo 'Build'
                }
            }
        }

        stage('Subindo container') {
            steps {
                script {
                       echo 'Sub'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline bem-sucedido!'
        }
        failure {
            echo 'Pipeline falhou!'
        }
    }
}

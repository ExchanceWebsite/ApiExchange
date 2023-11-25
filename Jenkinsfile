pipeline {
    agent any

    environment {
        REMOTE_USER = 'ubuntu'
        REMOTE_HOST = 'ec2-3-221-247-133.compute-1.amazonaws.com'
        REMOTE_DIR = '/home/ubuntu/VmConfig/'
    }

    stages {
        stage('Acessar Máquina Externa e Atualizar o Repositório') {
            steps {
                script {
                    sh """
                        sudo ssh -o StrictHostKeyChecking=no ${REMOTE_USER}@${REMOTE_HOST} 'cd ${REMOTE_DIR} && git pull'
                    """
                }
            }
        }

        stage('Buildando imagem da API') {
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


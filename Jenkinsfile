pipeline {
    agent any

    environment {
        REMOTE_USER = 'ubuntu'
        REMOTE_HOST = 'ec2-3-221-247-133.compute-1.amazonaws.com'
        REMOTE_DIR = '/home/ubuntu/VmConfig/'
        REMOTE_PASSWORD = 'urubu100' // Substitua com a senha real
    }

    stages {
        stage('Acessar Máquina Externa e Atualizar o Repositório') {
            steps {
                script {
                    // Configuração do SSH com senha e desativação de host key checking
                    sh """
                        sshpass -p ${REMOTE_PASSWORD} ssh -o StrictHostKeyChecking=no ${REMOTE_USER}@${REMOTE_HOST} 'cd ${REMOTE_DIR} && git pull'
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

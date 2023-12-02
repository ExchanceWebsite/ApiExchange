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
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'cd ${REMOTE_DIR} && git pull'"
                }
            }
        }

        stage('Buildando imagem da API') {
            steps {
                script {
                    echo 'Parando container...'
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker stop api-exchance'"
                    echo 'Deletando container antigo e imagem...'
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker rm api-exchance && sudo docker rmi exchance-api'"
                    echo 'Buildando nova imagem...'
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker build -t exchance-api /home/ubuntu/VmConfig/Api/'"
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker images && sudo docker ps'"
                }
            }
        }

        stage('Subindo container') {
            steps {
                script {
                    echo 'Contruindo o container...'
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker run --name api-exchance -p 443:443 -d  exchance-api'"
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker update --restart unless-stopped api-exchance'"
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker ps'"
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
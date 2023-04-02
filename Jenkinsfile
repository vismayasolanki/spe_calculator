pipeline{
    agent any



    environment{
        PATH = "/opt/homebrew/bin:$PATH"
        DOCKER_IMAGE = 'vismayasolanki/spe_mini_project_calc:latest'
        CONTAINER_NAME = 'spe_mini_project_calc'
        PORTS = '8080:80'
    }

    stages{
        stage('Clone Git'){
            steps{
                checkout scm
            }
        }

        stage('Build'){
            steps {
                sh "mvn clean package"
            }
        }

        stage('Test'){
            steps{
                 dir('/Users/vismayasolanki/Desktop/sem8/SPE/SPE_MINI_PROJECT') {
                    sh "mvn test"
                }

            }
        }
        stage('Containerize (Push to Dockerhub and pull from Dockerhub)') {
            steps {
                sh "/opt/homebrew/bin/docker build -t vismayasolanki/spe_mini_project_calc ."
                withCredentials([usernamePassword(credentialsId: 'docker_hub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh '/opt/homebrew/bin/docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh '/opt/homebrew/bin/docker push vismayasolanki/spe_mini_project_calc'
                }

            }
        }

        stage('Ansible Deployment') {
            steps {
                script {
                    sh 'ansible-playbook -i inventory deploy.yml'
                }
            }
        }

    }
}













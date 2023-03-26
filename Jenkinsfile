pipeline{
    agent any

     tools{
        maven 'MAVEN 3.9.0'
    }

    environment{
        PATH = "/opt/homebrew/bin:${PATH}"
        DOCKER_IMAGE = 'vismayasolanki/spe_mini_project_calc:latest'
        CONTAINER_NAME = 'spe_mini_project_calc'
    }

    stages{
        stage('Clone Git'){
            steps{
                git 'https://github.com/vismayasolanki/spe_calculator.git'
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
                 dir('/Users/vismayasolanki/Desktop/sem8/SPE/SPE_MINI_PROJECT/src/test') {
                    sh "mvn test"
                }

            }
        }
        stage('Containerize (Push to Dockerhub and pull from Dockerhub)') {
            steps {
                sh "docker build -t spe_calculator ."
                withCredentials([usernamePassword(credentialsId: 'docker_HUb', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
//                     sh 'docker tag project vismayasolanki/spe_mini_project_calc:latest'
                    sh 'docker push vismayasolanki/spe_mini_project_calc:latest'
                }
                sh 'docker pull vismayasolanki/spe_mini_project_calc:latest'

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













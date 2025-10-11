pipeline {
    agent any

    tools {
        maven 'M3'
        // java 'JDK11'
    }

    environment {
        MAVEN_SETTINGS = '/var/jenkins_home/.m2/settings.xml'
    }

    stages {
        stage('Aviso de Pull Request') {
            when {
                expression { env.CHANGE_ID != null }
            }
            steps {
                script {
                    def target = env.CHANGE_TARGET ?: ''
                    def source = env.CHANGE_BRANCH ?: ''
                    def autor = env.CHANGE_AUTHOR ?: 'desconocido'

                    if (target == 'develop' || target == 'release' || target.startsWith('project_release')) {
                        echo "🚀 Se ha creado o actualizado un Pull Request hacia la rama destino: ${target}"
                        echo "🔀 Origen del PR: ${source}"
                        echo "👤 Autor del PR: ${autor}"
                        echo "📦 Repositorio: ${env.GIT_URL}"
                        echo "🔗 Enlace del PR: ${env.CHANGE_URL ?: 'N/A'}"
                    } else {
                        echo "ℹ️ Pull Request detectado, pero no hacia develop/release/project_release → no se genera aviso."
                    }
                }
            }
        }

        stage('Compilación y Deploy Maven') {
            when {
                anyOf {
                    expression { env.CHANGE_ID != null } // Pull request
                    branch 'develop'
                    branch 'release'
                    expression { env.BRANCH_NAME?.startsWith('project_release') }
                }
            }
            steps {
                echo "🏗️ Iniciando construcción Maven en la rama ${env.BRANCH_NAME}..."
                dir('icbs-interface') {  // 👈 Aquí entramos a la carpeta del pom.xml
                    sh '''
                        echo "🧩 Ejecutando build con settings.xml personalizado"
                        mvn -s $MAVEN_SETTINGS clean package install deploy -U -DskipTests -DretryFailedDeploymentCount=5
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline finalizado correctamente para la rama o PR: ${env.BRANCH_NAME ?: env.CHANGE_ID}"
        }
        failure {
            echo "❌ Error durante la ejecución del pipeline."
        }
    }
}

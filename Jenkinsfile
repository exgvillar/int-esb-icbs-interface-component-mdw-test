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
                script {
                    echo "🏗️ Iniciando construcción Maven en la rama ${env.BRANCH_NAME ?: env.CHANGE_TARGET}..."

                    dir('icbs-interface') {
                        def target = env.BRANCH_NAME ?: env.CHANGE_TARGET ?: ''

                        if (target == 'develop') {
                            sh '''
                                echo "🧩 Ejecutando build con settings.xml personalizado (Perfil develop)"
                                mvn -s $MAVEN_SETTINGS clean package install deploy -U -Pdevelop -DskipTests -DretryFailedDeploymentCount=5
                            '''
                        } else if (target == 'release') {
                            sh '''
                                echo "🧩 Ejecutando build con settings.xml personalizado (Perfil release)"
                                mvn -s $MAVEN_SETTINGS clean package install deploy -U -Prelease -DskipTests -DretryFailedDeploymentCount=5
                            '''
                        } else if (target.startsWith('project_release')) {
                            sh '''
                                echo "🧩 Ejecutando build con settings.xml personalizado (Perfil project_release)"
                                mvn -s $MAVEN_SETTINGS clean package install deploy -U -Pproject_release -DskipTests -DretryFailedDeploymentCount=5
                            '''
                        } else {
                            echo "ℹ️ Rama ${target} no coincide con develop/release/project_release, no se ejecuta build Maven."
                        }
                    }
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

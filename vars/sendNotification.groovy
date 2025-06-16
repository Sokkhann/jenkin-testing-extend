def call(Map params = [:]) {
    def message = params.message ?: 'Build completed'
    def recipient = params.recipient ?: 'sokkhann.pol02@gamil.com'

    emailext (
        subject: "Jenkins Notification: ${env.JOB_NAME}",
        body: "${message}\n\nCheck build: ${env.BUILD_URL}",
        recipientProviders: [],
        to: recipient,
        mimeType: 'text/plain'
    )
}
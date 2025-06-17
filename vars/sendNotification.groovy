def call(Map params = [:]) {
    def message = params.message ?: 'Build completed'
    def chatId = params.chatId ?: '860211301'
    def botToken = params.botToken ?: '8060632961:AAGtD4G8MxzZnUDW9xfEAsi251gdwTtB-jw'

    def fullMessage = """
<b>${message}</b>
Job: ${env.JOB_NAME}
Build: ${env.BUILD_NUMBER}
URL: ${env.BUILD_URL}
"""

    sh """
    curl -s -X POST https://api.telegram.org/bot${botToken}/sendMessage  \\
    -d chat_id=${chatId} \\
    -d text="${fullMessage}" \\
    -d parse_mode="HTML"
    """
}
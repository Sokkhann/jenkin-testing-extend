def call(Map params = [:]) {
    def message = params.message ?: '✅ Build Successful!'
    def chatId = params.chatId ?: '860211301'
    def botToken = params.botToken ?: '8060632961:AAGtD4G8MxzZnUDW9xfEAsi251gdwTtB-jw'

    def jobName = env.JOB_NAME ?: 'N/A'
    def buildNumber = env.BUILD_NUMBER ?: 'N/A'
    def buildUrl = env.BUILD_URL ?: 'N/A'
    def timestamp = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))

    def fullMessage = """
<b>${message}</b> 🚀

<b>🛠 Job:</b> ${jobName}
<b>🔢 Build #:</b> <a href="${buildUrl}">${buildNumber}</a>
<b>🌐 URL:</b> <a href="${buildUrl}">View Build</a>
<b>📅 Time:</b> ${timestamp} UTC

<b>📝 Summary:</b>
The build completed successfully. 🎉 You can review the logs and artifacts at the URL above.
"""

    sh """
    curl -s -X POST https://api.telegram.org/bot${botToken}/sendMessage \\
    -d chat_id=${chatId} \\
    --data-urlencode "text=${fullMessage}" \\
    -d parse_mode="HTML"
    """
}

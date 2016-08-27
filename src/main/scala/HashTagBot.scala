import info.mukel.telegrambot4s.api.{Commands, TelegramBot, Webhook}
import info.mukel.telegrambot4s.methods.AnswerInlineQuery
import info.mukel.telegrambot4s.models._

import scala.io.Source

/**
  * @author Timur Kasatkin 
  * @date 24.08.16.
  * @email aronwest001@gmail.com
  * @email t.kasatkin@innopolis.ru
  */
object HashTagBot extends TelegramBot with Commands
	//	with Polling
	with Webhook
{
	override def token: String = Source.fromInputStream(getClass.getResourceAsStream("bot.token")).getLines.next

	override def handleInlineQuery(inlineQuery: InlineQuery): Unit = {
		if (inlineQuery.query.nonEmpty) {
			val result = "#" + inlineQuery.query.replaceAllLiterally(" ", "_")
			api.request(AnswerInlineQuery(inlineQuery.id, Seq(
				InlineQueryResultArticle("0", result, InputTextMessageContent(result)))))
		}
	}

	def main(args: Array[String]): Unit = this.run()

	override def port: Int = 80

	override def webhookUrl: String = "https://telegram-hashtag-bot.herokuapp.com"
}
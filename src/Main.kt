import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val myWork = MyStuff()
    myWork.run()
}

@Suppress("NAME_SHADOWING")
//@Suppress("NAME_SHADOWING")  используется для подавления предупреждения компилятора
// о скрытии имени переменной
// (shadowing). Shadowing происходит, когда переменная объявляется во внутреннем контексте
// (например, внутри цикла или блока кода) и имеет то же имя,
// что и переменная во внешнем   контексте.
class MyStuff {
    private fun maxSequenceLength(start: Long, end: Long): Int {
        var start = start
        var end = end
        if (start > end) {
            val temp = start
            start = end
            end = temp
        }
        var maxCount = 0
        for (i in start..end) {
            var num = i
            var count = 1
            while (num != 1L) {
                num = if (num % 2 == 0L) num / 2 else 3 * num + 1
                count ++
            }
            if (count > maxCount) {
                maxCount = count
            }
        }
        return maxCount
    }

    fun run() {
        try {
            val reader = BufferedReader(InputStreamReader(System.`in`)) // Чтение ввода
            var inputLine: String? // Строка для хранения введенных данных
            while (reader.readLine().also { inputLine = it } != null) {
                // split("\\s+".toRegex()) - разделяет строку на подстроки по любому количеству пробельных символов 1 2 1 3 -> [1, 2, 1, 3]
                // .toTypedArray() - преобразует результат в массив строк (преобразование списка в массив)
                // .trim() - удаляет пробелы в начале и в конце
                val tokens = inputLine!!.trim().split("\\s".toRegex()).toTypedArray() // Разбиваем строку на числа
                val start = tokens[0].toLong() // Начальное число последовательности
                val end = tokens[1].toLong() // Конечное число последовательности
                val maxLength = maxSequenceLength(start, end) // Находим максимальную длину последовательности
                println("$start $end $maxLength") // Выводим результат
            }
        } catch (e: Exception) {  println(e)  }
    }
}
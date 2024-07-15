
object printFibonacci extends App{
    def printFirstNFibonacci(n: Int): Unit = {
    def fibonacciHelper(a: Int, b: Int, n: Int): Unit = {
        if (n > 0) {
        print(s"$a ")
        fibonacciHelper(b, a + b, n - 1)
        }
    }

    fibonacciHelper(0, 1, n)
    }
    val n = 10 
    printFirstNFibonacci(n)
}

class Calculator
{
    public static void Execute(string op, int num1, int num2)
    {
        int result;
        switch (op)
        {
            case "+":
                result = num1 + num2;
                Console.WriteLine("Addition: " + result);
                break;
            case "-":
                result = num1 - num2;
                Console.WriteLine("Subtraction: " + result);
                break;
            case "*":
                result = num1 * num2;
                Console.WriteLine("Multiplication: " + result);
                break;
            case "/":
                result = num1 / num2;
                Console.WriteLine("Division: " + result);
                break;
            default:
                Console.WriteLine("Invalid Operator");
                break;
        }
    }
}
namespace Tarea3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Ejercicio 1: Abecedario.");
            Abecedario abc = new Abecedario();
            foreach (char c in abc)
            {
                Console.WriteLine(c);
            }

            Console.WritenLine("\nEjercicio 2: AbecedarioB.");
            Console.WritenLine("Ejercicio 2: Iteración vocales:");
            AbecedarioB abcB = new AbecedarioB();
            foreach (char c in abcB.GetVocals())
            {
                Console.WriteLine(c);
            }

            Console.WriteLine("\nEjercicio 3: Vocals.");
            Vocals voc = new Vocals();

            foreach (char c in voc)
            {
                Console.WriteLine(c);
            }
        }
    }
}

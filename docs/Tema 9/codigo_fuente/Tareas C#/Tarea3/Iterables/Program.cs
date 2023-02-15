using System;

namespace Estructuras
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] intArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

            System.Console.WriteLine()");
            intArr.Length

            Console.WriteLine("Probando la lista genérica:");

            List<string> lista = new List<string>();


            bool fin = false;
            do
            {
                System.Console.Write("Introduzca una palabra (ENTER para terminar): ");
                string palabra = Console.ReadLine();
                lista.Add(palabra);
            } while (!fin);

            System.Console.WriteLine("Las palabras guardadas en la lista son: ");
            System.Console.WriteLine(lista);

            System.Console.WriteLine("\nProbando la pila genérica:");

            Stack<string> pila = new Stack<string>();
            fin = false;
            do
            {
                System.Console.WriteLine("Introduzca una palara (ENTER para terminar): ");
                string palabra = Console.ReadLine();
                pila.Push(palabra);
            } while (!fin);

            System.Console.WriteLine("Extrayendo elementos de la pila:");
            while (pila.Count > 0)
            {
                Console.WriteLine($"Elemento: {pila.Pop()}.");
            }

            Queue<string> cola = new Queue<string>();
            fin = false;
            do
            {
                System.Console.Write("Introduzca una palabra (ENTER para terminar): ");
                string palabra = Console.ReadLine();
                cola.Enqueue(palabra);
            } while (!fin);
        }

    }
}

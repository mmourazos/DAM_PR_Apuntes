using System;

namespace Estructuras
{
    internal class ContenedorGenerico<T>
    {
        private T[] array;
        private int count;

        public ContenedorGenerico(int size)
        {
            array = new T[size];
            count = 0;
        }

        public void Add(T element)
        {
            if (count < array.Length)
            {
                array[count] = element;
                count++;
            }
        }

        public T Get(int index)
        {
            if (index < count)
            {
                return array[index];
            }
            else
            {
                throw new IndexOutOfRangeException();
            }
        }

        public void Set(int index, T element)
        {
            if (index < count)
            {
                array[index] = element;
            }
            else
            {
                throw new IndexOutOfRangeException();
            }
        }

        public int Count
        {
            get
            {
                return count;
            }
        }

        public T this[int index]
        {
            get
            {
                return Get(index);
            }
            set
            {
                Set(index, value);
            }
        }

    }
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] intArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

            System.Console.WriteLine($"Probando el array de enteros de {intArr.Length} elementos:");

            System.Console.WriteLine($"Total del array {intArr} es {intArr.Aggregate((acc, e) => acc + e)}");

            intArr.Where(e => e % 2 == 0).ToList().ForEach(e => System.Console.WriteLine(e));

            (int, string, string) miTupla = (1, "Hola", "Mundo");

            miTupla.CompareTo


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

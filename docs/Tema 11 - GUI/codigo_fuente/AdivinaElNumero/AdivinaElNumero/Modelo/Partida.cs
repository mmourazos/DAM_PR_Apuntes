using System;

namespace AdivinaElNumero.Modelo
{
    internal class Partida
    {
        private readonly int _numero;
        private int _intentos;

        private readonly int _min;
        private readonly int _max;

        public int Intentos { get { return _intentos; } }

        public int Min { get { return _min; } }

        public int Max { get { return _max; } }

        /// <summary>
        /// Devuelve cero si hemos acertado el número y la _distancia_ al número si no.
        /// </summary>
        /// <param name="numero"> El número que queremos comprobar.</param>
        /// <returns>La distancia al número buscado.</returns>
        public int Intento(int numero)
        {
            ++_intentos;
            return Math.Abs(_numero - numero);
        }

        public Partida(int min, int max) 
        { 
            _intentos = 0;
            _min = min;
            _max = max;

            Random random = new Random();

            _numero = random.Next(_min, _max + 1);
        }
    }   
}

using System;

namespace AdivinaElNumero.Modelo
{
    internal class Partida
    {
        private int _numero;
        private int _intentos;

        private int _min;
        private int _max;

        public bool Activa { get; set; }
        public int Intentos { get { return _intentos; } }

        public int Min { get { return _min; } }

        public int Max { get { return _max; } }

        public void NuevaPartida(int min, int max)
        {
            _intentos = 0;
            _min = min;
            _max = max;
            _numero = Math.Min(_min, _max);
            Activa = true;
        }

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

        public Partida()
        {
            Activa = false;
        }
    }
}

using System;
using System.CodeDom;

namespace AdivinaElNumero.Model
{
    internal class Partida
    {
        private int? _numero = null;

        private Random r;

        public int Min { get; set; }

        public int Max { get; set; }

        public int Intentos { get; set; }

        public void Reset()
        {
            _numero = r.Next(Min, Max);
            Intentos = 0;
        }

        public int Distancia(int numero)
        {                     
            return Math.Abs(_numero?? - numero);
        }
        public bool Encontrador(int numero)
        {
            return Distancia(numero) == 0;
        }
             
        public void IniciaPartida(int min, int max)
        {
            Intentos = 0;
            Min = min;
            Max = max;
            _numero = r.Next(Min, Max);
        }
        public Partida()
        {
            r = new Random(DateTime.Now.Millisecond);         
        }
    }
}

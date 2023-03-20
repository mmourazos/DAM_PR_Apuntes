using System;
using System.ComponentModel;

namespace AdivinaElNumero.Modelo
{
    internal class Partida : INotifyPropertyChanged
    {
        private int _numero;
        private int _intentos;

        private int _min;
        private int _max;
        private int _distancia;

        // Para poder avisar al _ViewModel_ de los cambios de propiedades (Intentos, Min y Max)
        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChange(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
            }

        }

        public int Intentos
        {
            get { return _intentos; }

            set
            {
                _intentos = value;
                OnPropertyChange(nameof(Intentos));
            }
        }

        public int Distancia
        {
            get { return _distancia; }
            set
            {
                _distancia = value;
                OnPropertyChange(nameof(Distancia));
            }
        }
        public int Min
        {
            get { return _min; }

            set
            {
                _min = value;
                OnPropertyChange(nameof(Min));
            }
        }

        public int Max
        {
            get { return _max; }

            set
            {
                _max = value;
                OnPropertyChange(nameof(Max));
            }
        }

        public void NuevaPartida(int min, int max)
        {
            Intentos = 0;
            Min = min;
            Max = max;
            _numero = Math.Min(_min, _max);
        }

        /// <summary>
        /// Devuelve cero si hemos acertado el número y la _distancia_ al número si no.
        /// </summary>
        /// <param name="numero"> El número que queremos comprobar.</param>
        /// <returns>La distancia al número buscado.</returns>
        public void Intento(int numero)
        {
            ++Intentos;
            Distancia = Math.Abs(_numero - numero);
        }
    }
}

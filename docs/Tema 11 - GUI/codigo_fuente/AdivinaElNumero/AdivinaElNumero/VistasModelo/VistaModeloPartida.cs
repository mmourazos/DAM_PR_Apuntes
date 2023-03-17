using AdivinaElNumero.Comandos;
using AdivinaElNumero.Modelo;
using System.Windows.Input;

namespace AdivinaElNumero.VistasModelo
{
    internal class VistaModeloPartida : ViewModelBase
    {
        private Partida _partida;

        private int _distancia;

        private int _numero;

        private int _intentos;

        private int _min;

        private int _max;

        public int Numero
        {
            get { return _numero; }

            set
            {
                _numero = value;
                OnPropertyChanged(nameof(Numero));
            }
        }

        public int Min
        {
            get { return _min; }

            set
            {
                _min = value;
                OnPropertyChanged(nameof(Min));
            }
        }

        public int Max
        {
            get
            {
                return _max;
            }
            set
            {
                _max = value;
                OnPropertyChanged(nameof(Max));
            }
        }

        public int Distancia
        {
            get { return _distancia; }
            set
            {
                _distancia = value;
                OnPropertyChanged(nameof(Distancia));
            }
        }

        public int Intentos
        {
            get
            {
                return _partida.Intentos;
            }

            set
            {
                _intentos = value;
                OnPropertyChanged(nameof(Intentos));
            }

        }

        public ICommand NewGameCommand { get; }

        public ICommand TryNumberCommand { get; }

        public ICommand ComandoSalir { get; }

        public VistaModeloPartida(Partida partida)
        {
            _partida = partida;

            NewGameCommand = new ComandoNuevaPartida(this, _partida);

            TryNumberCommand = new ComandoPruebaNumero(this, _partida);

            ComandoSalir = new ComandoCerrarAplicacion();
        }
    }
}

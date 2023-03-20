using AdivinaElNumero.Comandos;
using AdivinaElNumero.Modelo;
using System.ComponentModel;
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

        public string Min
        {
            get { return _min.ToString(); }

            set
            {
                if (value == string.Empty)
                {
                    _min = 0;
                }
                else
                    _min = int.Parse(value);
                OnPropertyChanged(nameof(Min));
            }

        }

        public string Max
        {
            get
            {
                return _max.ToString();
            }
            set
            {
                if (value == string.Empty)
                {
                    _max = 0;
                }
                else
                {
                    _max = int.Parse(value);
                }
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

            set { _intentos = value; }
        }

        // Necesito saber si el modelo ha cambiado.
        protected void ModelPropertyChanged(object source, PropertyChangedEventArgs e)
        {

            switch (e.PropertyName)
            {
                case nameof(Intentos):
                    Intentos = _partida.Intentos;
                    break;
                case nameof(Distancia):
                    Distancia = _partida.Distancia;
                    break;
                case nameof(Min):
                    Min = _partida.Min.ToString();
                    break;
                case nameof(Max):
                    Max = _partida.Max.ToString();
                    break;
                default:
                    break;
            }
            if (e.PropertyName == nameof(Intentos))
            {
                Intentos = _partida.Intentos;
            }


        }

        public ICommand NewGameCommand { get; }

        public ICommand TryNumberCommand { get; }

        public ICommand ComandoSalir { get; }

        public VistaModeloPartida(Partida partida)
        {
            _partida = partida;

            _partida.PropertyChanged += ModelPropertyChanged;

            NewGameCommand = new ComandoNuevaPartida(this, _partida);

            TryNumberCommand = new ComandoPruebaNumero(this, _partida);

            ComandoSalir = new ComandoCerrarAplicacion();
        }
    }
}

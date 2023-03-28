using AdivinaElNumero.Model;
using System.Security;

namespace AdivinaElNumero.ViewModels
{
    internal class PartidaViewModel : ViewModelBase
    {
        private Partida _partida;

        private int _min;
        public int Min
        {
            get
            {
                return _min;
            }

            set
            {
                _min = value;
                OnPropertyChanged(nameof(Min));
            }
        }

        private int _max;
        public int Max
        {
            get { return _max; }
            set
            {
                _max = value;
                OnPropertyChanged(nameof(Max));
            }
        }

        private int _numero;
        public int Numero {
            get { return _numero;  }

            set 
            {
                _numero = value;
                OnPropertyChanged(nameof(Numero));
            } 
        }

        private int _intentos;
        public int Intentos
        {
            get { return _intentos; }

            set
            {
                _intentos = value;
                OnPropertyChanged(nameof(Intentos));
            }
        }

        public PartidaViewModel(Partida partida)
        {
            _partida = partida;
        }

    }
}

using Reservations.Modelo;
using System;
using System.Windows.Input;

namespace Reservations.ViewModels
{
    class HacerReservaViewModel : ViewModelBase
    {
        private Hotel _hotel;

        private string _idUsuario;

        private int _numPlanta;

        private int _numHabitacion;

        private DateTime _fechaEntrada;

        private DateTime _fechaSalida;

        public string IDUsuario
        {
            get { return _idUsuario; }

            set
            {
                _idUsuario = value;
            }
        }

        public int NumPlanta
        {
            get { return _numPlanta; }

            set
            {
                _numPlanta = value;
            }
        }

        public int NumHabitacion
        {
            get { return _numHabitacion; }

            set
            {
                _numHabitacion = value;
            }
        }

        public string IDHabitación { get; set; }

        public DateTime FechaEntrada
        {
            get { return _fechaEntrada; }

            set
            {
                _fechaEntrada = value;
            }
        }

        public DateTime FechaSalida
        {
            get { return _fechaSalida; }

            set
            {
                _fechaSalida = value;
            }
        }

        // Comandos (también tienen que ser propiedades).
        // Sólo tendrán "get" pues sólo se leerán.
        // Se asignan en el constructor.
        public ICommand EnviarCommand { get; }

        public ICommand CancelarCommand { get; }

        public HacerReservaViewModel(Hotel hotel)
        {
            _hotel = hotel;
        }
    }
}

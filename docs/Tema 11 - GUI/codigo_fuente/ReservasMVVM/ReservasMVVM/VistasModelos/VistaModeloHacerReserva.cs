using ReservasMVVM.Modelo;
using System;
using System.Windows.Input;

namespace ReservasMVVM.VistasModelos
{
    internal class VistaModeloHacerReserva : VistaModeloBase
    {
        private Reserva _reserva;

        private int _numPlanta;
        private int _numHabitacion;
        private string _idHabiacion;
        private string _idCliente;
        private DateTime _fechaDeSalida;
        private DateTime _fechaDeEntrada;

        public string IDCliente
        {
            get
            {
                return _idCliente;
            }

            set
            {
                _idCliente = value;
                OnPropertyChanged(nameof(IDCliente));
            }
        }

        public int NumPlanta
        {
            get { return _numPlanta; }

            set
            {
                _numPlanta = value;
                OnPropertyChanged(nameof(NumPlanta));
            }
        }

        public int NumHabitacion
        {
            get { return _numHabitacion; }

            set
            {
                _numHabitacion = value;
                OnPropertyChanged(nameof(NumHabitacion));
            }
        }
        public string IDHabitacion
        {
            get
            {
                return _idHabiacion;
            }
            set
            {
                _idHabiacion = value;
                OnPropertyChanged(nameof(IDHabitacion));
            }
        }


        public DateTime FechaDeEntrada
        {
            get
            {
                return _fechaDeEntrada;
            }

            set
            {
                _fechaDeEntrada = value;
                OnPropertyChanged(nameof(FechaDeEntrada));
            }
        }

        public DateTime FechaDeSalida
        {
            get
            {
                return _fechaDeSalida;
            }

            set
            {
                _fechaDeSalida = value;
                OnPropertyChanged(nameof(FechaDeSalida));
            }
        }

        // Comandos

        public ICommand ComandoHacerReserva { get; }

        public ICommand ComandoCancelar { get; }

        public DateTime FechaEntrada { get; set; }

        public DateTime FechaSalida { get; set; }

        public TimeSpan DuracionEstancia => FechaSalida - FechaEntrada;
    }
}

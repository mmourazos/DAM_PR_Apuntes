using ReservasMVVM.Modelo;
using System;

namespace ReservasMVVM.VistasModelos
{
    internal class VistaModeloHacerReserva : VistaModeloBase
    {
        private Reserva _reserva;

        private string _idHabiacion;
        private string _idCliente;
        private DateTime _fechaDeSalida;
        private DateTime _fechaDeEntrada;

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

        public DateTime FechaEntrada { get; set; }

        public DateTime FechaSalida { get; set; }

        public TimeSpan DuracionEstancia => FechaSalida - FechaEntrada;
    }
}
